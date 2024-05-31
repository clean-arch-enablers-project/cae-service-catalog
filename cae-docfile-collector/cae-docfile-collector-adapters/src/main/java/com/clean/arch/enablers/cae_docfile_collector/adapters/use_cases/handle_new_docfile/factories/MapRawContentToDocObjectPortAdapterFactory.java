package com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.factories;

import com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.MapRawContentToDocObjectPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapRawContentToDocObjectPortAdapterFactory {

    public static final MapRawContentToDocObjectPortAdapter V1 = new MapRawContentToDocObjectPortAdapter();

}
