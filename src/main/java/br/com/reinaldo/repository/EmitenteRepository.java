package br.com.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.reinaldo.entities.Emitentes;

public interface EmitenteRepository  extends JpaRepository<Emitentes, Long>{
	
}

