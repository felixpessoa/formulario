package com.felix.formulario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felix.formulario.domain.model.metadados.DocMetadados;
import com.felix.formulario.domain.repository.DocMetadadosRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/dm")
public class DocMetadadosController {
	
	private DocMetadadosRepository docMetadadosRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DocMetadados creade(@RequestBody DocMetadados docMetadados) {
		return docMetadadosRepository.save(docMetadados);
	}
	
	
	@GetMapping
	public List<DocMetadados> findAll() {
		return docMetadadosRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable (value = "id") Long ds_campo) {
		return docMetadadosRepository.findById(ds_campo).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable ("id") Long ds_campo, @RequestBody DocMetadados docMetadados) {
		return docMetadadosRepository.findById(ds_campo).map(record -> {
			record.setDs_campo(docMetadados.getDs_campo());
			record.setSn_ativo(docMetadados.getSn_ativo());
			DocMetadados updated = docMetadadosRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
		
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long ds_campo){
		return docMetadadosRepository.findById(ds_campo).map(record -> {
			docMetadadosRepository.deleteById(ds_campo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	

}
