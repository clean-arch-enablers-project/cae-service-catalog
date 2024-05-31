package com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae_docfile_collector.adapters.env_vars.EnvironmentVariables;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.ports.RetrieveDomainIdPort;

public class RetrieveDomainIdPortAdapter extends RetrieveDomainIdPort {

    @Override
    protected String executeLogic(UseCaseExecutionCorrelation correlation) {
        return EnvironmentVariables.getDomainId();
    }
}
