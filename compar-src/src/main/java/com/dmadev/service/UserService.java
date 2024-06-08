package com.dmadev.service;

import com.dmadev.comparapi.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> findUser(Long id, String username, String sort, String order);
}
