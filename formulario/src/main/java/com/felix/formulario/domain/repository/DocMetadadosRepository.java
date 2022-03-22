package com.felix.formulario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felix.formulario.domain.model.metadados.DocMetadados;

@Repository
public interface DocMetadadosRepository extends JpaRepository<DocMetadados, Long>{

}
