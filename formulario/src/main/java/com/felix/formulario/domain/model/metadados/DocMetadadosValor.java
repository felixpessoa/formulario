package com.felix.formulario.domain.model.metadados;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felix.formulario.domain.model.Atendimento;
import com.felix.formulario.domain.model.Usuario;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocMetadadosValor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long cd_valor;
	
	private String ds_valor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_campo", insertable = true, updatable = false)
	private DocMetadados cd_campo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_atendimento", insertable = true, updatable = false)
	private Atendimento cd_atendimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_usuario", insertable = true, updatable = false)
	private Usuario cd_usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_Tipo_Documento", insertable = true, updatable = false)
	private TipoDocumento cd_Tipo_Documento;
	
	private String sn_Ativo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nr_Documento", insertable = true, updatable = false)
	private Sequencia nr_Documento;
	
	
	
	public DocMetadadosValor() {
		super();
		this.setDataCriacao(LocalDateTime.now());
	}
	public DocMetadadosValor(Long cd_valor, String ds_valor, DocMetadados cd_campo, Atendimento cd_atendimento,
			Usuario cd_usuario, LocalDateTime dataCriacao, TipoDocumento cd_Tipo_Documento, String sn_Ativo,
			Sequencia nr_Documento) {
		super();
		this.cd_valor = cd_valor;
		this.ds_valor = ds_valor;
		this.cd_campo = cd_campo;
		this.cd_atendimento = cd_atendimento;
		this.cd_usuario = cd_usuario;
		this.setDataCriacao(LocalDateTime.now());
		this.cd_Tipo_Documento = cd_Tipo_Documento;
		this.sn_Ativo = sn_Ativo;
		this.nr_Documento = nr_Documento;
	}
	
	

}
