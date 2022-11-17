package com.capitole.capitolTest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.capitole.capitolTest.repositories")
class PersistenceJPAConfig {

}
