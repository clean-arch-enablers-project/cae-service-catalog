package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.GPTIntegrationManager;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.GPTIntegrationManagerImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GPTIntegrationManagerFactory implements EntityFactory<GPTIntegrationManager> {

    public static final GPTIntegrationManagerFactory SINGLETON = new GPTIntegrationManagerFactory();

    @Override
    public GPTIntegrationManager makeNewInstance(){
        return new GPTIntegrationManagerImplementation();
    }

}
