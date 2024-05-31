package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
public abstract class Domain  implements Entity {

    protected String id;
    protected String latestName;
    protected List<Version> versions = new ArrayList<>();
    protected ResponsibleTeam responsibleTeam;

    public abstract Optional<Version> getLatestVersion();
    public abstract void addVersion(Version version);

}
