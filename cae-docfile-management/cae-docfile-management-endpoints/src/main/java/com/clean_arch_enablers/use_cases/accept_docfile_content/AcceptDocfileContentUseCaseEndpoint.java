    package com.clean_arch_enablers.use_cases.accept_docfile_content;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.AcceptDocfileContentUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.io.inputs.AcceptDocfileContentUseCaseInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/domains")
@RequiredArgsConstructor
public class AcceptDocfileContentUseCaseEndpoint {

    private final AcceptDocfileContentUseCase useCase;

    @PostMapping
    public ResponseEntity<Void> execute(
            @RequestBody AcceptDocfileContentUseCaseInput useCaseInput,
            @RequestHeader String correlationId){
        this.useCase.execute(useCaseInput, UseCaseExecutionCorrelation.of(correlationId));
        return ResponseEntity.status(201).build();
    }

}
