package com.crja.backend.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class DepartamentoControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllShouldReturnAllResources() throws Exception {

        ResultActions result = mockMvc.perform(get("/departamentos").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.content[0].titulo").value("Financeiro"));
        result.andExpect(jsonPath("$.content[1].titulo").value("Comercial"));
        result.andExpect(jsonPath("$.content[2].titulo").value("Desenvolvimento"));
    }
}
