package com.br.crud.command.domain.desenvolvedor.model;

import static com.br.crud.command.domain.desenvolvedor.model.Sexo.FEMININO;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.sk.vo.DataNascimento;

class DesenvolvedorTest {

    private final UUID nivel = UUID.fromString("c43e6d21-2733-4cbb-95f5-6189f73f1dcb");
    private final String nome = "Renan Junji Nakamura";
    private final Sexo sexo = Sexo.MASCULINO;
    private final DataNascimento dataNascimento = DataNascimento.from(LocalDate.of(1992, 5, 4));
    private final String hobby = "...";

    private DesenvolvedorBuilder builder;

    @BeforeEach
    void beforeEach() {
        builder = Desenvolvedor.builder()
            .nivel(this.nivel)
            .nome(this.nome)
            .sexo(this.sexo)
            .dataNascimento(this.dataNascimento)
            .hobby(this.hobby)
            .nivelConstraint(exist -> true);
    }

    @Nested
    class Build {

        @Test
        void build() {
            var desenvolvedor = builder.build();

            assertNotNull(desenvolvedor.getId());
            assertEquals(nivel, desenvolvedor.getNivel());
            assertEquals(nome, desenvolvedor.getNome());
            assertEquals(sexo, desenvolvedor.getSexo());
            assertEquals(dataNascimento, desenvolvedor.getDataNascimento());
            assertEquals(hobby, desenvolvedor.getHobby());
        }

        @Test
        void semNivel() {
            assertThrows(NullPointerException.class, () -> builder.nivel(null).build());
        }

        @Test
        void semNome() {
            assertThrows(NullPointerException.class, () -> builder.nome(null).build());
        }

        @Test
        void semSexo() {
            assertThrows(NullPointerException.class, () -> builder.sexo(null).build());
        }

        @Test
        void semDataNascimento() {
            assertThrows(NullPointerException.class, () -> builder.dataNascimento(null).build());
        }

        @Test
        void semHobby() {
            assertDoesNotThrow(() -> builder.hobby(null).build());
        }

        @Test
        void semNivelConstraint() {
            assertThrows(NullPointerException.class, () -> builder.nivelConstraint(null).build());
        }

        @Test
        void comNivelConstraint() {
            assertThrows(EntityNotFoundException.class, () -> builder.nivelConstraint(exists -> false).build());
        }

    }

    @Nested
    class Update {

        private Desenvolvedor desenvolvedor;

        private DesenvolvedorBuilderUpdate updateForm;

        @BeforeEach
        void beforeEach() {
            this.desenvolvedor = builder.build();
            this.updateForm = this.desenvolvedor.alterar()
                .nivel(nivel)
                .nome(nome)
                .sexo(sexo)
                .dataNascimento(dataNascimento)
                .hobby(hobby)
                .nivelConstraint(exist -> true);
        }

        @Test
        void update() {
            var nivelAlterado = UUID.fromString("c43e6d21-2733-4cbb-95f5-6189f73f1dca");
            var nomeAlterado = "Rô";
            var sexoAlterado = FEMININO;
            var dataNascimentoAlterado = DataNascimento.from(LocalDate.of(2000, 5, 4));
            var hobbyAlterado = "Dançar";

            this.updateForm
                .nivel(nivelAlterado)
                .nome(nomeAlterado)
                .sexo(sexoAlterado)
                .dataNascimento(dataNascimentoAlterado)
                .hobby(hobbyAlterado)
                .apply();

            assertEquals(nivelAlterado, this.desenvolvedor.getNivel());
            assertEquals(nomeAlterado, this.desenvolvedor.getNome());
            assertEquals(sexoAlterado, this.desenvolvedor.getSexo());
            assertEquals(dataNascimentoAlterado, this.desenvolvedor.getDataNascimento());
            assertEquals(hobbyAlterado, this.desenvolvedor.getHobby());
        }

        @Test
        void semNivel() {
            assertThrows(NullPointerException.class, () -> this.updateForm.nivel(null).apply());
        }

        @Test
        void semNome() {
            assertThrows(NullPointerException.class, () -> this.updateForm.nome(null).apply());
        }

        @Test
        void semSexo() {
            assertThrows(NullPointerException.class, () -> this.updateForm.sexo(null).apply());
        }

        @Test
        void semDataNascimento() {
            assertThrows(NullPointerException.class, () -> this.updateForm.dataNascimento(null).apply());
        }

        @Test
        void semHobby() {
            assertDoesNotThrow(() -> this.updateForm.hobby(null).apply());
        }

    }

}
