package com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.factories;

import com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.RetrieveDomainIdPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RetrieveDomainIdPortAdapterFactory {

    public static final RetrieveDomainIdPortAdapter V1 = new RetrieveDomainIdPortAdapter();

}
