package com.br.crud.command.it.domain.desenvolvedor;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.br.crud.IntegrationTest;
import com.br.crud.command.domain.desenvolvedor.model.Sexo;
import com.br.crud.command.domain.desenvolvedor.usecase.RegistrarDesenvolvedorUseCase.RegistrarDesenvolvedor;
import com.fasterxml.jackson.databind.ObjectMapper;

@IntegrationTest
@Sql(scripts = "/db.it/base.sql")
class RegistrarDesenvolvedorIT {

    private final String PATH = "/api/v1/desenvolvedor";

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void caminhoFeliz() throws Exception {
        var cmd = RegistrarDesenvolvedor.builder()
            .nivel(UUID.fromString("4f9c1877-efd9-44cf-95d3-e12b659db8da"))
            .nome("Renan Junji Nakamura")
            .sexo(Sexo.MASCULINO)
            .dataNascimento(LocalDate.of(1992, 5, 4))
            .hobby("Dançar")
            .build();

        this.mock.perform(post(this.PATH)
            .contentType(APPLICATION_JSON)
            .content(this.mapper.writeValueAsBytes(cmd)))
            .andExpect(status().isCreated())
            .andReturn();
    }

    @Test
    void caminhoInfeliz() throws Exception {
        var cmd = RegistrarDesenvolvedor.builder()
            .nivel(UUID.fromString("4f9c1877-efd9-44cf-95d3-e12b659db8da"))
            .nome("")
            .sexo(Sexo.MASCULINO)
            .dataNascimento(LocalDate.of(1992, 5, 4))
            .hobby("Dançar")
            .build();

        this.mock.perform(post(this.PATH)
            .contentType(APPLICATION_JSON)
            .content(this.mapper.writeValueAsBytes(cmd)))
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
