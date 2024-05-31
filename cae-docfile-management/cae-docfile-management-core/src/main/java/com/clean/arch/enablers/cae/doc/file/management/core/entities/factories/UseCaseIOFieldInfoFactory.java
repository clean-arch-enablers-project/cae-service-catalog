package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.UseCaseIOFieldInfo;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.UseCaseIOFieldInfoImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UseCaseIOFieldInfoFactory implements EntityFactory<UseCaseIOFieldInfo> {

    public static final UseCaseIOFieldInfoFactory SINGLETON = new UseCaseIOFieldInfoFactory();

    @Override
    public UseCaseIOFieldInfo makeNewInstance(){
        return new UseCaseIOFieldInfoImplementation();
    }

}
