package com.buenoezandro.users.config;

import com.buenoezandro.users.service.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class TestConfig {
    private final DBService dbService;

    @Bean
    public void insertData() {
        this.dbService.create();;
    }
}
