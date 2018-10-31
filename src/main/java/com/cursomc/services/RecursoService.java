package com.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursomc.domain.Recurso;
import com.cursomc.repositories.RecursoRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class RecursoService {
	
	@Autowired
	public RecursoRepository repo;

	public Recurso buscar(Integer id) {
		Optional<Recurso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Recurso.class.getName()));
	}
}
