package com.ghao.nan;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class NanApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NanApplication.class);
    }
    @Bean
    public InitializingBean initializingBean(RepositoryService repositoryService) {
        return () -> {
            List<Deployment> list = repositoryService.createDeploymentQuery().list();
            System.err.println("Deployment size: " + list.size());// where '1' is expected
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(NanApplication.class, args);
    }

}
