package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports;

import com.cae.ports.specifics.functions.FunctionPort;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;

import java.util.Optional;

public abstract class DomainRetrievementByIdPort extends FunctionPort<String, Optional<Domain>> {
}
