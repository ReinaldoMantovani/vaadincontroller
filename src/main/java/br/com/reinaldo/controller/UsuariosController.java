package br.com.reinaldo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
		
	private UsuariosService usuarioService;
	
	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuarioService = usuariosService;
	}
	
	//Create User
	@PostMapping
	public ResponseEntity<UsuariosDto> createUsuario(@RequestBody UsuariosDto usuariosDto){
		
		return new ResponseEntity<>(usuarioService.createUsuario(usuariosDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<UsuariosDto> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	// Get Usuario By Id
	@GetMapping("/{id}")
	public ResponseEntity<UsuariosDto> getUsuarioById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(usuarioService.getUsuarioById(id));
	}
	
	// Delete Usuario By Id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuarioById(@PathVariable(name = "id") Long id) {
		usuarioService.deleteUsuarioById(id);
		
		return new ResponseEntity<>("Deletado com sucesso o usuario com o id: " + id, HttpStatus.OK);
	}
}
