package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public abstract class Version  implements Entity, Comparable<Version> {

    protected Integer id;
    protected String domainName;
    protected List<UseCaseInfo> useCases;
    protected LocalDateTime since;

}
