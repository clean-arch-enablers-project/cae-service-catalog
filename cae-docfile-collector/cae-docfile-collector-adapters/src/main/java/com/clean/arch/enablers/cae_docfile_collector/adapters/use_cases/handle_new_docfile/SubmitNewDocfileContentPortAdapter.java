package com.clean.arch.enablers.cae_docfile_collector.adapters.use_cases.handle_new_docfile;

import com.cae.http_client.HttpRequestStarter;
import com.cae.http_client.HttpResponse;
import com.cae.http_client.implementations.HttpRequestStarterImplementation;
import com.cae.loggers.native_io_extraction_mode.json.SimpleJsonBuilder;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae_docfile_collector.adapters.env_vars.EnvironmentVariables;
import com.clean_arch_enablers.cae_docfile_collector.core.use_cases.handle_new_docfile.implementations.ports.SubmitNewDocfileContentPort;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class SubmitNewDocfileContentPortAdapter extends SubmitNewDocfileContentPort {

    private static final HttpRequestStarter HTTP_REQUEST_STARTER = new HttpRequestStarterImplementation();

    @Override
    protected void executeLogic(Input input, UseCaseExecutionCorrelation correlation) {
        var host = EnvironmentVariables.getCaeDocManagementHost();
        this.handleSourceCodeFrom(input);
        var body = HttpRequest.BodyPublishers.ofString(SimpleJsonBuilder.buildFor(input), StandardCharsets.UTF_8);
        var request = HTTP_REQUEST_STARTER.startPostRequestFor(host, body)
                .handlerForAnyUnsuccessfulResponse(response -> this.handleUnexpectedProblem(response, host))
                .headerOf("Content-Type", "application/json ")
                .finishBuildingModel();
        request.sendRequest();
    }

    private void handleSourceCodeFrom(Input input) {
        input.getNewDoc().getUseCases().forEach(useCase -> {
            var newSourceCodeFormatting = useCase.getUseCaseSourceCode()
                    .replace("\"", "\\\"");
            useCase.setUseCaseSourceCode(newSourceCodeFormatting);
        });
    }

    private void handleUnexpectedProblem(HttpResponse httpResponse, String host) {
        throw new InternalMappedException(
                "Something went wrong while trying to send the new doc to the CAE Doc Management service",
                "Status code received: " + httpResponse.getStatusCode() +
                " | Endpoint: " + host
        );
    }
}
