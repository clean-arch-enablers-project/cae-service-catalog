package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.io.outputs;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FetchDomainByIdUseCaseOutput {

    private final Domain domain;

}
