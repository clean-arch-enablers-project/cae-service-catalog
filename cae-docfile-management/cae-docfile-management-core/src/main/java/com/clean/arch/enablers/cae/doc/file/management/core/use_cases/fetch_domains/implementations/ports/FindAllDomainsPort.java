package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domains.implementations.ports;

import com.cae.ports.specifics.functions.FunctionPort;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public abstract class FindAllDomainsPort extends FunctionPort<FindAllDomainsPort.Input, FindAllDomainsPort.Output> {

    @Getter
    @Builder
    public static class Input{
        private final Integer page;
        private final Integer pageSize;
    }

    @Getter
    @Builder
    public static class Output{
        public final List<Domain> domains;
        public final Boolean lastPage;
    }

}
