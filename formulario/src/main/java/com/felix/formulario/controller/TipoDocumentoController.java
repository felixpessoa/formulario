package com.felix.formulario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felix.formulario.domain.model.metadados.TipoDocumento;
import com.felix.formulario.domain.repository.TipoDocumentoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/documentos")
public class TipoDocumentoController {
	
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TipoDocumento create(@RequestBody TipoDocumento tipoDocumento) {
		return tipoDocumentoRepository.save(tipoDocumento);
	}
	
	
	
}
