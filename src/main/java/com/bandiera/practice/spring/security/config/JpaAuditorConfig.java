package com.bandiera.practice.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JPA auditor enable
 */
@Configuration
@EnableJpaAuditing // JpaAuditing 을 Enable
public class JpaAuditorConfig {
}
