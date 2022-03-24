package com.felix.formulario.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felix.formulario.domain.dto.DocMetadadosDTO;
import com.felix.formulario.domain.model.metadados.DocMetadados;
import com.felix.formulario.domain.repository.DocMetadadosRepository;
import com.felix.formulario.domain.service.DocMetadadosService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/dm")
public class DocMetadadosController {
	
	private DocMetadadosService docMetadadosService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DocMetadadosDTO creade(@RequestBody DocMetadadosDTO dmObjDTO) {
		DocMetadados newDmObj = docMetadadosService.create(dmObjDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDmObj.getId()).toUri();
		return docMetadadosRepository.save(docMetadados);
	}
	
	
	@GetMapping
	public ResponseEntity<List<DocMetadadosDTO>> findAll() {
		List<DocMetadadosDTO> listDTO = docMetadadosService.findAll().stream()
				.map(obj -> new DocMetadadosDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<DocMetadadosDTO> findById(@PathVariable (value = "id") Long ds_campo) {
		DocMetadadosDTO dmObjDTO = new DocMetadadosDTO(docMetadadosService.findBydId(ds_campo));
		return ResponseEntity.ok().body(dmObjDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DocMetadadosDTO> update (@PathVariable ("id") Long ds_campo, @RequestBody DocMetadadosDTO dmObjDTO) {
		DocMetadadosDTO newDmObjDTO = new DocMetadadosDTO(docMetadadosService.update(ds_campo, dmObjDTO));
		return ResponseEntity.ok().body(newDmObjDTO);
	}
		
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<Void> delete(@PathVariable (value = "id") Long ds_campo){
			docMetadadosService.delete(ds_campo);
			return ResponseEntity.noContent().build();
	}
	
	
	
	

}
