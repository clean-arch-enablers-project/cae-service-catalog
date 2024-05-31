package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.set_responsible_team.implementations;

import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.set_responsible_team.SetResponsibleTeamUseCase;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.set_responsible_team.io.inputs.SetResponsibleTeamUseCaseInput;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.set_responsible_team.io.outputs.SetResponsibleTeamUseCaseOutput;

public class SetResponsibleTeamUseCaseImplementation extends SetResponsibleTeamUseCase{

    //declare here the ports and other dependencies you might need within this use case implementation

    @Override
    protected SetResponsibleTeamUseCaseOutput applyInternalLogic(SetResponsibleTeamUseCaseInput input, UseCaseExecutionCorrelation correlation) {
 	 	//implement the logic of the use case here. to make contact with dependencies from here, create ports.
 	 	return null;
    }
}