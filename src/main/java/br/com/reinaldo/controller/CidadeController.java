package br.com.reinaldo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reinaldo.dto.CidadeDto;
import br.com.reinaldo.service.CidadeService;


@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	private final CidadeService cidadeService;
	
	public CidadeController(CidadeService cidadeService) {
		super();
		this.cidadeService = cidadeService;
	}
	
	// Create cidade
	@PostMapping
	public ResponseEntity<CidadeDto> createCidade(@Valid @RequestBody CidadeDto cidadeDto){
		return  new ResponseEntity<>(cidadeService.createCidade(cidadeDto), HttpStatus.CREATED);
	}
	
	// Get All Cidade
	@GetMapping
	public List<CidadeDto> getAllCidades(){
		return cidadeService.getAllCidades();
	}
	
	// Get Cidade By Id
	@GetMapping("/{id}")
	public ResponseEntity<CidadeDto> getCidadeById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(cidadeService.getCidadeById(id));
	}
	
	// Delete Cidade By Id
	@DeleteMapping("/{ìd}")
	public ResponseEntity<String> deletCidadeById(@PathVariable(name = "id" )Long id) {
		cidadeService.deleCidadeById(id);
		
		return new ResponseEntity<>("Deletado com sucesso a cidade com id: " + id,HttpStatus.OK);
	}
}
