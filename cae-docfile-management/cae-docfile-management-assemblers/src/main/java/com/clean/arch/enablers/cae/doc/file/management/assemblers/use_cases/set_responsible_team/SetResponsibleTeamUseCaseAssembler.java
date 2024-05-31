package com.clean.arch.enablers.cae.doc.file.management.assemblers.use_cases.set_responsible_team;

import com.cae.use_cases.assemblers.UseCaseAssembler;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.set_responsible_team.SetResponsibleTeamUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.set_responsible_team.implementations.SetResponsibleTeamUseCaseImplementation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SetResponsibleTeamUseCaseAssembler implements UseCaseAssembler<SetResponsibleTeamUseCase>{

    public static final SetResponsibleTeamUseCaseAssembler SINGLETON_ASSEMBLER = new SetResponsibleTeamUseCaseAssembler();

    public static final SetResponsibleTeamUseCase V1;

    static {
        V1 = SetResponsibleTeamUseCaseAssembler.initializeV1();
    }

    private static SetResponsibleTeamUseCase initializeV1(){
        return new SetResponsibleTeamUseCaseImplementation();
    }

    @Override
    public SetResponsibleTeamUseCase getDefaultAssembledInstance(){
        return V1;
    }
}