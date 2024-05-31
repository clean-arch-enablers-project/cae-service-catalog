package com.clean_arch_enablers.cae_docfile_collector.core.entities.factories;

import com.clean_arch_enablers.cae_docfile_collector.core.entities.DocfileCollector;
import com.clean_arch_enablers.cae_docfile_collector.core.entities.implementations.DocfileCollectorImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocfileCollectorFactory implements EntityFactory<DocfileCollector> {

    public static final DocfileCollectorFactory SINGLETON = new DocfileCollectorFactory();

    @Override
    public DocfileCollector makeNewInstance(){
        return new DocfileCollectorImplementation();
    }

}
