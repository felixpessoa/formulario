package com.felix.formulario.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felix.formulario.domain.model.metadados.DocMetadadosValor;

public class DocMetadadosValorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long cd_valor;
	
	private String ds_valor;
	
	private Long cd_campo;
	
	
	private Long cd_atendimento;
	
	
	private Long cd_usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacao;
	
	
	private Long cd_Tipo_Documento;
	
	private String sn_Ativo;
	
	
	private Long nr_Documento;


	public DocMetadadosValorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DocMetadadosValorDTO(DocMetadadosValor obj) {
		super();
		this.cd_valor = obj.getCd_valor();
		this.ds_valor = obj.getDs_valor();
		this.cd_campo = obj.getCd_campo().getCd_campo();
		this.cd_atendimento = obj.getCd_atendimento().getCd_atendimento();
		this.cd_usuario = obj.getCd_usuario().getUsuarioId();
		this.dataCriacao = obj.getDataCriacao();
		this.cd_Tipo_Documento = obj.getCd_Tipo_Documento().getCd_tipo_documento();
		this.sn_Ativo = obj.getSn_Ativo();
		this.nr_Documento = obj.getNr_Documento().getSequenciaId();
	}


	public Long getCd_valor() {
		return cd_valor;
	}


	public void setCd_valor(Long cd_valor) {
		this.cd_valor = cd_valor;
	}


	public String getDs_valor() {
		return ds_valor;
	}


	public void setDs_valor(String ds_valor) {
		this.ds_valor = ds_valor;
	}


	public Long getCd_campo() {
		return cd_campo;
	}


	public void setCd_campo(Long cd_campo) {
		this.cd_campo = cd_campo;
	}


	public Long getCd_atendimento() {
		return cd_atendimento;
	}


	public void setCd_atendimento(Long cd_atendimento) {
		this.cd_atendimento = cd_atendimento;
	}


	public Long getCd_usuario() {
		return cd_usuario;
	}


	public void setCd_usuario(Long cd_usuario) {
		this.cd_usuario = cd_usuario;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Long getCd_Tipo_Documento() {
		return cd_Tipo_Documento;
	}


	public void setCd_Tipo_Documento(Long cd_Tipo_Documento) {
		this.cd_Tipo_Documento = cd_Tipo_Documento;
	}


	public String getSn_Ativo() {
		return sn_Ativo;
	}


	public void setSn_Ativo(String sn_Ativo) {
		this.sn_Ativo = sn_Ativo;
	}


	public Long getNr_Documento() {
		return nr_Documento;
	}


	public void setNr_Documento(Long nr_Documento) {
		this.nr_Documento = nr_Documento;
	}
	
	
	
	
	
}
