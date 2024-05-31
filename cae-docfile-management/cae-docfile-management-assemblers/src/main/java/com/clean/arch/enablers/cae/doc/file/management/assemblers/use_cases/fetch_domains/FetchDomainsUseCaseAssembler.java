package com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.fetch_domains;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domains.factories.FindAllDomainsPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.FetchDomainsUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.implementations.FetchDomainsUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FetchDomainsUseCaseAssembler implements UseCaseAssembler<FetchDomainsUseCase>{

    public static final FetchDomainsUseCaseAssembler SINGLETON_ASSEMBLER = new FetchDomainsUseCaseAssembler();

    public static final FetchDomainsUseCase V1 = new FetchDomainsUseCaseImplementation(
            FindAllDomainsPortAdapterFactory.LOCAL_BASED
    );

    @Override
    public FetchDomainsUseCase getDefaultAssembledInstance(){
        return V1;
    }
}