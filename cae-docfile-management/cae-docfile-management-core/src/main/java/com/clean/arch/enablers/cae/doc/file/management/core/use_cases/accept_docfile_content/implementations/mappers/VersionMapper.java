package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.mappers;

import com.cae.use_cases.autodocumentation.IOContractDocumentation;
import com.cae.use_cases.autodocumentation.UseCaseDocumentation;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.UseCaseIOFieldInfo;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.UseCaseIOInfo;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Version;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.factories.UseCaseIOFieldInfoFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.factories.UseCaseIOInfoFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.factories.UseCaseInfoFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.factories.VersionFactory;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.io.inputs.AcceptDocfileContentUseCaseInput;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionMapper {

    public static final VersionMapper SINGLETON = new VersionMapper();

    public Version mapToDomainFrom(AcceptDocfileContentUseCaseInput input){
        var newVersion = VersionFactory.SINGLETON.makeNewInstance();
        newVersion.setDomainName(input.getNewDoc().getDomain());
        var useCasesInfo = input.getNewDoc()
                .getUseCases()
                .stream()
                .map(inputFormat -> {
                    var useCase = UseCaseInfoFactory.SINGLETON.makeNewInstance();
                    useCase.setUseCaseDeclaration(inputFormat.getUseCaseDeclaration());
                    useCase.setUseCaseImplementation(inputFormat.getUseCaseImplementation());
                    useCase.setUseCaseDeclarationLocation(inputFormat.getUseCaseDeclarationLocation());
                    useCase.setUseCaseImplementationLocation(inputFormat.getUseCaseImplementationLocation());
                    useCase.setDescription(inputFormat.getDescription());
                    useCase.setUseCaseSourceCode(inputFormat.getUseCaseSourceCode());
                    useCase.setIsProtected(inputFormat.getIsProtected());
                    useCase.setScopes(inputFormat.getScopes());
                    useCase.setIoContract(VersionMapper.mapIOContractFrom(inputFormat));
                    return useCase;
                })
                .collect(Collectors.toList());
        newVersion.setUseCases(useCasesInfo);
        return newVersion;
    }

    private static List<UseCaseIOInfo> mapIOContractFrom(UseCaseDocumentation input) {
        return input.getIoContract()
                .stream()
                .map(inputFormat -> {
                    var ioInfo = UseCaseIOInfoFactory.SINGLETON.makeNewInstance();
                    ioInfo.setClassName(inputFormat.getClassName());
                    ioInfo.setInput(inputFormat.getInput());
                    ioInfo.setClassFields(VersionMapper.mapIOFieldsFrom(inputFormat));
                    return ioInfo;
                }).collect(Collectors.toList());
    }

    private static List<UseCaseIOFieldInfo> mapIOFieldsFrom(IOContractDocumentation input) {
        return input.getClassFields()
                .stream()
                .map(inputFormat -> {
                    var ioField = UseCaseIOFieldInfoFactory.SINGLETON.makeNewInstance();
                    ioField.setFieldName(inputFormat.getFieldName());
                    ioField.setFieldType(inputFormat.getFieldType());
                    ioField.setIsNotNull(inputFormat.getIsNotNull());
                    ioField.setIsNotBlank(inputFormat.getIsNotBlank());
                    ioField.setIsNotEmpty(inputFormat.getIsNotBlank());
                    ioField.setIsSensitive(inputFormat.getIsSensitive());
                    return ioField;
                }).collect(Collectors.toList());
    }

}
