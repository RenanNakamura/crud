package com.br.crud.query.it.domain.desenvolvedor;

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
class DesenvolvedorQueryIT {

    private final String PATH = "/api/v1/desenvolvedor";

    @Autowired
    private MockMvc mock;

    @Test
    void listar() throws Exception {
        this.mock.perform(get(this.PATH))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].nome", is("Miguel")))
            .andExpect(jsonPath("$[0].sexo", is("MASCULINO")))
            .andExpect(jsonPath("$[0].dataNascimento", is("1993-12-01")))
            .andExpect(jsonPath("$[0].idade", is(28)))
            .andExpect(jsonPath("$[0].hobby", is("Nada...")))
            .andExpect(jsonPath("$[1].id", is("c43e6d21-2733-4cbb-95f5-6189f73f1dcb")))
            .andExpect(jsonPath("$[1].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[1].nome", is("João")))
            .andExpect(jsonPath("$[1].sexo", is("MASCULINO")))
            .andExpect(jsonPath("$[1].dataNascimento", is("1993-01-01")))
            .andExpect(jsonPath("$[1].idade", is(28)))
            .andExpect(jsonPath("$[1].hobby", is("Nada...")))
            .andExpect(jsonPath("$[2].id", is("e57b2ced-8866-4d3f-9eda-1487f9d727b3")))
            .andExpect(jsonPath("$[2].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[2].nome", is("Vivi")))
            .andExpect(jsonPath("$[2].sexo", is("FEMININO")))
            .andExpect(jsonPath("$[2].dataNascimento", is("1997-01-01")))
            .andExpect(jsonPath("$[2].idade", is(25)))
            .andExpect(jsonPath("$[2].hobby", is("Nada...")));
    }

    @Test
    void listarFiltroNome() throws Exception {
        this.mock.perform(get(this.PATH + "?nome=Vivi"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is("e57b2ced-8866-4d3f-9eda-1487f9d727b3")))
            .andExpect(jsonPath("$[0].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].nome", is("Vivi")))
            .andExpect(jsonPath("$[0].sexo", is("FEMININO")))
            .andExpect(jsonPath("$[0].dataNascimento", is("1997-01-01")))
            .andExpect(jsonPath("$[0].idade", is(25)))
            .andExpect(jsonPath("$[0].hobby", is("Nada...")));
    }

    @Test
    void listarFiltroSexo() throws Exception {
        this.mock.perform(get(this.PATH + "?sexo=MASCULINO"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].nome", is("Miguel")))
            .andExpect(jsonPath("$[0].sexo", is("MASCULINO")))
            .andExpect(jsonPath("$[0].dataNascimento", is("1993-12-01")))
            .andExpect(jsonPath("$[0].idade", is(28)))
            .andExpect(jsonPath("$[0].hobby", is("Nada...")))
            .andExpect(jsonPath("$[1].id", is("c43e6d21-2733-4cbb-95f5-6189f73f1dcb")))
            .andExpect(jsonPath("$[1].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[1].nome", is("João")))
            .andExpect(jsonPath("$[1].sexo", is("MASCULINO")))
            .andExpect(jsonPath("$[1].dataNascimento", is("1993-01-01")))
            .andExpect(jsonPath("$[1].idade", is(28)))
            .andExpect(jsonPath("$[1].hobby", is("Nada...")));
    }

    @Test
    void listarFiltroIdade() throws Exception {
        this.mock.perform(get(this.PATH + "?idade=25"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is("e57b2ced-8866-4d3f-9eda-1487f9d727b3")))
            .andExpect(jsonPath("$[0].nivel.id", is("4f9c1877-efd9-44cf-95d3-e12b659db8da")))
            .andExpect(jsonPath("$[0].nome", is("Vivi")))
            .andExpect(jsonPath("$[0].sexo", is("FEMININO")))
            .andExpect(jsonPath("$[0].dataNascimento", is("1997-01-01")))
            .andExpect(jsonPath("$[0].idade", is(25)))
            .andExpect(jsonPath("$[0].hobby", is("Nada...")));
    }

}
