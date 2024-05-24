package com.clean.arch.enablers.cae.doc.file.collector.core.entities.implementations;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.mapped_exceptions.specifics.NotFoundMappedException;
import com.cae.use_cases.autodocumentation.DomainDocumentation;
import com.cae.use_cases.autodocumentation.UseCaseDocumentation;
import com.clean.arch.enablers.cae.doc.file.collector.core.entities.DocFileCollector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Optional;


public class DocFileCollectorImplementation extends DocFileCollector {

    private static final String RELATIVE_PATH = System.getProperty("user.dir");
    private static final String DEFAULT_DOC_FILE_NAME = "cae-doc-file.json";
    private static final String TEMP_DOC_FILE_NAME = "old-doc-file.json";
    private static final Path PATH_TO_CURRENT_FILE = Paths.get(RELATIVE_PATH, DEFAULT_DOC_FILE_NAME);
    private static final Path PATH_TO_OLD_FILE = Paths.get(RELATIVE_PATH, TEMP_DOC_FILE_NAME);

    private String oldContent;
    private String newContent;
    private DomainDocumentationMapper domainDocumentationMapper;
    private DomainDocumentation newDoc;

    @Override
    public void moveOldDocToTemporaryLocation() {
        if (Files.exists(PATH_TO_CURRENT_FILE)){
            try{
                Files.move(PATH_TO_CURRENT_FILE, PATH_TO_OLD_FILE, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException exception){
                throw new InternalMappedException(
                        "Something went wrong while trying to move current file to temporary path,",
                        "More details: " + exception.getMessage()
                );
            }
        }
    }

    @Override
    protected String collectTheNewDocContent() {
        if (Files.exists(PATH_TO_CURRENT_FILE)) {
            try {
                return Files.readString(PATH_TO_CURRENT_FILE);
            } catch (IOException exception) {
                throw new InternalMappedException(
                        "Something went wrong while trying to collect the new doc content.",
                        "More details about it: " + exception
                );
            }
        } else throw new NotFoundMappedException(
                    "The doc file was not found.",
                    "The location it was expected to be at: " + PATH_TO_CURRENT_FILE
            );
    }

    @Override
    protected String collectTheOldDocContent() {
        if (Files.exists(PATH_TO_OLD_FILE)){
            try {
                return Files.readString(PATH_TO_OLD_FILE);
            } catch (IOException exception) {
                throw new InternalMappedException(
                        "Something went wrong while trying to collect the old doc content.",
                        "Its location: " + PATH_TO_OLD_FILE + " | Original exception thrown: " + exception
                );
            }
        } else return "";
    }

    @Override
    public Boolean anyDifferencesBetweenOldAndNew() {
        this.newContent = this.collectTheNewDocContent();
        this.oldContent = this.collectTheOldDocContent();
        return !newContent.equals(oldContent);
    }

    @Override
    public DomainDocumentation mapNewUseCaseDocumentationUsing(DomainDocumentationMapper mapper) {
        var theNewContent = Optional.ofNullable(this.newContent).orElseGet(this::collectTheNewDocContent);
        return mapper.handle(theNewContent);
    }

    @Override
    public DomainDocumentation mapOldUseCaseDocumentationUsing(DomainDocumentationMapper mapper) {
        var theOldContent = Optional.ofNullable(this.oldContent).orElseGet(this::collectTheOldDocContent);
        return mapper.handle(theOldContent);
    }

    @Override
    public Boolean checkIfAnyInternalWorkflowHasChanged(DomainDocumentationMapper mapper) {
        this.domainDocumentationMapper = mapper;
        this.newDoc = this.mapNewUseCaseDocumentationUsing(mapper);
        var oldDoc = this.mapOldUseCaseDocumentationUsing(mapper);
        return Optional.ofNullable(this.newDoc.getUseCases())
                .orElse(new ArrayList<>())
                .stream()
                .map(UseCaseDocumentation::getUseCaseSourceCode)
                .anyMatch(newSourceCode -> Optional.ofNullable(oldDoc.getUseCases()).orElse(new ArrayList<>()).stream().map(UseCaseDocumentation::getUseCaseSourceCode).noneMatch(newSourceCode::equals));
    }

    @Override
    public DomainDocumentation getNewDoc() {
        return Optional.ofNullable(this.newDoc)
                .orElseGet(() -> this.mapNewUseCaseDocumentationUsing(this.domainDocumentationMapper));
    }

}
