package com.felix.formulario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felix.formulario.domain.model.metadados.DocMetadados;

@Repository
public interface DocMetadadosRepository extends JpaRepository<DocMetadados, Long>{

	
	@Query("SELECT obj FROM DOC_METADADOS WHERE obj.ds_identificador =: ds_identificador")
	DocMetadados findByDM(@Param("ds_identificador") String ds_identificador);
	
		
	
	
}
