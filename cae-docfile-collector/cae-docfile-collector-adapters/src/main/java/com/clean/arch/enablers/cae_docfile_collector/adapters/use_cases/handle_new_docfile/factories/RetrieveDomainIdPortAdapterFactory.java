package com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.factories;

import com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.RetrieveDomainIdPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RetrieveDomainIdPortAdapterFactory {

    public static final RetrieveDomainIdPortAdapter V1 = new RetrieveDomainIdPortAdapter();

}
