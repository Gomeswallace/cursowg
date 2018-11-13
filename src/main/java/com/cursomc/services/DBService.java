package com.cursomc.services;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Ambiente;
import com.cursomc.domain.Recurso;
import com.cursomc.repositories.AmbienteRepository;
import com.cursomc.repositories.RecursoRepository;

@Service
public class DBService {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;

	public void instatiateDevDataBase() {
		Ambiente amb1 = new Ambiente(null, "Sala", "Sala 1");
		Ambiente amb2 = new Ambiente(null, "Garagem", "Principal");
		
		Recurso rec1 = new Recurso(null, "Porta principal", false, amb1);
		Recurso rec2 = new Recurso(null, "TV", true, amb1);
		Recurso rec3 = new Recurso(null, "Portão principal", true, amb2);
		
		amb1.getRecursos().addAll(Arrays.asList(rec1, rec2));		
		amb2.getRecursos().addAll(Arrays.asList(rec3));

		ambienteRepository.saveAll(Arrays.asList(amb1, amb2));		
		recursoRepository.saveAll(Arrays.asList(rec1, rec2, rec3));
	}
	
}
