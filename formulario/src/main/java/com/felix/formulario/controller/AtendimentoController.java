package com.felix.formulario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felix.formulario.domain.model.Atendimento;
import com.felix.formulario.domain.repository.AtendimentoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {
	
	private AtendimentoRepository atendimentoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Atendimento creade(@RequestBody Atendimento atendimento) {
		return atendimentoRepository.save(atendimento);
	}
	
	
	@GetMapping
	public List<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable (value = "id") Long cd_atendimento) {
		return atendimentoRepository.findById(cd_atendimento).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity update (@PathVariable ("id") Long cd_atendimento, @RequestBody Atendimento atendimento) {
//		return atendimentoRepository.findById(cd_atendimento).map(record -> {
//			Atendimento updated = atendimentoRepository.save(record);
//			return ResponseEntity.ok().body(updated);
//		}).orElse(ResponseEntity.notFound().build());
//	}
		
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long cd_atendimento){
		return atendimentoRepository.findById(cd_atendimento).map(record -> {
			atendimentoRepository.deleteById(cd_atendimento);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	

}
