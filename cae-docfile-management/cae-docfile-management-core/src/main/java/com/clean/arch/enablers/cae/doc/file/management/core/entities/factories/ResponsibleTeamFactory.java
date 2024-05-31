package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.ResponsibleTeam;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.ResponsibleTeamImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponsibleTeamFactory implements EntityFactory<ResponsibleTeam> {

    public static final ResponsibleTeamFactory SINGLETON = new ResponsibleTeamFactory();

    @Override
    public ResponsibleTeam makeNewInstance(){
        return new ResponsibleTeamImplementation();
    }

}
