package com.clean.arch.enablers.cae.doc.file.management.adapters.local_client;

import com.cae.env_vars.EnvVarRetriever;
import com.cae.loggers.native_io_extraction_mode.json.SimpleJsonBuilder;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.required_env_vars.RequiredEnvVars;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalClient {

    public static String getRootLocation(){
        var folderLocation = EnvVarRetriever.getEnvVarByNameAsString(RequiredEnvVars.CAE_DOCFILES_DIRECTORY)
                .replace("\\", File.separator)
                .replace("/", File.separator)
                .replace("\\\\", File.separator)
                .replace("//", File.separator);
        return folderLocation.concat(folderLocation.endsWith(File.separator)? "" : File.separator);
    }

    public static Optional<String> retrieveDomainContentById(String domainId){
        var fullQualifiedPath = LocalClient.getFullQualifiedPathFor(domainId);
        var path = Paths.get(fullQualifiedPath);
        if (Files.exists(path))
            return Optional.ofNullable(LocalClient.getRawContentFrom(path));
        return Optional.empty();
    }

    private static String getRawContentFrom(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new InternalMappedException(
                    "Something went wrong while trying to retrieve file",
                   e.toString()
            );
        }
    }

    public static void write(Domain domain){
        var domainId = domain.getId();
        var fullQualifiedPath = LocalClient.getFullQualifiedPathFor(domainId);
        try (var fileWriter = new BufferedWriter(new FileWriter(fullQualifiedPath))){
            fileWriter.write(SimpleJsonBuilder.buildFor(domain));
            fileWriter.newLine();
        } catch (IOException e) {
            throw new InternalMappedException(
                    "Something went wrong while trying to open file for writing domain",
                    e.toString()
            );
        }
    }

    public static String getFullQualifiedPathFor(String domainId){
        var folderLocation = LocalClient.getRootLocation();
        return folderLocation.concat(domainId)
                .concat(".json");
    }

    public static PaginationResultSet getAllPaginated(Integer page, Integer pageSize){
        var total = LocalClient.getTotalSize();
        try (var innerObjects = Files.list(Paths.get(LocalClient.getRootLocation()))){
            var rows = innerObjects.filter(Files::isRegularFile)
                    .skip((long) (page - 1) * pageSize)
                    .limit(pageSize)
                    .map(LocalClient::getRawContentFrom)
                    .collect(Collectors.toList());
            return PaginationResultSet.builder()
                    .rows(rows)
                    .isLast((total / pageSize) <= page)
                    .build();
        } catch (IOException e) {
            throw new InternalMappedException(
                    "Something went wrong while trying to list files",
                    "More details: " + e
            );
        }
    }

    private static long getTotalSize() {
        try (var innerObjects = Files.list(Paths.get(LocalClient.getRootLocation()))){
            return innerObjects.filter(Files::isRegularFile).count();
        } catch (IOException e){
            throw new InternalMappedException(
                    "Something went wrong while trying to count files",
                    "More details: " + e
            );
        }
    }

    @Builder
    @Getter
    public static class PaginationResultSet{
        private final List<String> rows;
        private Boolean isLast;
    }

}
