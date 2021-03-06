package com.example.controller;

import com.example.dto.TestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.BindException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("test controller 정상 테스트")
    void successTest() throws Exception {
        mockMvc.perform(
                post("/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "1")
                .param("userName", "testName")
                .param("address", "testAddress"))
                .andExpect(status().isOk())
                .andExpect(content().string("success"))
                .andDo(print());
    }

    @Test
    @DisplayName("test controller bindingresult 테스트")
    void bindingResultTest() throws Exception {
        mockMvc.perform(
                post("/")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("address", "testAddress"))
                .andExpect(status().isOk())
                .andExpect(content().string("fail"))
                .andDo(print());
    }
}