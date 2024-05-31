package com.clean.arch.enablers.cae_docfile_collector.assemblers.use_cases.handle_old_docfile;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_old_docfile.HandleOldDocfileUseCase;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_old_docfile.implementations.HandleOldDocfileUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandleOldDocfileUseCaseAssembler implements UseCaseAssembler<HandleOldDocfileUseCase>{

    public static final HandleOldDocfileUseCaseAssembler SINGLETON_ASSEMBLER = new HandleOldDocfileUseCaseAssembler();

    public static final HandleOldDocfileUseCase V1 = new HandleOldDocfileUseCaseImplementation();

    @Override
    public HandleOldDocfileUseCase getDefaultAssembledInstance(){
        return V1;
    }
}