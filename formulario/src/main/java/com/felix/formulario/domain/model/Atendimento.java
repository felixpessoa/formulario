package com.felix.formulario.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long cd_atendimento;
	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAtendimento;

	public Atendimento() {
		super();
		this.setDataAtendimento(LocalDateTime.now());
	}

	public Atendimento(Long cd_atendimento, LocalDateTime dataAtendimento) {
		super();
		this.cd_atendimento = cd_atendimento;
		this.setDataAtendimento(LocalDateTime.now());
	}

}
