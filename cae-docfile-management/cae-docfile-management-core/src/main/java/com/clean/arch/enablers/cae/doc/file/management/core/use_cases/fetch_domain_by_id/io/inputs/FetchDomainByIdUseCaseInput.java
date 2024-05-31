package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.io.inputs;

import com.cae.use_cases.io.UseCaseInput;
import com.cae.use_cases.io.annotations.NotBlankInputField;
import com.cae.use_cases.io.annotations.NotNullInputField;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FetchDomainByIdUseCaseInput extends UseCaseInput {

    @NotNullInputField
    @NotBlankInputField
    private final String id;

}