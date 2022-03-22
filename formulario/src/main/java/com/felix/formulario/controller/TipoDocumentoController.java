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
	public TipoDocumento creade(@RequestBody TipoDocumento tipoDocumento) {
		return tipoDocumentoRepository.save(tipoDocumento);
	}
	
	
	@GetMapping
	public List<TipoDocumento> findAll() {
		return tipoDocumentoRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable (value = "id") Long cd_tipo_documento) {
		return tipoDocumentoRepository.findById(cd_tipo_documento).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable ("id") Long cd_tipo_documento, @RequestBody TipoDocumento tipoDocumento) {
		return tipoDocumentoRepository.findById(cd_tipo_documento).map(record -> {
			record.setDs_tipo_documento(tipoDocumento.getDs_tipo_documento());
			record.setSn_ativo(tipoDocumento.getSn_ativo());
			TipoDocumento updated = tipoDocumentoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
		
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long cd_tipo_documento){
		return tipoDocumentoRepository.findById(cd_tipo_documento).map(record -> {
			tipoDocumentoRepository.deleteById(cd_tipo_documento);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	
	
}
