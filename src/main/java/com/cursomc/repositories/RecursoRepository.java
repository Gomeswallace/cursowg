package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cursomc.domain.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer>{

}
