package com.br.crud.query.domain.desenvolvedor.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.crud.query.domain.nivel.model.NivelQuery;
import com.br.crud.query.sk.AbstractAnemicEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "desenvolvedor")
public class DesenvolvedorQuery extends AbstractAnemicEntity {

    @ManyToOne
    @JoinColumn(name = "nivel_id", foreignKey = @ForeignKey(name = "fk_nivel_id"))
    private NivelQuery nivel;

    private String nome;

    private String sexo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private Integer idade;

    private String hobby;

}
