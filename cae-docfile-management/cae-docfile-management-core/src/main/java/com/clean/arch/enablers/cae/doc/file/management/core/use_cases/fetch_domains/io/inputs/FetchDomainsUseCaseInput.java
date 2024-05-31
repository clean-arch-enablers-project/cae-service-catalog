package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.io.inputs;

import com.cae.use_cases.io.UseCaseInput;
import com.cae.use_cases.io.annotations.NotNullInputField;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FetchDomainsUseCaseInput extends UseCaseInput {

    @NotNullInputField
    private final Integer page;
    @NotNullInputField
    private final Integer pageSize;

}