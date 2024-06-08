package com.dmadev.controller;


import com.dmadev.comparapi.UserWebApi;
import com.dmadev.comparapi.model.UserModel;
import com.dmadev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserWebApi {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserModel> findUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order) {
        return userService.findUser(id, username, sort, order);
    }

}
