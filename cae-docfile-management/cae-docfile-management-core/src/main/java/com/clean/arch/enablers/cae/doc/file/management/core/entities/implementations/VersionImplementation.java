package com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Version;


public class VersionImplementation extends Version {

    @Override
    public int compareTo(Version o) {
        return this.getId().compareTo(o.getId());
    }
}
