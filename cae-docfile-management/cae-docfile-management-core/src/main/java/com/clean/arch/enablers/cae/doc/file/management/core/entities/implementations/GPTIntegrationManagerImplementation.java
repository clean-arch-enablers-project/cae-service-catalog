package com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations;

import com.cae.env_vars.EnvVarRetriever;
import com.cae.env_vars.exceptions.MissingEnvVarException;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.GPTIntegrationManager;
import com.clean.arch.enablers.cae.doc.file.management.core.required_env_vars.RequiredEnvVars;


public class GPTIntegrationManagerImplementation extends GPTIntegrationManager {

    @Override
    public boolean allowsGPTIntegration() {
        try {
            EnvVarRetriever.getEnvVarByNameAsString(RequiredEnvVars.CAE_GPT_CLIENT_HOST);
            return true;
        } catch (MissingEnvVarException missingEnvVarException){
            return false;
        }
    }
}
