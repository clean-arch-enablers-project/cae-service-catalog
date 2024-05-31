package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.adapters.local_client.LocalClient;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports.StoreNewDocPort;

public class StoreNewDocPortLocalAdapter extends StoreNewDocPort {

    @Override
    protected void executeLogic(Domain input, UseCaseExecutionCorrelation correlation) {
        LocalClient.write(input);
    }
}
