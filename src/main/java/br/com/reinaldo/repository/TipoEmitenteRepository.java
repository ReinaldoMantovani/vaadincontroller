package br.com.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reinaldo.entities.TipoEmitente;

@Repository
public interface TipoEmitenteRepository  extends JpaRepository<TipoEmitente, Long>{
	
}

