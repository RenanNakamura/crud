package com.br.crud.command.it.domain.nivel;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.br.crud.IntegrationTest;
import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase.AlterarNivel;
import com.fasterxml.jackson.databind.ObjectMapper;

@IntegrationTest
@Sql(scripts = "/db.it/base.sql")
class AlterarNivelIT {

    private final String PATH = "/api/v1/nivel/{id}";

    private final UUID ID = UUID.fromString("c43e6d21-2733-4cbb-95f5-6189f73f1dcb");

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void caminhoFeliz() throws Exception {
        var cmd = AlterarNivel.builder()
            .descricao("Trainee")
            .build();

        this.mock.perform(put(this.PATH, ID.toString())
            .contentType(APPLICATION_JSON)
            .content(this.mapper.writeValueAsBytes(cmd)))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void caminhoInfeliz() throws Exception {
        var cmd = AlterarNivel.builder()
            .descricao("")
            .build();

        this.mock.perform(put(this.PATH, ID.toString())
            .contentType(APPLICATION_JSON)
            .content(this.mapper.writeValueAsBytes(cmd)))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
