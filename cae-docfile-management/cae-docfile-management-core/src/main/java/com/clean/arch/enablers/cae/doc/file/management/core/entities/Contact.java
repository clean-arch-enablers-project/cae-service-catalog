package com.clean.arch.enablers.cae.doc.file.management.core.entities;

import com.cae.entities.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Contact  implements Entity {

    protected String via;
    protected String address;

}
