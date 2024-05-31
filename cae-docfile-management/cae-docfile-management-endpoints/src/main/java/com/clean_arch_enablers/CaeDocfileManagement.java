package com.clean_arch_enablers;

import com.clean.arch.enablers.cae.doc.file.management.assemblers.loggers.LoggerBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaeDocfileManagement {

    public static void main(String[] args) {
        LoggerBootstrap.startupSettings();
        SpringApplication.run(CaeDocfileManagement.class);
    }

}