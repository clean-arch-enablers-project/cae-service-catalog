package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Version;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.VersionImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionFactory implements EntityFactory<Version> {

    public static final VersionFactory SINGLETON = new VersionFactory();

    @Override
    public Version makeNewInstance(){
        return new VersionImplementation();
    }

}
