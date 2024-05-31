package com.clean.arch.enablers.cae.doc.file.management.core.entities.factories;

import com.clean.arch.enablers.cae.doc.file.management.core.entities.TeamMember;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.implementations.TeamMemberImplementation;
import lombok.AccessLevel;
import com.cae.entities.EntityFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamMemberFactory implements EntityFactory<TeamMember> {

    public static final TeamMemberFactory SINGLETON = new TeamMemberFactory();

    @Override
    public TeamMember makeNewInstance(){
        return new TeamMemberImplementation();
    }

}
