package br.com.reinaldo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reinaldo.entities.Emitentes;
import br.com.reinaldo.repository.EmitenteRepository;


@Service
public class EmitenteService {
	
	@Autowired
	private  EmitenteRepository repository;
	
	public List<Emitentes> findAll() {
		return repository.findAll();
	}
	
	public Emitentes findById(Long id) {
		Optional<Emitentes> obj = repository.findById(id);
		
		return obj.get();
}
}