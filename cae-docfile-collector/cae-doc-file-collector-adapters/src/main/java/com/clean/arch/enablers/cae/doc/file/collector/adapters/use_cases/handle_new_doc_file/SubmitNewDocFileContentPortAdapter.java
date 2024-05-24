package com.clean.arch.enablers.cae.doc.file.collector.adapters.use_cases.handle_new_doc_file;

import com.cae.http_client.HttpRequestStarter;
import com.cae.http_client.HttpResponse;
import com.cae.http_client.implementations.HttpRequestStarterImplementation;
import com.cae.loggers.native_io_extraction_mode.json.SimpleJsonBuilder;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.collector.adapters.env_vars.EnvironmentVariables;
import com.clean.arch.enablers.cae.doc.file.collector.core.use_cases.handle_new_doc_file.implementations.ports.SubmitNewDocFileContentPort;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class SubmitNewDocFileContentPortAdapter extends SubmitNewDocFileContentPort {

    private static final HttpRequestStarter HTTP_REQUEST_STARTER = new HttpRequestStarterImplementation();

    @Override
    protected void executeLogic(Input input, UseCaseExecutionCorrelation correlation) {
        var host = EnvironmentVariables.getCaeDocManagementHost();
        var body = HttpRequest.BodyPublishers.ofString(SimpleJsonBuilder.buildFor(input), StandardCharsets.UTF_8);
        var request = HTTP_REQUEST_STARTER.startPostRequestFor(host, body)
                .handlerForAnyUnsuccessfulResponse(this::handleUnexpectedProblem)
                .finishBuildingModel();
        request.sendRequest();
    }

    private void handleUnexpectedProblem(HttpResponse httpResponse) {
        throw new InternalMappedException(
                "Something went wrong while trying to send the new doc to the CAE Doc Management service",
                "Status code received: " + httpResponse.getStatusCode()
        );
    }
}
