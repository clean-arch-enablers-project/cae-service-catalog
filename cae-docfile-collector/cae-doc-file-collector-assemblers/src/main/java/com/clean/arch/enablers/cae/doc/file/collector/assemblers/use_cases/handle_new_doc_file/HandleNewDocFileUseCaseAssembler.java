package com.clean.arch.enablers.cae.doc.file.collector.assemblers.use_cases.handle_new_doc_file;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.factories.MapRawContentToDocObjectPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.factories.RetrieveDomainIdPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.factories.SubmitNewDocFileContentPortAdapterFactory;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.HandleNewDocFileUseCase;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.HandleNewDocFileUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandleNewDocFileUseCaseAssembler implements UseCaseAssembler<HandleNewDocFileUseCase>{

    public static final HandleNewDocFileUseCaseAssembler SINGLETON_ASSEMBLER = new HandleNewDocFileUseCaseAssembler();

    public static final HandleNewDocFileUseCase V1 = new HandleNewDocFileUseCaseImplementation(
            MapRawContentToDocObjectPortAdapterFactory.V1,
            RetrieveDomainIdPortAdapterFactory.V1,
            SubmitNewDocFileContentPortAdapterFactory.V1
    );

    @Override
    public HandleNewDocFileUseCase getDefaultAssembledInstance(){
        return V1;
    }
}