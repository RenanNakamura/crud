package com.br.crud.command.sk;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class AbstractEntity<A extends AbstractAggregateRoot<A>> extends AbstractAggregateRoot<A> {

    @Type(type = "uuid-char")
    @Id
    protected UUID id;

}
