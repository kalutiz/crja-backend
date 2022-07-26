//package com.crja.backend.controllers;
//
//import com.crja.backend.dto.PessoaDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@Transactional
//public class PessoaControllerIT {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void findAllShouldReturnResources() throws Exception {
//
//        ResultActions result = mockMvc.perform(get("/pessoas").contentType(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk());
//        result.andExpect(jsonPath("$.content").exists());
//        result.andExpect(jsonPath("$.content[0].nome").value("Camila"));
//        result.andExpect(jsonPath("$.content[1].nome").value("Pedro"));
//        result.andExpect(jsonPath("$.content[2].nome").value("Fabiano"));
//    }
//
//    @Test
//    public void insertShouldInsertResource() throws Exception {
//
//        PessoaDTO dto = new PessoaDTO(null, "Kevin", 3L);
//        String jsonBody = objectMapper.writeValueAsString(dto);
//
//        ResultActions result = mockMvc.perform(post("/pessoas").content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isCreated());
//        result.andExpect(jsonPath("$.id").exists());
//        result.andExpect(jsonPath("$.nome").value("Kevin"));
//        result.andExpect(jsonPath("$.departamentoId").value(3L));
//    }
//}
