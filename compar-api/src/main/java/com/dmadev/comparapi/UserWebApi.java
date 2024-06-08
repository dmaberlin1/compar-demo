package com.dmadev.comparapi;

import com.dmadev.comparapi.model.UserModel;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/api/v1")
public interface UserWebApi {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Полное имя получено"),
            @ApiResponse(responseCode = "400", description = "Запрос содержит некорректные данные или параметры"),
            @ApiResponse(responseCode = "401", description = "Требуется аутентификации пользователя"),
            @ApiResponse(responseCode = "403", description = "Запрос запрещен для текущего пользователя"),
            @ApiResponse(responseCode = "404", description = "Пользователь по запрошенному ID не найден"),
            @ApiResponse(responseCode = "500", description = "Произошла внутренняя ошибка сервера"),
    })
    List<UserModel> findUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order);


}
