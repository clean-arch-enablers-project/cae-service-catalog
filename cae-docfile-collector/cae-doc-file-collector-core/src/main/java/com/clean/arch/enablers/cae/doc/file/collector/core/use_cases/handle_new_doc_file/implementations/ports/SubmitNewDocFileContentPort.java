package com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports;

import com.cae.ports.specifics.consumers.ConsumerPort;
import com.cae.use_cases.autodocumentation.DomainDocumentation;
import lombok.Builder;
import lombok.Getter;

public abstract class SubmitNewDocFileContentPort extends ConsumerPort<SubmitNewDocFileContentPort.Input> {

    @Builder
    @Getter
    public static class Input{
        private final DomainDocumentation newDoc;
        private final Boolean workflowHasChanged;
        private final String domainId;
    }

}
