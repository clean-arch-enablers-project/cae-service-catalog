package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.adapters.local_client.LocalClient;
import com.clean.arch.enablers.cae.doc.file.management.adapters.object_mapper.ObjectMapperProvider;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports.DomainRetrievementByIdPort;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public class DomainRetrievementByIdPortLocalAdapter extends DomainRetrievementByIdPort {
    @Override
    protected Optional<Domain> executeLogic(String input, UseCaseExecutionCorrelation correlation) {
        return LocalClient.retrieveDomainContentById(input).map(this::mapToDomainFormat);
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
