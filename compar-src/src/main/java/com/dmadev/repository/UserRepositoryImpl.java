package com.dmadev.repository;

import com.dmadev.comparapi.model.UserModel;
import com.dmadev.configuration.Datasource;
import com.dmadev.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepositoryImpl implements UserRepository {


    public List<UserModel> findUser(Datasource datasource, Long id, String username) {
        StringBuilder sqlQuery = new StringBuilder("Select * from user_detail where 1=1 ");
        List<String> queryArgs = new ArrayList<>();

        if (Objects.nonNull(id)) {
            sqlQuery.append("And user_id = ? ");
            queryArgs.add(id.toString());
        }
        if (Objects.nonNull(username)) {
            sqlQuery.append("And login like ? ");
            queryArgs.add("%" + username + "%");
        }

        Object[] preparedStatementArgs = new Object[queryArgs.size()];
        for (int i = 0; i < preparedStatementArgs.length; i++) {
            preparedStatementArgs[i] = queryArgs.get(i);
        }


        return new JdbcTemplate(this.getDataSource(datasource))
                .query(sqlQuery.toString(), preparedStatementArgs, new UserMapper());
    }


}
