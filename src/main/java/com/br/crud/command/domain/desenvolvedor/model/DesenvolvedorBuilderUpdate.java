package com.br.crud.command.domain.desenvolvedor.model;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.persistence.EntityNotFoundException;

import com.br.crud.command.sk.vo.DataNascimento;

import lombok.Getter;

@Getter
public class DesenvolvedorBuilderUpdate {

    protected UUID id;
    protected UUID nivel;
    protected String nome;
    protected Sexo sexo;
    protected DataNascimento dataNascimento;
    protected String hobby;

    private Predicate<UUID> nivelConstraint;
    private final Consumer<DesenvolvedorBuilderUpdate> action;

    DesenvolvedorBuilderUpdate(UUID id, Consumer<DesenvolvedorBuilderUpdate> action) {
        this.id = requireNonNull(id);
        this.action = requireNonNull(action);
    }

    public DesenvolvedorBuilderUpdate nivel(UUID nivel) {
        this.nivel = nivel;
        return this;
    }

    public DesenvolvedorBuilderUpdate nome(String nome) {
        this.nome = nome;
        return this;
    }

    public DesenvolvedorBuilderUpdate sexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public DesenvolvedorBuilderUpdate dataNascimento(DataNascimento dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public DesenvolvedorBuilderUpdate hobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public DesenvolvedorBuilderUpdate nivelConstraint(Predicate<UUID> nivelConstraint) {
        this.nivelConstraint = nivelConstraint;
        return this;
    }

    private void applyConstraint() {
        if (!Objects.requireNonNull(this.nivelConstraint).test(this.nivel))
            throw new EntityNotFoundException("Nível não encontrado.");
    }

    public void apply() {
        this.applyConstraint();
        action.accept(this);
    }

}
