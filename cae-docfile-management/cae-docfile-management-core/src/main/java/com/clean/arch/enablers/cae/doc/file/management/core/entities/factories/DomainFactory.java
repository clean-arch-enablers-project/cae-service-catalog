package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.DomainImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainFactory implements EntityFactory<Domain> {

    public static final DomainFactory SINGLETON = new DomainFactory();

    @Override
    public Domain makeNewInstance(){
        return new DomainImplementation();
    }

}
