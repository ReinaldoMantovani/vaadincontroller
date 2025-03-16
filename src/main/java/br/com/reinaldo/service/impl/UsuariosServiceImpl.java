package br.com.reinaldo.service.impl;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.entities.Usuarios;
import br.com.reinaldo.execption.ResourceNotFoundException;
import br.com.reinaldo.repository.UsuariosRepository;
import br.com.reinaldo.service.UsuariosService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	
	
	
	private final  UsuariosRepository usuarioRepository;
	
	
	public  UsuariosServiceImpl(UsuariosRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	// Create Usuario
	@Transactional
	@Override
	public UsuariosDto createUsuario(UsuariosDto usuariosDto) {
		
		Usuarios usuario = mapToEntity(usuariosDto);
		Usuarios newUsuario =  usuarioRepository.save(usuario);
		
		//Convert entity to DTO
		UsuariosDto usuarioResponse = mapToDto(newUsuario);
		
		return usuarioResponse;
		
	}
	//Get All Users
		public List<UsuariosDto> getAllUsuarios(){
			List<Usuarios> usuarios = usuarioRepository.findAll();
			
			return usuarios.stream().map(usuario -> mapToDto(usuario)).collect(Collectors.toList());
		}
	//Get Usuario By Id	
		@Override
		public UsuariosDto getUsuarioById(Long id) {
			Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id));
			
			return mapToDto(usuario);
		}


	@Override
	public UsuariosDto updateUsuario(Long id, UsuariosDto usuariosDto) {
		Optional<Usuarios> usuariosExist = usuarioRepository.findById(id);
		if(usuariosExist.isPresent()){
			Usuarios updateUsuario = mapToEntity(usuariosDto);
			updateUsuario.setId(id);
			Usuarios usuarioUpdated = usuarioRepository.save(updateUsuario);

			return mapToDto(usuarioUpdated);
		}
		return null;
	}

	// Delete Usuario By Id
		@Override
		public void deleteUsuarioById(Long id) {
			Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id));
			
			usuarioRepository.delete(usuario);
		}
	
	private UsuariosDto mapToDto(Usuarios usuario) {
		UsuariosDto usuariosDto = new UsuariosDto();
		usuariosDto.setId(usuario.getId());
		usuariosDto.setNome(usuario.getNome());
		usuariosDto.setSobrenome(usuario.getSobrenome());
		usuariosDto.setStatusUsuario(usuario.getStatusUsuario());
		usuariosDto.setCidade(usuario.getCidade());
		usuariosDto.setCpf(usuario.getCpf());
		usuariosDto.setMomentoRegistro(usuario.getMomentoRegistro());
		usuariosDto.setRg(usuario.getRg());
		usuariosDto.setTipoEmitente(usuario.getTipoEmitente());
		
		return usuariosDto;
	}
	
	private Usuarios mapToEntity(UsuariosDto usuariosDto) {
		Usuarios usuario = new Usuarios();
	    usuario.setNome(usuariosDto.getNome());
	    usuario.setSobrenome(usuariosDto.getSobrenome());
	    usuario.setStatusUsuario(usuariosDto.getStatusUsuario());
	    usuario.setCidade(usuariosDto.getCidade());
	    usuario.setCpf(usuariosDto.getCpf());
	    usuario.setRg(usuariosDto.getRg());
		usuario.setMomentoRegistro(usuariosDto.getMomentoRegistro());
	    usuario.setTipoEmitente(usuariosDto.getTipoEmitente());
		usuario.setTipoEmitente(usuariosDto.getTipoEmitente());
		return usuario;
	}
	
	
	
	
	


	
}
