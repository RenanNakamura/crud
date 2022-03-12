package com.br.crud.query.domain.nivel.model;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "nivel")
public class NivelQuery extends AbstractAnemicEntity {

    private String descricao;

}
