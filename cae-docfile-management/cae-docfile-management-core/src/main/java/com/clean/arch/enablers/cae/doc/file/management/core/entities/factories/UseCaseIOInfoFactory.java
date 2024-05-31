package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.UseCaseIOInfo;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.UseCaseIOInfoImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UseCaseIOInfoFactory implements EntityFactory<UseCaseIOInfo> {

    public static final UseCaseIOInfoFactory SINGLETON = new UseCaseIOInfoFactory();

    @Override
    public UseCaseIOInfo makeNewInstance(){
        return new UseCaseIOInfoImplementation();
    }

}
