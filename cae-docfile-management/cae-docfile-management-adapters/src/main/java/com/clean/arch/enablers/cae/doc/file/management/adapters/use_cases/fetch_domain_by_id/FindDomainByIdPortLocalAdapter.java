package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domain_by_id;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.adapters.local_client.LocalClient;
import com.clean.arch.enablers.cae.doc.file.management.adapters.object_mapper.ObjectMapperProvider;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.implementations.ports.FindDomainByIdPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindDomainByIdPortLocalAdapter extends FindDomainByIdPort {

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
