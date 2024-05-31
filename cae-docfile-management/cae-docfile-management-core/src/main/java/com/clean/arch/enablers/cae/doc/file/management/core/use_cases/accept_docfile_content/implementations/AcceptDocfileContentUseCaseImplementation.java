package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations;

import com.cae.mapped_exceptions.specifics.InputMappedException;
import com.cae.use_cases.autodocumentation.DomainDocumentation;
import com.cae.use_cases.autodocumentation.UseCaseDocumentation;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.factories.DomainFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.factories.GPTIntegrationManagerFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.AcceptDocfileContentUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.mappers.VersionMapper;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports.DomainRetrievementByIdPort;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports.GPTIntegrationPort;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports.StoreNewDocPort;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.io.inputs.AcceptDocfileContentUseCaseInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AcceptDocfileContentUseCaseImplementation extends AcceptDocfileContentUseCase {

    private static final VersionMapper VERSION_MAPPER = VersionMapper.SINGLETON;

    private final GPTIntegrationPort gptIntegrationPort;
    private final DomainRetrievementByIdPort domainRetrievementByIdPort;
    private final StoreNewDocPort storeNewDocPort;

    @Override
    protected void applyInternalLogic(
            AcceptDocfileContentUseCaseInput input,
            UseCaseExecutionCorrelation correlation) {
        var gptIntegrationManager = GPTIntegrationManagerFactory.SINGLETON.makeNewInstance();
        if (gptIntegrationManager.allowsGPTIntegration())
            this.executeGPTIntegrationUpon(input, correlation);
        var newVersion = VERSION_MAPPER.mapToDomainFrom(input);
        var domain = this.getDomainFor(input, correlation);
        domain.addVersion(newVersion);
        this.storeNewDocPort.executePortOn(domain, correlation);
    }

    private void executeGPTIntegrationUpon(AcceptDocfileContentUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        input.getUseCasesWithNewWorkflow().
                stream()
                .map(namedUseCase -> this.getUseCaseDocFrom(input.getNewDoc(), namedUseCase))
                .forEach(newUseCase -> {
                    var gptOutput = this.gptIntegrationPort.executePortOn(new GPTIntegrationPort.Input(newUseCase.getUseCaseSourceCode()), correlation);
                    newUseCase.setDescription(gptOutput.getDescription());
                });
    }

    private Domain getDomainFor(AcceptDocfileContentUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var previousVersions = this.domainRetrievementByIdPort.executePortOn(input.getDomainId(), correlation);
        if (previousVersions.isEmpty()){
            var domain = DomainFactory.SINGLETON.makeNewInstance();
            domain.setId(input.getDomainId());
            return domain;
        }
        return previousVersions.get();
    }

    private UseCaseDocumentation getUseCaseDocFrom(DomainDocumentation newDoc, String namedUseCase) {
        return newDoc.getUseCases()
                .stream()
                .filter(useCase -> useCase.getUseCaseDeclaration().equals(namedUseCase))
                .findFirst()
                .orElseThrow(() -> new InputMappedException("Use case '" + namedUseCase + "' was not found among instances within documentation"));
    }
}
