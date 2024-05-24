package com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.adapters.env_vars.EnvironmentVariables;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports.RetrieveDomainIdPort;

public class RetrieveDomainIdPortAdapter extends RetrieveDomainIdPort {

    @Override
    protected String executeLogic(UseCaseExecutionCorrelation correlation) {
        return EnvironmentVariables.getDomainId();
    }
}
