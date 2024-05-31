package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.implementations;

import com.cae.mapped_exceptions.specifics.NotFoundMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.FetchDomainByIdUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.implementations.ports.FindDomainByIdPort;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.io.inputs.FetchDomainByIdUseCaseInput;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.io.outputs.FetchDomainByIdUseCaseOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FetchDomainByIdUseCaseImplementation extends FetchDomainByIdUseCase{

    private final FindDomainByIdPort findDomainByIdPort;

    @Override
    protected FetchDomainByIdUseCaseOutput applyInternalLogic(FetchDomainByIdUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var domain = this.findDomainByIdPort.executePortOn(input.getId(), correlation)
                .orElseThrow(() -> new NotFoundMappedException("Domain of ID '" + input.getId() + "' was not found"));
        return FetchDomainByIdUseCaseOutput.builder()
                .domain(domain)
                .build();
    }
}