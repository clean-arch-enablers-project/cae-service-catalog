package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class UseCaseIOFieldInfo  implements Entity {

    protected String fieldName;
    protected String fieldType;
    protected Boolean isNotNull;
    protected Boolean isNotBlank;
    protected Boolean isNotEmpty;
    protected Boolean isSensitive;
    
}
