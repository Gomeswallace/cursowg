package com.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursomc.domain.Ambiente;
import com.cursomc.repositories.AmbienteRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AmbienteService {
	
	@Autowired
	public AmbienteRepository repo;
	
	public Ambiente buscar(Integer id) {
		Optional<Ambiente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ambiente.class.getName()));
	}
	
	
	public Ambiente insert(Ambiente obj) {
		obj.setId(null);;		
		return repo.save(obj);		
	}

}
