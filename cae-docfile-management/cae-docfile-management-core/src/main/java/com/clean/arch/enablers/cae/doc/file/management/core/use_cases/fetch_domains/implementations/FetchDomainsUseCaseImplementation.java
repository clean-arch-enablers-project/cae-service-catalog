package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.implementations;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.FetchDomainsUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.implementations.ports.FindAllDomainsPort;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.io.inputs.FetchDomainsUseCaseInput;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.io.outputs.FetchDomainsUseCaseOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FetchDomainsUseCaseImplementation extends FetchDomainsUseCase{

    private final FindAllDomainsPort findAllDomainsPort;

    @Override
    protected FetchDomainsUseCaseOutput applyInternalLogic(FetchDomainsUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var portInput = FindAllDomainsPort.Input.builder()
                .page(input.getPage())
                .pageSize(input.getPageSize())
                .build();
       var allDomainsPerPage = this.findAllDomainsPort.executePortOn(portInput, correlation);
       return FetchDomainsUseCaseOutput.builder()
               .domains(allDomainsPerPage.getDomains())
               .page(input.getPage())
               .pageSize(input.getPageSize())
               .lastPage(allDomainsPerPage.getLastPage())
               .build();
    }
}