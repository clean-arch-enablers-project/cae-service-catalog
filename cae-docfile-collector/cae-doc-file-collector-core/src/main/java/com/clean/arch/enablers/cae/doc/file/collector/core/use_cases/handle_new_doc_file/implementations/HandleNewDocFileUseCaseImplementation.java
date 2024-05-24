package com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.core.entities.DocFileCollector;
import com.clean.arch.enablers.cae.doc.file.collector.core.entities.factories.DocFileCollectorFactory;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.HandleNewDocFileUseCase;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports.MapRawContentToDocObjectPort;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports.RetrieveDomainIdPort;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports.SubmitNewDocFileContentPort;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class HandleNewDocFileUseCaseImplementation extends HandleNewDocFileUseCase {

    private final MapRawContentToDocObjectPort mapRawContentToDocObjectPort;
    private final RetrieveDomainIdPort retrieveDomainIdPort;
    private final SubmitNewDocFileContentPort submitNewDocFileContentPort;

    @Override
    protected void applyInternalLogic(UseCaseExecutionCorrelation correlation) {
        var docCollector = DocFileCollectorFactory.SINGLETON.makeNewInstance();
        if (Boolean.TRUE.equals(docCollector.anyDifferencesBetweenOldAndNew())){
            var submissionInput = SubmitNewDocFileContentPort.Input.builder()
                    .workflowHasChanged(docCollector.checkIfAnyInternalWorkflowHasChanged(this.getMapperInterface(correlation)))
                    .newDoc(docCollector.getNewDoc())
                    .domainId(this.retrieveDomainIdPort.executePort(correlation))
                    .build();
            this.submitNewDocFileContentPort.executePortOn(submissionInput, correlation);
        }
    }

    private DocFileCollector.DomainDocumentationMapper getMapperInterface(UseCaseExecutionCorrelation correlation){
        return content -> this.mapRawContentToDocObjectPort.executePortOn(content, correlation);
    }

}