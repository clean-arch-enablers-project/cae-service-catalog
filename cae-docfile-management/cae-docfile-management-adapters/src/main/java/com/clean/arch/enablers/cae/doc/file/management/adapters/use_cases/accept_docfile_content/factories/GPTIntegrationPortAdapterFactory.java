package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.factories;

import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.GPTIntegrationPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GPTIntegrationPortAdapterFactory {

    public static final GPTIntegrationPortAdapter AWS_BASED = new GPTIntegrationPortAdapter();

}
