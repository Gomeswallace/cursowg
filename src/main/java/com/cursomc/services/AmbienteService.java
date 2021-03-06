package com.cursomc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.cursomc.domain.Ambiente;
import com.cursomc.repositories.AmbienteRepository;
import com.cursomc.services.exceptions.DataIntegrityException;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AmbienteService {
	
	@Autowired
	public AmbienteRepository repo;
	
	public Ambiente find(Integer id) {
		Optional<Ambiente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ambiente.class.getName()));
	}
	
	
	public Ambiente insert(Ambiente obj) {
		obj.setId(null);;		
		return repo.save(obj);		
	}
	
	public Ambiente update(Ambiente obj) {
		find(obj.getId()); //verifica se o obj existe antes de tentar atualizar
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {			
			repo.deleteById(id);			
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não é possível excluir um Ambiente que possui Recursos!");
		}
	}
	
	public List<Ambiente> findAll(){
		return repo.findAll();
	}

}
