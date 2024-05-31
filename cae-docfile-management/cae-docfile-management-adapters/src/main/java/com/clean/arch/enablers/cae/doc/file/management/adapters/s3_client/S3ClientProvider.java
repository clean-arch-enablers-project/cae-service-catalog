package com.clean.arch.enablers.cae.doc.file.management.adapters.s3_client;

import com.cae.env_vars.EnvVarRetriever;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class S3ClientProvider {

    private static final String AWS_REGION = "AWS_REGION";
    public static final S3Client S3_CLIENT;

    static {
        var region = Region.of(EnvVarRetriever.getEnvVarByNameAsString(AWS_REGION));
        S3_CLIENT = S3Client.builder()
                .region(region)
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
    }

}
