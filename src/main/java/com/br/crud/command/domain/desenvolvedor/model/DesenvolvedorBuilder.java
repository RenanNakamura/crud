package com.br.crud.command.domain.desenvolvedor.model;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;

import javax.persistence.EntityNotFoundException;

import com.br.crud.command.sk.vo.DataNascimento;

public class DesenvolvedorBuilder {

    protected UUID id;
    protected UUID nivel;
    protected String nome;
    protected Sexo sexo;
    protected DataNascimento dataNascimento;
    protected String hobby;

    private Predicate<UUID> nivelConstraint;

    public DesenvolvedorBuilder nivel(UUID nivel) {
        this.nivel = nivel;
        return this;
    }

    public DesenvolvedorBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public DesenvolvedorBuilder sexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public DesenvolvedorBuilder dataNascimento(DataNascimento dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public DesenvolvedorBuilder hobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public DesenvolvedorBuilder nivelConstraint(Predicate<UUID> nivelConstraint) {
        this.nivelConstraint = nivelConstraint;
        return this;
    }

    private void applyConstraint() {
        if (!Objects.requireNonNull(this.nivelConstraint).test(this.nivel))
            throw new EntityNotFoundException("Nível não encontrado.");
    }

    public Desenvolvedor build() {
        this.id = UUID.randomUUID();

        this.applyConstraint();

        return new Desenvolvedor(this);
    }

}
