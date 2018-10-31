package com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cursomc.domain.Ambiente;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer> {

}
