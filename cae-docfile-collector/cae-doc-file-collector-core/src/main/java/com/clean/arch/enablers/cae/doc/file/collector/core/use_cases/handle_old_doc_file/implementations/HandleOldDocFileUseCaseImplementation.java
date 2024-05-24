package com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_old_doc_file.implementations;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.core.entities.factories.DocFileCollectorFactory;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_old_doc_file.HandleOldDocFileUseCase;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class HandleOldDocFileUseCaseImplementation extends HandleOldDocFileUseCase {

    @Override
    protected void applyInternalLogic(UseCaseExecutionCorrelation useCaseExecutionCorrelation) {
        var docFile = DocFileCollectorFactory.SINGLETON.makeNewInstance();
        docFile.moveOldDocToTemporaryLocation();
    }
}