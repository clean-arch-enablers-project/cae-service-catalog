package com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.autodocumentation.DomainDocumentation;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports.MapRawContentToDocObjectPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapRawContentToDocObjectPortAdapter extends MapRawContentToDocObjectPort {

    public MapRawContentToDocObjectPortAdapter(){
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected DomainDocumentation executeLogic(String rawValue, UseCaseExecutionCorrelation useCaseExecutionCorrelation) {
        try {
            return MAPPER.readValue(rawValue, DomainDocumentation.class);
        } catch (JsonProcessingException exception) {
            throw new InternalMappedException(
                    "Something went wrong while trying to map the raw value to the UseCaseDocumentation format",
                    "Raw value: '" + rawValue + "'. Original exception thrown: " + exception
            );
        }
    }
}
