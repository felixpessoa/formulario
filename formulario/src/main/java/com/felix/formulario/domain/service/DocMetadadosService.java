package com.felix.formulario.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.felix.formulario.domain.dto.DocMetadadosDTO;
import com.felix.formulario.domain.model.metadados.DocMetadados;
import com.felix.formulario.domain.repository.DocMetadadosRepository;
import com.felix.formulario.domain.service.exceptions.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocMetadadosService {
	
	private DocMetadadosRepository docMetadadosRepository;
	
	
	public DocMetadados findBydId(Long cd_campo) {
		Optional<DocMetadados> docMetadadosObj = docMetadadosRepository.findById(cd_campo);
		return docMetadadosObj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + cd_campo +" Tipo: "+ DocMetadados.class.getName()));
	}
	
	
	public List<DocMetadados> findAll() {
		return docMetadadosRepository.findAll();
	}
	
	
	public DocMetadados update (Long cd_campo, DocMetadadosDTO dmObjDTO) {
		DocMetadados oldDocMetadadosObj = findBydId(cd_campo);
		oldDocMetadadosObj.setCd_campo(dmObjDTO.getCd_campo());
		oldDocMetadadosObj.setSn_ativo(dmObjDTO.getSn_ativo());
		oldDocMetadadosObj.setDs_identificador(dmObjDTO.getDs_identificador());
		
		return docMetadadosRepository.save(oldDocMetadadosObj);
	}
	
	
	public void delete(Long cd_campo) {
		DocMetadados oldDocMetadadosObj = findBydId(cd_campo);
		docMetadadosRepository.deleteById(cd_campo);
	}
	
	
	public Long create (DocMetadadosDTO dmObjDTO) {
		if(findByDm(dmObjDTO) != null) {
			return dmObjDTO.getCd_campo(); 
		}
		//salvar DOc Metadados se não existir.
		DocMetadados newDmObj = new DocMetadados();
		newDmObj.setCd_campo(dmObjDTO.getCd_campo());
		newDmObj.setDs_campo(dmObjDTO.getDs_campo());
		newDmObj.setSn_ativo(dmObjDTO.getSn_ativo());
		newDmObj.setDs_identificador(dmObjDTO.getDs_identificador());
		docMetadadosRepository.save(newDmObj);
	
		return newDmObj.getCd_campo();
				
	}
	
	
	private DocMetadados findByDm(DocMetadadosDTO dmObjDTO) {
		DocMetadados docMetadados = docMetadadosRepository.findByDM(dmObjDTO.getDs_identificador());
		if (docMetadados != null) {
			return null;
		}
		return docMetadados;
	}

	
}
