package com.br.crud.query.domain.nivel.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.br.crud.query.domain.nivel.model.NivelQuery;

public interface NivelQueryRepository extends Repository<NivelQuery, UUID> {

    List<NivelQuery> findAll(Example<NivelQuery> example, Pageable pageable);

}
