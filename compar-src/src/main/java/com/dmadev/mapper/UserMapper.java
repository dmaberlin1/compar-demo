package com.dmadev.mapper;

import com.dmadev.comparapi.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {


    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();

        userModel.setId(rs.getLong("user_id"));
        userModel.setUsername(rs.getString("login"));
        userModel.setName(rs.getString("first_name"));
        userModel.setSurname(rs.getString("last_name"));

        return userModel;
    }
}
