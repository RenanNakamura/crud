package com.br.crud.command.domain.desenvolvedor.model;

import static java.util.Objects.requireNonNull;
import static javax.persistence.EnumType.STRING;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.br.crud.command.domain.desenvolvedor.usecase.AlterarDesenvolvedorUseCase.DesenvolvedorAlterado;
import com.br.crud.command.domain.desenvolvedor.usecase.RegistrarDesenvolvedorUseCase;
import com.br.crud.command.sk.AbstractEntity;
import com.br.crud.command.sk.vo.DataNascimento;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Entity
@Table
public class Desenvolvedor extends AbstractEntity<Desenvolvedor> {

    @Type(type = "uuid-char")
    @Column(name = "nivel_id")
    private UUID nivel;

    @Column(length = 180)
    private String nome;

    @Enumerated(value = STRING)
    private Sexo sexo;

    @Embedded
    private DataNascimento dataNascimento;

    @Column(length = 200)
    private String hobby;

    public static DesenvolvedorBuilder builder() {
        return new DesenvolvedorBuilder();
    }

    Desenvolvedor(DesenvolvedorBuilder builder) {
        super.id = builder.id;
        this.nivel = requireNonNull(builder.nivel);
        this.nome = requireNonNull(builder.nome);
        this.sexo = requireNonNull(builder.sexo);
        this.dataNascimento = requireNonNull(builder.dataNascimento);
        this.hobby = builder.hobby;

        registerEvent(RegistrarDesenvolvedorUseCase.DesenvolvedorRegistrado.from(this));
    }

    public DesenvolvedorBuilderUpdate alterar() {
        return new DesenvolvedorBuilderUpdate(id, form -> {
            this.nivel = requireNonNull(form.getNivel());
            this.nome = requireNonNull(form.getNome());
            this.sexo = requireNonNull(form.getSexo());
            this.dataNascimento = requireNonNull(form.getDataNascimento());
            this.hobby = form.getHobby();

            registerEvent(DesenvolvedorAlterado.from(this));
        });
    }

}
