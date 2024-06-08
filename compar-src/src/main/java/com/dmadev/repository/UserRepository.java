package com.dmadev.repository;

import com.dmadev.comparapi.model.UserModel;
import com.dmadev.configuration.Datasource;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.List;

public interface UserRepository {


    List<UserModel> findUser(Datasource datasource, Long id, String username);


    default DataSource getDataSource(Datasource datasource) {
        return DataSourceBuilder.create()
                .url(datasource.getUrl())
                .username(datasource.getUsername())
                .password(datasource.getPassword())
                .build();
    }
}
