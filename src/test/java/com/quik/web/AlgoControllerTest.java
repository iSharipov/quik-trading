package com.quik.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlgoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn_200() throws Exception {
        this.mockMvc.perform(post("/algo/1/execute"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}