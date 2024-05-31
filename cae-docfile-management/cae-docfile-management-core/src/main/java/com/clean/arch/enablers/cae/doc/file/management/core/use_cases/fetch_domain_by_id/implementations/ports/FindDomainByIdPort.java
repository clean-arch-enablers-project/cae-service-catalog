package com.clean.arch.enablers.cae.doc.file.management.core.use_cases.fetch_domain_by_id.implementations.ports;

import com.cae.ports.specifics.functions.FunctionPort;
import com.clean.arch.enablers.cae.doc.file.management.core.entities.Domain;

import java.util.Optional;

public abstract class FindDomainByIdPort extends FunctionPort<String, Optional<Domain>> {
}
