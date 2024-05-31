package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domains;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.adapters.local_client.LocalClient;
import com.clean.arch.enablers.cae.doc.file.management.adapters.object_mapper.ObjectMapperProvider;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.implementations.ports.FindAllDomainsPort;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.stream.Collectors;

public class FindAllDomainsPortLocalAdapter extends FindAllDomainsPort {

    @Override
    protected Output executeLogic(Input input, UseCaseExecutionCorrelation correlation) {
        var paginationResultSet = LocalClient.getAllPaginated(input.getPage(), input.getPageSize());
        var domains = paginationResultSet
                .getRows()
                .stream()
                .map(this::mapToDomainFormat)
                .collect(Collectors.toList());
        return Output.builder()
                .domains(domains)
                .lastPage(paginationResultSet.getIsLast())
                .build();
    }

    private Domain mapToDomainFormat(String rawContent) {
        try {
            return ObjectMapperProvider.MAPPER.readValue(rawContent, Domain.class);
        } catch (JsonProcessingException e) {
            throw new InternalMappedException(
                    "Something went wrong while trying to map raw content to Domain instance",
                    "More details: " + e
            );
        }
    }
}
