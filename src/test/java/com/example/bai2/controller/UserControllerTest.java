package com.example.bai2.controller;

import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.dto.response.UserResponse;
import com.example.bai2.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private UserCreationRequest request; // input
    private UserResponse response; // output

    @BeforeEach
    public void initData() {
        request = UserCreationRequest
                .builder()
                .username("trungviet")
                .password("trung123")
                .firstName("Trung")
                .lastName("Viet")
                .dob(LocalDate.of(2000, 1, 1))
                .build();
        response = UserResponse
                .builder()
                .id("1adssda")
                .username("trungviet")
                .firstName("Trung")
                .lastName("Viet")
                .dob(LocalDate.of(2000, 1, 1))
                .build();
    }

    @Test
        //
    void createUser_validRequest_sucess() throws Exception {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(request);
        Mockito.when(userService.createUser(ArgumentMatchers.any()))
                .thenReturn(response);
        //when, then
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code")
                        .value("1000"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.id")
                        .value("1adssda"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.username")
                        .value("trungviet"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.firstName")
                        .value("Trung"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.lastName")
                        .value("Viet"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.dob")
                        .value("2000-01-01"));


    }

    @Test
        //
    void createUser_invalidUserNameRequest_sucess() throws Exception {
        request.setUsername("as");
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String content = objectMapper.writeValueAsString(request);

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content)
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("code")
                        .value("1003"))
                .andExpect(MockMvcResultMatchers.jsonPath("message")
                        .value("Username must be at least 3 characters"));


    }

}
