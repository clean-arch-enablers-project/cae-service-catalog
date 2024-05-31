package com.clean_arch_enablers.use_cases.fech_domains;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.FetchDomainsUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.io.inputs.FetchDomainsUseCaseInput;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.io.outputs.FetchDomainsUseCaseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/domains")
@RestController
public class FetchDomainsUseCaseEndpoint {

    private final FetchDomainsUseCase useCase;

    @GetMapping
    public ResponseEntity<FetchDomainsUseCaseOutput> execute(
            @RequestHeader String correlationId,
            @RequestParam Integer page,
            @RequestParam Integer pageSize){
        var useCaseInput = FetchDomainsUseCaseInput.builder()
                .page(page)
                .pageSize(pageSize)
                .build();
        var useCaseOutput = this.useCase.execute(useCaseInput, UseCaseExecutionCorrelation.of(correlationId));
        return ResponseEntity.ok().body(useCaseOutput);
    }

}
