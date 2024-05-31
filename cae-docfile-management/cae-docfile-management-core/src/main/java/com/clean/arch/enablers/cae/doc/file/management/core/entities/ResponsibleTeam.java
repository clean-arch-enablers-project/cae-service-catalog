package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class ResponsibleTeam  implements Entity {

    protected String name;
    protected List<Contact> contacts;
    protected List<TeamMember> members;

}
