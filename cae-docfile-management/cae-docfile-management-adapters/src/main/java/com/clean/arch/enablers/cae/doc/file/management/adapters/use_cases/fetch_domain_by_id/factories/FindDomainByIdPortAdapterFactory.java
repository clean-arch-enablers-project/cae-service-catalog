package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domain_by_id.factories;

import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.fetch_domain_by_id.FindDomainByIdPortLocalAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FindDomainByIdPortAdapterFactory {

    public static FindDomainByIdPortLocalAdapter LOCAL_BASED = new FindDomainByIdPortLocalAdapter();

}
