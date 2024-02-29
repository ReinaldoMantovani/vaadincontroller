package br.com.reinaldo.service;

import java.util.List;

import br.com.reinaldo.dto.UsuariosDto;



public interface UsuariosService  {
	UsuariosDto createUsuario(UsuariosDto usuariosDto);
	
	List<UsuariosDto> getAllUsuarios();
	
	UsuariosDto getUsuarioById(Long id);
	
	void deleteUsuarioById(Long id);
}
