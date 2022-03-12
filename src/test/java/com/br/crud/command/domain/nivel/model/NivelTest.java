package com.br.crud.command.domain.nivel.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NivelTest {

    private final String descricao = "Pleno";

    private NivelBuilder builder;

    @BeforeEach
    void beforeEach() {
        builder = Nivel.builder().descricao(this.descricao);
    }

    @Nested
    class Build {

        @Test
        void build() {
            var nivel = builder.build();

            assertNotNull(nivel.getId());
            assertEquals(descricao, nivel.getDescricao());
        }

        @Test
        void semDescricao() {
            assertThrows(NullPointerException.class, () -> builder.descricao(null).build());
        }

    }

    @Nested
    class Update {

        private Nivel nivel;

        private NivelBuilderUpdate updateForm;

        @BeforeEach
        void beforeEach() {
            this.nivel = builder.build();
            this.updateForm = this.nivel.alterar().descricao(descricao);
        }

        @Test
        void update() {
            var descricaoAlterada = "Senior";

            this.updateForm
                .descricao(descricaoAlterada)
                .apply();

            assertEquals(descricaoAlterada, this.nivel.getDescricao());
        }

        @Test
        void semDescricao() {
            assertThrows(NullPointerException.class, () -> this.updateForm.descricao(null).apply());
        }

    }

}
