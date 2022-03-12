package com.br.crud.query.sk;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class AbstractAnemicEntity {

    @Type(type = "uuid-char")
    @Id
    protected UUID id;

}
