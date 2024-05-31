package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.io.inputs;

import com.cae.use_cases.autodocumentation.DomainDocumentation;
import com.cae.use_cases.io.UseCaseInput;
import com.cae.use_cases.io.annotations.NotBlankInputField;
import com.cae.use_cases.io.annotations.NotNullInputField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AcceptDocfileContentUseCaseInput extends UseCaseInput {

    @NotNullInputField
    private DomainDocumentation newDoc;

    @NotNullInputField
    private List<String> useCasesWithNewWorkflow;

    @NotNullInputField
    @NotBlankInputField
    private String domainId;

}