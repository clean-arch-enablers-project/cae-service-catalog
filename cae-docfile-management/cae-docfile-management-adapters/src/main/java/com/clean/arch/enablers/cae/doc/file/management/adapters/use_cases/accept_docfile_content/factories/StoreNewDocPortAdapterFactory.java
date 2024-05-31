package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.factories;

import com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content.StoreNewDocPortLocalAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreNewDocPortAdapterFactory {

    public static final StoreNewDocPortLocalAdapter LOCAL_BASED = new StoreNewDocPortLocalAdapter();

}
