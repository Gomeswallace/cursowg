package com.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursomc.domain.Usuario;
import com.cursomc.repositories.UsuarioRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
