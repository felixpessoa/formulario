package com.felix.formulario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felix.formulario.domain.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
