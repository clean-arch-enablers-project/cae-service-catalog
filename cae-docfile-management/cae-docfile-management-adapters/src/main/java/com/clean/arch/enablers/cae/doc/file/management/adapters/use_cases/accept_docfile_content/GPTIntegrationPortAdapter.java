package com.clean.arch.enablers.cae.doc.file.management.adapters.use_cases.accept_docfile_content;

import com.cae.env_vars.EnvVarRetriever;
import com.cae.http_client.HttpRequestStarter;
import com.cae.http_client.HttpResponse;
import com.cae.http_client.implementations.HttpRequestStarterImplementation;
import com.cae.loggers.native_io_extraction_mode.json.SimpleJsonBuilder;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;
import com.clean.arch.enablers.cae.doc.file.management.core.required_env_vars.RequiredEnvVars;
import com.clean.arch.enablers.cae.doc.file.management.core.use_cases.accept_docfile_content.implementations.ports.GPTIntegrationPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class GPTIntegrationPortAdapter extends GPTIntegrationPort {

    private static final HttpRequestStarter HTTP_REQUEST_STARTER = new HttpRequestStarterImplementation();

    @Override
    protected Output executeLogic(Input input, UseCaseExecutionCorrelation correlation) {
        var clientInput = new GPTClientInput(this.handleSourceCodeStringFrom(input));
        var host = EnvVarRetriever.getEnvVarByNameAsString(RequiredEnvVars.CAE_GPT_CLIENT_HOST);
        var body = HttpRequest.BodyPublishers.ofString(SimpleJsonBuilder.buildFor(clientInput), StandardCharsets.UTF_8);
        var request = HTTP_REQUEST_STARTER.startPostRequestFor(host.concat("/analyze"), body)
                .headerOf("Content-Type", "application/json")
                .headerOf("Accept", "*/*")
                .handlerForAnyUnsuccessfulResponse(this::handle)
                .finishBuildingModel();
        var clientOutput = request.sendRequestReturning(GPTClientOutput.class);
        return new Output(clientOutput.getAnalysis());
    }

    private void handle(HttpResponse httpResponse){
        throw new InternalMappedException("Something went wrong while trying to integrate with the GPT API", httpResponse.getStatusCode().toString());
    }

    private String handleSourceCodeStringFrom(Input input) {
        return input.getSourceCode()
                .replace("\"", "\\\"")
                .replace("\n", " ")
                .replace("\r", " ")
                .replace("\t", " ");
    }

    @RequiredArgsConstructor
    @Getter
    public static class GPTClientInput{
        private final String code;
    }

    @Getter
    @Setter
    public static class GPTClientOutput{
        private String analysis;
    }

}
