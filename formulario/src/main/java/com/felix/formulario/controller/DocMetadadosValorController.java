package com.felix.formulario.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.felix.formulario.domain.dto.DocMetadadosValorDTO;
import com.felix.formulario.domain.model.metadados.DocMetadadosValor;
import com.felix.formulario.domain.repository.DocMetadadosValorRepository;
import com.felix.formulario.domain.service.DocMetadadosValorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/dmv")
public class DocMetadadosValorController {
	
	private DocMetadadosValorService docMetadadosValorService;
	
	private DocMetadadosValorRepository docMetadadosValorRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DocMetadadosValor creade(@RequestBody DocMetadadosValor docMetadadosValor) {
		return docMetadadosValorRepository.save(docMetadadosValor);
	}
	
	
	@GetMapping
	public ResponseEntity<List<DocMetadadosValorDTO>> findAll() {
		List<DocMetadadosValorDTO> list = docMetadadosValorService.findAll().stream()
				.map(obj -> new DocMetadadosValorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<DocMetadadosValorDTO> findById(@PathVariable (value = "id") Long cd_valor) {
		DocMetadadosValorDTO dMVObj = new DocMetadadosValorDTO(docMetadadosValorService.findById(cd_valor));
		return ResponseEntity.ok().body(dMVObj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable ("id") Long cd_valor, @RequestBody DocMetadadosValor docMetadadosValor) {
		return docMetadadosValorRepository.findById(cd_valor).map(record -> {
			record.setDs_valor(docMetadadosValor.getDs_valor());
			DocMetadadosValor updated = docMetadadosValorRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
		
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long cd_valor){
		return docMetadadosValorRepository.findById(cd_valor).map(record -> {
			docMetadadosValorRepository.deleteById(cd_valor);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	

}
