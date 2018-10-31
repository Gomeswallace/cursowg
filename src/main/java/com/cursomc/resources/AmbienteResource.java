package com.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cursomc.domain.Recurso;
import com.cursomc.services.AmbienteService;

@RestController
@RequestMapping(value="/ambientes")
public class AmbienteResource {
	@Autowired
	private AmbienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Recurso obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}

}
