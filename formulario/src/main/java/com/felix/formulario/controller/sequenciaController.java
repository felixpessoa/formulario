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

import com.felix.formulario.domain.model.metadados.DocMetadadosValor;
import com.felix.formulario.domain.model.metadados.Sequencia;
import com.felix.formulario.domain.repository.SequenciaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/sequencia")
public class sequenciaController {
	
	private SequenciaRepository sequenciaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Sequencia creade(@RequestBody Sequencia sequencia) {
		return sequenciaRepository.save(sequencia);
	}
	
	@GetMapping
	public List<Sequencia> findAll() {
		return sequenciaRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable (value = "id") Long sequenciaId) {
		return sequenciaRepository.findById(sequenciaId).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
			
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long sequenciaId){
		return sequenciaRepository.findById(sequenciaId).map(record -> {
			sequenciaRepository.deleteById(sequenciaId);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	

}
