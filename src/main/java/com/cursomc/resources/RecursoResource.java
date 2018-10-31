package com.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.domain.Recurso;

@RestController
@RequestMapping(value="/recursos")
public class RecursoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Recurso> listar() {
		
		Recurso cat1 = new Recurso(1, "Informatica");
		Recurso cat2 = new Recurso(1, "Escritorio");
		
		List<Recurso> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);		
		
		return lista;
	}

}
