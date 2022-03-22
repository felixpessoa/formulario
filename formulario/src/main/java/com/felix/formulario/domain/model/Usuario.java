package com.felix.formulario.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usuarioId;
	
	private String nome;
	
	@CPF
	private String cpf;
	
//	@Embedded
//	private List<Parametro> parametros = new ArrayList<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacao;

	public Usuario() {
		super();
		this.setDataCriacao(LocalDateTime.now());
	}

	public Usuario(long usuarioId, String nome, String cpf, LocalDateTime dataCriacao) {
		super();
		this.usuarioId = usuarioId;
		this.nome = nome;
		this.cpf = cpf;
		this.setDataCriacao(LocalDateTime.now());
	}
	
	
	
	
	

}
