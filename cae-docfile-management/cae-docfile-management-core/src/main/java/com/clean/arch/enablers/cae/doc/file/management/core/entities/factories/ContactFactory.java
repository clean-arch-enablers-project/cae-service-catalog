package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.Contact;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.ContactImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactFactory implements EntityFactory<Contact> {

    public static final ContactFactory SINGLETON = new ContactFactory();

    @Override
    public Contact makeNewInstance(){
        return new ContactImplementation();
    }

}
