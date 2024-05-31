package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.factories;

import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.DomainRetrievementByIdPortLocalAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainRetrievementByIdPortAdapterFactory {

    public static final DomainRetrievementByIdPortLocalAdapter LOCAL_BASED = new DomainRetrievementByIdPortLocalAdapter();

}
