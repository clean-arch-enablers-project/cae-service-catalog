package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class UseCaseIOInfo  implements Entity {

    protected String className;
    protected Boolean input;
    private List<UseCaseIOFieldInfo> classFields;

}
