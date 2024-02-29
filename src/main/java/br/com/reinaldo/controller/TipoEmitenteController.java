package br.com.reinaldo.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reinaldo.dto.TipoEmitenteDto;
import br.com.reinaldo.service.TipoEmitenteService;

@RestController
@RequestMapping("/tipo-emitente")
public class TipoEmitenteController {
	private TipoEmitenteService tipoEmitenteService;
	
	public TipoEmitenteController(TipoEmitenteService tipoEmitenteService) {
		super();
		this.tipoEmitenteService = tipoEmitenteService;
	}
	
	// Create Tipo Emitente
	@PostMapping
	public ResponseEntity<TipoEmitenteDto> createTipoEmitente(@RequestBody TipoEmitenteDto tipoEmitenteDto) {
		return new ResponseEntity<>(tipoEmitenteService.createTipoEmitente(tipoEmitenteDto), HttpStatus.CREATED);
	}
	
	//Get All TipoEmitente
	@GetMapping
	public List<TipoEmitenteDto> getAllTipoEmitente(){
		return tipoEmitenteService.getAllTipoEmitente();
	}
}
