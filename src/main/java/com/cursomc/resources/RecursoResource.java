package com.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursomc.domain.Recurso;
import com.cursomc.services.RecursoService;

@RestController
@RequestMapping(value="/recursos")
public class RecursoResource {
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public List<Recurso> listar() {
		
		Recurso rec1 = new Recurso(1, "TESTES 1", true);
		Recurso rec2 = new Recurso(2, "TESTES 2", false);
		
		List<Recurso> lista = new ArrayList<>();
		lista.add(rec1);
		lista.add(rec2);
		
		return lista;				
	}
	*/
	
	@Autowired
	private RecursoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Recurso obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Recurso obj){ //RequestBody convert o json para java
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
