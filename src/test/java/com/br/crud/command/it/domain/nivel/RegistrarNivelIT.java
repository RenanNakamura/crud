package com.br.crud.command.it.domain.nivel;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.br.crud.IntegrationTest;
import com.br.crud.command.domain.nivel.usecase.RegistrarNivelUseCase.RegistrarNivel;
import com.fasterxml.jackson.databind.ObjectMapper;

@IntegrationTest
class RegistrarNivelIT {

    private final String PATH = "/api/v1/nivel";

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void caminhoFeliz() throws Exception {
        var cmd = RegistrarNivel.builder()
            .descricao("Senior")
            .build();

        this.mock.perform(post(this.PATH)
            .contentType(APPLICATION_JSON)
            .content(this.mapper.writeValueAsBytes(cmd)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    void caminhoInfeliz() throws Exception {
        var cmd = RegistrarNivel.builder()
            .descricao("")
            .build();

        this.mock.perform(post(this.PATH)
            .contentType(APPLICATION_JSON)
            .content(this.mapper.writeValueAsBytes(cmd)))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
