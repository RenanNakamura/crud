package com.br.crud.command.sk.vo;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

@Embeddable
public class DataNascimento {

    @Column(name = "data_nascimento")
    private final LocalDate data;

    private final Integer idade;

    private DataNascimento(LocalDate data) {
        this.data = data;
        this.idade = this.calcularIdade(data);
    }

    public static DataNascimento from(LocalDate data) {
        return new DataNascimento(data);
    }

    private Integer calcularIdade(LocalDate data) {
        var dataAtual = LocalDate.now();
        return Period.between(data, dataAtual).getYears();
    }
}
