package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.io.outputs;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class FetchDomainsUseCaseOutput {

    private final List<Domain> domains;
    private final Integer page;
    private final Integer pageSize;
    private final Boolean lastPage;

}
