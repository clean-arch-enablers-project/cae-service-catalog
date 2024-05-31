package com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean_arch_enablers.cae_docfile_collector.core.entities.DocfileCollector;
import com.clean_arch_enablers.cae_docfile_collector.core.entities.factories.DocfileCollectorFactory;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.HandleNewDocfileUseCase;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.ports.MapRawContentToDocObjectPort;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.ports.RetrieveDomainIdPort;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.ports.SubmitNewDocfileContentPort;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class HandleNewDocfileUseCaseImplementation extends HandleNewDocfileUseCase {

    private final MapRawContentToDocObjectPort mapRawContentToDocObjectPort;
    private final RetrieveDomainIdPort retrieveDomainIdPort;
    private final SubmitNewDocfileContentPort submitNewDocFileContentPort;

    @Override
    protected void applyInternalLogic(UseCaseExecutionCorrelation correlation) {
        var docCollector = DocfileCollectorFactory.SINGLETON.makeNewInstance();
        if (Boolean.TRUE.equals(docCollector.anyDifferencesBetweenOldAndNew())){
            var submissionInput = SubmitNewDocfileContentPort.Input.builder()
                    .useCasesWithNewWorkflow(docCollector.getUseCasesWithNewWorkflow(this.getMapperInterface(correlation)))
                    .newDoc(docCollector.getNewDoc())
                    .domainId(this.retrieveDomainIdPort.executePort(correlation))
                    .build();
            this.submitNewDocFileContentPort.executePortOn(submissionInput, correlation);
        }
    }

    private DocfileCollector.DomainDocumentationMapper getMapperInterface(UseCaseExecutionCorrelation correlation){
        return content -> this.mapRawContentToDocObjectPort.executePortOn(content, correlation);
    }

}