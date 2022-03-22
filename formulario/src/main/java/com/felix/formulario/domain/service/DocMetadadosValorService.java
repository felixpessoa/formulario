package com.felix.formulario.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felix.formulario.domain.model.metadados.DocMetadadosValor;
import com.felix.formulario.domain.repository.DocMetadadosValorRepository;
import com.felix.formulario.domain.service.exceptions.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DocMetadadosValorService {
	
	private DocMetadadosValorRepository docMetadadosValorRepository;
	
	
	public DocMetadadosValor findById(Long cd_valor) {
		Optional<DocMetadadosValor> dMVobj = docMetadadosValorRepository.findById(cd_valor);
		return dMVobj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + cd_valor + " Tipo: "+ DocMetadadosValor.class.getName() ));
	}


	public List<DocMetadadosValor> findAll() {
		return docMetadadosValorRepository.findAll();
	}
	
	
	

}
