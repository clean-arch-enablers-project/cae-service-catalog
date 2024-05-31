package com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.factories;

import com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile.SubmitNewDocfileContentPortAdapter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubmitNewDocFileContentPortAdapterFactory {

    public static final SubmitNewDocfileContentPortAdapter V1 = new SubmitNewDocfileContentPortAdapter();

}
