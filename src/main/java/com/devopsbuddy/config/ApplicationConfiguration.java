package com.devopsbuddy.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author munga
 *
 */
@Configuration
@EnableJpaRepositories(basePackages="com.devopsbuddy.backend.persistance.repositories")
@EntityScan(basePackages="com.devopsbuddy.backend.persistance.domain.backend")
@EnableTransactionManagement
@PropertySource("file:///${user.home}/.devopsbuddy/application-common.properties")
public class ApplicationConfiguration {

}
