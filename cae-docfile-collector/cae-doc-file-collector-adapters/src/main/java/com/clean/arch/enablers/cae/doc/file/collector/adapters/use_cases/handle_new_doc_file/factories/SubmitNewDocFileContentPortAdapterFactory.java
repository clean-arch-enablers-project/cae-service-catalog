package com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.factories;

import com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.SubmitNewDocFileContentPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubmitNewDocFileContentPortAdapterFactory {

    public static final SubmitNewDocFileContentPortAdapter V1 = new SubmitNewDocFileContentPortAdapter();

}
