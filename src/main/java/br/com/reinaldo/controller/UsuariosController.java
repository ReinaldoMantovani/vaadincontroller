package br.com.reinaldo.controller;

import java.io.IOException;
import java.util.List;

import br.com.reinaldo.entities.Usuarios;
import br.com.reinaldo.entities.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
		
	private final UsuariosService usuarioService;
	private final UsuarioMapper mapper;

	public UsuariosController(UsuariosService usuariosService, UsuarioMapper mapper) {
		super();
		this.usuarioService = usuariosService;
		this.mapper = mapper;
	}
	
	//Create User
	@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Usuarios> createUsuario(@Valid UsuariosDto usuariosDto) throws IOException {
		Usuarios newUsuario = usuarioService.createUsuario(usuariosDto);

		return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
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
	@PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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
