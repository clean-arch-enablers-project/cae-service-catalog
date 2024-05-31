package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class GPTIntegrationManager  implements Entity {

    public abstract boolean allowsGPTIntegration();

}
