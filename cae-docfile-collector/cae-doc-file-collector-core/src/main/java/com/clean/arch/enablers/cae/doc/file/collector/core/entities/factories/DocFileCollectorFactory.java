package com.clean.arch.enablers.cae.doc.file.collector.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.collector.core.entities.DocFileCollector;
import com.clean.arch.enablers.cae.doc.file.collector.core.entities.implementations.DocFileCollectorImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocFileCollectorFactory implements EntityFactory<DocFileCollector> {

    public static final DocFileCollectorFactory SINGLETON = new DocFileCollectorFactory();

    @Override
    public DocFileCollector makeNewInstance(){
        return new DocFileCollectorImplementation();
    }

}
