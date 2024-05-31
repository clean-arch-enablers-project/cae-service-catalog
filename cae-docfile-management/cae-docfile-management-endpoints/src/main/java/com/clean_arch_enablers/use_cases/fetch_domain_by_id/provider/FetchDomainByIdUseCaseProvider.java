package com.clean_arch_enablers.use_cases.fetch_domain_by_id.provider;

import com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.fetch_domain_by_id.FetchDomainByIdUseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.FetchDomainByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FetchDomainByIdUseCaseProvider {

    @Bean
    public FetchDomainByIdUseCase fetchDomainByIdUseCase(){
        return FetchDomainByIdUseCaseAssembler.SINGLETON_ASSEMBLER.getDefaultAssembledInstance();
    }

}
