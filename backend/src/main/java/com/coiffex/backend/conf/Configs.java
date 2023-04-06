package com.coiffex.backend.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.coiffex.backend")
@ComponentScan(basePackages = "com.coiffex.backend")
@EnableJpaRepositories(basePackages = "com.coiffex.backend.repositories")
public class Configs {
}
