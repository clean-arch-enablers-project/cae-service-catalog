package com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.factories;

import com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file.MapRawContentToDocObjectPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapRawContentToDocObjectPortAdapterFactory {

    public static final MapRawContentToDocObjectPortAdapter V1 = new MapRawContentToDocObjectPortAdapter();

}
