package br.com.reinaldo.service;

import java.io.IOException;
import java.util.List;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.entities.Usuarios;
import org.springframework.stereotype.Service;

@Service
public interface UsuariosService  {
	Usuarios createUsuario(UsuariosDto usuariosDto) throws IOException;
	
	List<UsuariosDto> getAllUsuarios();
	
	UsuariosDto getUsuarioById(Long id);

	UsuariosDto updateUsuario(Long id, UsuariosDto usuariosDto);

	void deleteUsuarioById(Long id);
}
