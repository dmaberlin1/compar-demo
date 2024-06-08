package com.dmadev.controller;

import com.dmadev.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;



class UserControllerTest extends BaseIntegrationTest {

    String BASE_URL = "http://localhost:";
    String pathUsers = "/api/v1/users";

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
    }

    @Test
    void shouldReturnAllUsers() {
        String expected = "6";

        assertThat(this.restTemplate.getForObject(BASE_URL + port + pathUsers,
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByID() {
        String id = "5";
        String expected = "Loli";
        assertThat(this.restTemplate.getForObject(BASE_URL + port + pathUsers+"?id=" + id,
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByUsername() {
        String username ="lolik";
        String expected = "Loli";
        assertThat(this.restTemplate.getForObject(BASE_URL + port + pathUsers+"?username=" + username,
                String.class)).contains(expected);
    }

    @Test
    void shouldNotFindUserByNonExistentID() {
        String id = "100";
        assertThat(this.restTemplate.getForObject(BASE_URL+ port + pathUsers+"?id=" + id,
                String.class)).isEqualTo("[]");
    }


    @Test
    void shouldNotFindUserByNonExistentUsername() {
        String username = "nonexistentuser";
        ResponseEntity<String> response = this.restTemplate.getForEntity(BASE_URL + port + pathUsers+"?username=" + username, String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("[]");
    }


    @Test
    void shouldFindUserByIDAndUsername() {
        String id = "5";
        String username = "lolik";
        ResponseEntity<String> response = this.restTemplate
                .getForEntity(BASE_URL + port + pathUsers+"?id=" + id + "&username=" + username, String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).contains("Loli");
    }

    @Test
    void shouldHandleRequestWithoutParametersForFindUser() {
        ResponseEntity<String> response = this.restTemplate
                .getForEntity(BASE_URL + port + pathUsers, String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    void shouldHandleRequestWithIncorrectParameterForFindUser() {
        String invalidId = "invalid_id";
        ResponseEntity<String> response = this.restTemplate.getForEntity(BASE_URL + port + pathUsers+"?id=" + invalidId, String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(400);
    }

}