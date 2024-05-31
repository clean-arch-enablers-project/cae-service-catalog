package com.clean_arch_enablers.cae_docfile_collector.core.entities;

import com.cae.entities.Entity;
import com.cae.use_cases.autodocumentation.DomainDocumentation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class DocfileCollector implements Entity {

    public abstract void moveOldDocToTemporaryLocation();
    protected abstract String collectTheNewDocContent();
    protected abstract String collectTheOldDocContent();
    public abstract Boolean anyDifferencesBetweenOldAndNew();
    public abstract DomainDocumentation mapNewUseCaseDocumentationUsing(DomainDocumentationMapper mapper);
    public abstract DomainDocumentation mapOldUseCaseDocumentationUsing(DomainDocumentationMapper mapper);
    public abstract List<String> getUseCasesWithNewWorkflow(DomainDocumentationMapper domainDocumentationMapper);
    public abstract DomainDocumentation getNewDoc();


    @FunctionalInterface
    public interface DomainDocumentationMapper {

        DomainDocumentation handle(String rawContent);

    }

}
