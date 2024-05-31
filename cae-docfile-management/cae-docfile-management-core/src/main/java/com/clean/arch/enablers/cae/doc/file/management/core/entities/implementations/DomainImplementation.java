package com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Version;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


public class DomainImplementation extends Domain {

    @Override
    public Optional<Version> getLatestVersion() {
        if (this.versions.isEmpty())
            return Optional.empty();
        Collections.sort(this.versions);
        return Optional.of(this.versions.get(0));
    }

    @Override
    public void addVersion(Version newVersion) {
        this.latestName = newVersion.getDomainName();
        var latestVersion = this.getLatestVersion();
        if (latestVersion.isEmpty())
            newVersion.setId(1);
        else
            newVersion.setId(latestVersion.get().getId() + 1);
        newVersion.setSince(LocalDateTime.now());
        var versions = Optional.ofNullable(this.versions).orElse(new ArrayList<>());
        versions.add(newVersion);
        this.versions = versions;
    }
}
