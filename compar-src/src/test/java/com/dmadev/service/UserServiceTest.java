package com.dmadev.service;

import com.dmadev.BaseUnitTest;
import com.dmadev.comparapi.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest  extends BaseUnitTest {

    @Autowired
    UserService userService;

    @Test
    void shouldFindUserBySpecification() {
        var userList = userService.findUser(null, "dorid", null, null);

        assertThat(userList.stream().toList())
                .hasSize(1)
                .extracting(UserModel::getUsername)
                .containsExactlyInAnyOrder("dorid");
    }

    @Test
    void shouldFindUserByUsername() {
        List<UserModel> userList = userService.findUser(null, "lolik", null, null);
        assertThat(userList).hasSize(1);
        assertThat(userList.get(0).getUsername()).isEqualTo("lolik");
    }

    @Test
    void shouldFindUserByID() {
        List<UserModel> userList = userService.findUser(5L, null, null, null);
        assertThat(userList).hasSize(1);
        assertThat(userList.get(0).getName()).isEqualTo("Loli");
    }

    @Test
    void shouldReturnAllUsers() {
        List<UserModel> userList = userService.findUser(null, null, null, null);
        assertThat(userList).hasSize(6);
    }

    @Test
    void shouldSortUsersByUsernameInAscendingOrder() {
        List<UserModel> userList = userService.findUser(null, null, "username", "asc");
        assertThat(userList).extracting(UserModel::getUsername)
                .containsExactly("billj", "dorid", "lolik", "lorryf", "mikep", "morryk");
    }

    @Test
    void shouldSortUsersByUsernameInDescendingOrder() {
        List<UserModel> userList = userService.findUser(null, null, "username", "desc");
        assertThat(userList).extracting(UserModel::getUsername)
                .containsExactly("morryk", "mikep", "lorryf", "lolik", "dorid", "billj");
    }

    @Test
    void shouldSortUsersByNameInAscendingOrder() {
        List<UserModel> userList = userService.findUser(null, null, "name", "asc");
        assertThat(userList).extracting(UserModel::getName)
                .containsExactly("Bill", "Dori", "Loli", "Lorry", "Mike", "Morry");
    }

    @Test
    void shouldSortUsersByNameInDescendingOrder() {
        List<UserModel> userList = userService.findUser(null, null, "name", "desc");
        assertThat(userList).extracting(UserModel::getName)
                .containsExactly("Morry", "Mike", "Lorry", "Loli", "Dori", "Bill");
    }

    @Test
    void shouldFilterUsersBySurname() {
        List<UserModel> userList = userService.findUser(null, null, null, null);
        assertThat(userList).hasSize(6);

        userList = userService.findUser(null, null, "surname", "asc");
        assertThat(userList).extracting(UserModel::getSurname).containsExactly("Dare", "Fregato", "Joke", "Kare", "Kortney", "Pearson");
    }


    @Test
    void shouldHandleInvalidUsername() {
        List<UserModel> userList = userService.findUser(null, "nonexistent_username", null, null);
        assertThat(userList).isEmpty();
    }

    @Test
    void shouldHandleInvalidUserID() {
        List<UserModel> userList = userService.findUser(100L, null, null, null);
        assertThat(userList).isEmpty();
    }

    @Test
    void shouldHandleInvalidSortingOrder() {
        List<UserModel> userList = userService.findUser(null, null, "username", "invalid_order");
        assertThat(userList).isNotEmpty();
    }


    @Test
    void shouldHandleEmptyParameters() {
        List<UserModel> userList = userService.findUser(null, null, null, null);
        assertThat(userList).hasSize(6);
    }

    @Test
    void shouldReturnEmptyListWhenNoUsersFound() {
        List<UserModel> userList = userService.findUser(999L, "nonexistent_username", null, null);
        assertThat(userList).isEmpty();
    }


}