package com.clean.arch.enablers.cae.doc.file.collector.assemblers.use_cases.handle_old_doc_file;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_old_doc_file.HandleOldDocFileUseCase;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_old_doc_file.implementations.HandleOldDocFileUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandleOldDocFileUseCaseAssembler implements UseCaseAssembler<HandleOldDocFileUseCase>{

    public static final HandleOldDocFileUseCaseAssembler SINGLETON_ASSEMBLER = new HandleOldDocFileUseCaseAssembler();

    public static final HandleOldDocFileUseCase V1 = new HandleOldDocFileUseCaseImplementation();

    @Override
    public HandleOldDocFileUseCase getDefaultAssembledInstance(){
        return V1;
    }
}