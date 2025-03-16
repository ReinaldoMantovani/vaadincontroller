package br.com.reinaldo.service;

import java.util.List;

import br.com.reinaldo.dto.UsuariosDto;
import org.springframework.stereotype.Service;

@Service
public interface UsuariosService  {
	UsuariosDto createUsuario(UsuariosDto usuariosDto);
	
	List<UsuariosDto> getAllUsuarios();
	
	UsuariosDto getUsuarioById(Long id);

	UsuariosDto updateUsuario(Long id, UsuariosDto usuariosDto);

	void deleteUsuarioById(Long id);
}
