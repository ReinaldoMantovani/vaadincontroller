package br.com.reinaldo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
		
	private final UsuariosService usuarioService;
	
	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuarioService = usuariosService;
	}
	
	//Create User
	@PostMapping
	public ResponseEntity<UsuariosDto> createUsuario(@Valid @RequestBody UsuariosDto usuariosDto){
		
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

	// Update Usuario
	@PutMapping("/{id}")
	public ResponseEntity<UsuariosDto> updateUsuario(@PathVariable Long id, @RequestBody UsuariosDto usuariosDto){
		UsuariosDto updateUsuario = usuarioService.updateUsuario(id, usuariosDto);
		if(updateUsuario == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
	}
	
	// Delete Usuario By Id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuarioById(@PathVariable(name = "id") Long id) {
		usuarioService.deleteUsuarioById(id);
		
		return new ResponseEntity<>("Deletado com sucesso o usuario com o id: " + id, HttpStatus.OK);
	}
}
