package com.clean.arch.enablers.cae_docfile_collector.adapters.env_vars;

import com.cae.env_vars.EnvVarRetriever;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentVariables {

    public static String getCaeDocManagementHost(){
        return EnvVarRetriever.getEnvVarByNameAsString("CAE_DOC_MANAGEMENT_HOST");
    }

    public static String getDomainId(){
        return EnvVarRetriever.getEnvVarByNameAsString("CAE_DOMAIN_ID");
    }

}
