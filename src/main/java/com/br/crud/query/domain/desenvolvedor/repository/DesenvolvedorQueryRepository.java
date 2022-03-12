package com.br.crud.query.domain.desenvolvedor.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.br.crud.query.domain.desenvolvedor.model.DesenvolvedorQuery;

public interface DesenvolvedorQueryRepository extends Repository<DesenvolvedorQuery, UUID> {

    List<DesenvolvedorQuery> findAll(Example<DesenvolvedorQuery> example, Pageable pageable);

}
