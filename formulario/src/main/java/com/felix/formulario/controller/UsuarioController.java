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

import com.felix.formulario.domain.model.Usuario;
import com.felix.formulario.domain.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario creade(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	@GetMapping
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable (value = "id") Long usuarioId) {
		return usuarioRepository.findById(usuarioId).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity update (@PathVariable ("id") Long usuarioId, @RequestBody Usuario usuario) {
		return usuarioRepository.findById(usuarioId).map(record -> {
			record.setNome(usuario.getNome());
			record.setCpf(usuario.getCpf());
			Usuario updated = usuarioRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
		
		
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable (value = "id") Long usuarioId){
		return usuarioRepository.findById(usuarioId).map(record -> {
			usuarioRepository.deleteById(usuarioId);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
