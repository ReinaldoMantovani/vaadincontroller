package br.com.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.reinaldo.entities.Usuarios;

@Repository
public interface UsuariosRepository  extends JpaRepository<Usuarios, Long>{
	
}

