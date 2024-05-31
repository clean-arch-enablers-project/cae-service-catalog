package com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.fetch_domain_by_id;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domain_by_id.factories.FindDomainByIdPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.FetchDomainByIdUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.implementations.FetchDomainByIdUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FetchDomainByIdUseCaseAssembler implements UseCaseAssembler<FetchDomainByIdUseCase>{

    public static final FetchDomainByIdUseCaseAssembler SINGLETON_ASSEMBLER = new FetchDomainByIdUseCaseAssembler();

    public static final FetchDomainByIdUseCase V1 = new FetchDomainByIdUseCaseImplementation(
            FindDomainByIdPortAdapterFactory.LOCAL_BASED
    );;

    @Override
    public FetchDomainByIdUseCase getDefaultAssembledInstance(){
        return V1;
    }
}