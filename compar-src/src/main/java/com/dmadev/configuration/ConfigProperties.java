package com.dmadev.configuration;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.List;

@Getter
@ConfigurationProperties(prefix = "my")
public class ConfigProperties {

    private final List<Datasource> datasource;

    @ConstructorBinding
    public ConfigProperties(List<Datasource> datasource) {
        this.datasource = datasource;
    }
}
