package com.clean.arch.enablers.cae_docfile_collector.assemblers.use_cases.handle_new_docfile;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.factories.MapRawContentToDocObjectPortAdapterFactory;
import com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.factories.RetrieveDomainIdPortAdapterFactory;
import com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.factories.SubmitNewDocFileContentPortAdapterFactory;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.HandleNewDocfileUseCase;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.HandleNewDocfileUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandleNewDocfileUseCaseAssembler implements UseCaseAssembler<HandleNewDocfileUseCase>{

    public static final HandleNewDocfileUseCaseAssembler SINGLETON_ASSEMBLER = new HandleNewDocfileUseCaseAssembler();

    public static final HandleNewDocfileUseCase V1 = new HandleNewDocfileUseCaseImplementation(
            MapRawContentToDocObjectPortAdapterFactory.V1,
            RetrieveDomainIdPortAdapterFactory.V1,
            SubmitNewDocFileContentPortAdapterFactory.V1
    );

    @Override
    public HandleNewDocfileUseCase getDefaultAssembledInstance(){
        return V1;
    }
}