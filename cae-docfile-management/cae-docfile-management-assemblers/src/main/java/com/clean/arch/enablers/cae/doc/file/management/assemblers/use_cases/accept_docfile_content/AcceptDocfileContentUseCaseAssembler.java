package com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.accept_docfile_content;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.factories.DomainRetrievementByIdPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.factories.GPTIntegrationPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.factories.StoreNewDocPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.AcceptDocfileContentUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.AcceptDocfileContentUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AcceptDocfileContentUseCaseAssembler implements UseCaseAssembler<AcceptDocfileContentUseCase>{

    public static final AcceptDocfileContentUseCaseAssembler SINGLETON_ASSEMBLER = new AcceptDocfileContentUseCaseAssembler();

    public static final AcceptDocfileContentUseCase V1 = new AcceptDocfileContentUseCaseImplementation(
            GPTIntegrationPortAdapterFactory.AWS_BASED,
            DomainRetrievementByIdPortAdapterFactory.LOCAL_BASED,
            StoreNewDocPortAdapterFactory.LOCAL_BASED
    );

    @Override
    public AcceptDocfileContentUseCase getDefaultAssembledInstance(){
        return V1;
    }
}