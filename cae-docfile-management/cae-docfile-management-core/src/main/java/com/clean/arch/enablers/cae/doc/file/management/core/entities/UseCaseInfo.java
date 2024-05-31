package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class UseCaseInfo  implements Entity {

    protected String useCaseDeclaration;
    protected String useCaseImplementation;
    protected String useCaseDeclarationLocation;
    protected String useCaseImplementationLocation;
    protected String description;
    protected String useCaseSourceCode;
    protected Boolean isProtected;
    protected List<String> scopes;
    protected List<UseCaseIOInfo> ioContract;
    
}
