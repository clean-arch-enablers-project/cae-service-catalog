package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.UseCaseInfo;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.UseCaseInfoImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UseCaseInfoFactory implements EntityFactory<UseCaseInfo> {

    public static final UseCaseInfoFactory SINGLETON = new UseCaseInfoFactory();

    @Override
    public UseCaseInfo makeNewInstance(){
        return new UseCaseInfoImplementation();
    }

}
