package com.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursomc.domain.Recurso;
import com.cursomc.repositories.RecursoRepository;

@Service
public class AmbienteService {
	
	@Autowired
	public RecursoRepository repo;

	public Recurso buscar(Integer id) {
		Optional<Recurso> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
