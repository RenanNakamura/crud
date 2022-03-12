package com.br.crud.query.it.domain.nivel;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.br.crud.IntegrationTest;

@IntegrationTest
@Sql(scripts = "/db.it/base.sql")
class NivelQueryIT {

    private final String PATH = "/api/v1/nivel";

    @Autowired
    private MockMvc mock;

    @Test
    void listar() throws Exception {
        this.mock.perform(get(this.PATH))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].descricao", is("Senior")))
            .andExpect(jsonPath("$[1].id", is("c43e6d21-2733-4cbb-95f5-6189f73f1dcb")))
            .andExpect(jsonPath("$[1].descricao", is("Junior")))
            .andExpect(jsonPath("$[2].id", is("e57b2ced-8866-4d3f-9eda-1487f9d727b3")))
            .andExpect(jsonPath("$[2].descricao", is("Pleno")))
        ;
    }

    @Test
    void listarFiltroDescricao() throws Exception {
        this.mock.perform(get(this.PATH + "?descricao=Pleno"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is("e57b2ced-8866-4d3f-9eda-1487f9d727b3")))
            .andExpect(jsonPath("$[0].descricao", is("Pleno")));
    }

}
