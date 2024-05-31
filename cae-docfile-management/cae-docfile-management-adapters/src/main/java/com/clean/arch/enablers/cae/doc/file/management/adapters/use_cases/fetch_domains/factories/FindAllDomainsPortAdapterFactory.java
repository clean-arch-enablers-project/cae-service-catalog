package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domains.factories;

import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domains.FindAllDomainsPortLocalAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FindAllDomainsPortAdapterFactory {

    public static final FindAllDomainsPortLocalAdapter LOCAL_BASED = new FindAllDomainsPortLocalAdapter();

}
