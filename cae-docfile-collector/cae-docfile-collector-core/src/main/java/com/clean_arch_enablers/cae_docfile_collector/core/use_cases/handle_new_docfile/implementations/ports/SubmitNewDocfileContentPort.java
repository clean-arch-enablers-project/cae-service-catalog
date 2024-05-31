package com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.ports;

import com.cae.ports.specifics.consumers.ConsumerPort;
import com.cae.use_cases.autodocumentation.DomainDocumentation;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public abstract class SubmitNewDocfileContentPort extends ConsumerPort<SubmitNewDocfileContentPort.Input> {

    @Builder
    @Getter
    public static class Input{
        private final DomainDocumentation newDoc;
        private final String domainId;
        private final List<String> useCasesWithNewWorkflow;
    }

}
