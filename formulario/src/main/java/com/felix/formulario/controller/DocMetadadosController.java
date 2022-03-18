package com.felix.formulario.controller;

import javax.ws.rs.POST;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felix.formulario.domain.model.metadados.DocMetados;
import com.felix.formulario.domain.repository.DocMetadadosRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/campos")
public class DocMetadadosController {
	
	private DocMetadadosRepository docMetadadosRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DocMetados creade(@RequestBody DocMetados docMetados) {
		return docMetadadosRepository.save(docMetados);
	}
	
	
	
	

}
