package com.br.crud.command.it.domain.nivel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.br.crud.IntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;

@IntegrationTest
@Sql(scripts = "/db.it/base.sql")
class ExcluirNivelIT {

    private final String PATH = "/api/v1/nivel/{id}";

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private EntityManager em;

    @Test
    void caminhoFeliz() throws Exception {
        this.mock.perform(delete(this.PATH, UUID.fromString("c43e6d21-2733-4cbb-95f5-6189f73f1dcb").toString()))
            .andExpect(status().isNoContent())
            .andReturn();
    }

    @Test
    void caminhoInfeliz() throws Exception {
        this.mock.perform(delete(this.PATH, UUID.fromString("5938cc9e-09a5-4c8c-b941-8b6d6881d238").toString()))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
