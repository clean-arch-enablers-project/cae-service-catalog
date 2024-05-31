package com.clean_arch_enablers.use_cases.fetch_domain_by_id;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.FetchDomainByIdUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.io.inputs.FetchDomainByIdUseCaseInput;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.io.outputs.FetchDomainByIdUseCaseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/domains")
public class FetchDomainByIdUseCaseEndpoint {

    private final FetchDomainByIdUseCase useCase;

    @GetMapping("/{domainId}")
    public ResponseEntity<FetchDomainByIdUseCaseOutput> execute(
            @PathVariable String domainId,
            @RequestHeader String correlationId){
        var useCaseInput = FetchDomainByIdUseCaseInput.builder()
                .id(domainId)
                .build();
        var useCaseOutput = this.useCase.execute(useCaseInput, UseCaseExecutionCorrelation.of(correlationId));
        return ResponseEntity.status(200).body(useCaseOutput);
    }

}
