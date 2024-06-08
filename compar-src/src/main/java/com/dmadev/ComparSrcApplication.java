package com.dmadev;

import com.dmadev.configuration.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class ComparSrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComparSrcApplication.class, args);
    }

}
