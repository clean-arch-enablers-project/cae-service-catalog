package com.clean_arch_enablers.use_cases.accept_docfile_content.providers;

import com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.accept_docfile_content.AcceptDocfileContentUseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.AcceptDocfileContentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcceptDocFileContentUseCaseProvider {

    @Bean
    public AcceptDocfileContentUseCase acceptDocFileContentUseCase(){
        return AcceptDocfileContentUseCaseAssembler.SINGLETON_ASSEMBLER.getDefaultAssembledInstance();
    }

}
