package com.felix.formulario.domain.dto;

import java.io.Serializable;

import com.felix.formulario.domain.model.metadados.DocMetadados;

public class DocMetadadosDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long cd_campo;
	private String ds_campo;
	private String sn_ativo;
	
	private String ds_identificador;

	
	public DocMetadadosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DocMetadadosDTO(DocMetadados dmObj) {
		super();
		this.cd_campo = dmObj.getCd_campo();
		this.ds_campo = dmObj.getDs_campo();
		this.sn_ativo = dmObj.getSn_ativo();
		this.ds_identificador = dmObj.getDs_identificador();
	}


	public Long getCd_campo() {
		return cd_campo;
	}


	public void setCd_campo(Long cd_campo) {
		this.cd_campo = cd_campo;
	}


	public String getDs_campo() {
		return ds_campo;
	}


	public void setDs_campo(String ds_campo) {
		this.ds_campo = ds_campo;
	}


	public String getSn_ativo() {
		return sn_ativo;
	}


	public void setSn_ativo(String sn_ativo) {
		this.sn_ativo = sn_ativo;
	}


	public String getDs_identificador() {
		return ds_identificador;
	}


	public void setDs_identificador(String ds_identificador) {
		this.ds_identificador = ds_identificador;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
}
