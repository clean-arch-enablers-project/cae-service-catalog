package com.clean_arch_enablers.use_cases.fech_domains.provider;

import com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.fetch_domains.FetchDomainsUseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.FetchDomainsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FetchDomainsUseCaseProvider {

    @Bean
    public FetchDomainsUseCase fetchDomainsUseCase(){
        return FetchDomainsUseCaseAssembler.SINGLETON_ASSEMBLER.getDefaultAssembledInstance();
    }

}
