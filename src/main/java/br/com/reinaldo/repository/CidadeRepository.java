package br.com.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.reinaldo.entities.Cidade;

@Repository
public interface CidadeRepository  extends JpaRepository<Cidade, Long>{
	
}

