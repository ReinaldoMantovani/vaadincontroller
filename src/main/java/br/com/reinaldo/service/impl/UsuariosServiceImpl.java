package br.com.reinaldo.service.impl;



import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.reinaldo.entities.mapper.UsuarioMapper;
import br.com.reinaldo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.entities.Usuarios;
import br.com.reinaldo.execption.ResourceNotFoundException;
import br.com.reinaldo.repository.UsuariosRepository;
import br.com.reinaldo.service.UsuariosService;

@Service
public  class UsuariosServiceImpl implements UsuariosService {

	private final  UsuariosRepository usuarioRepository;
	private final ImageService imageService;
	private final UsuarioMapper mapper;

	@Autowired
	public  UsuariosServiceImpl(UsuariosRepository usuarioRepository, ImageService imageService, UsuarioMapper mapper) {
		super();
		this.usuarioRepository = usuarioRepository;
        this.imageService = imageService;
		this.mapper = mapper;
    }

	// Create Usuario
	@Override
	public Usuarios createUsuario(UsuariosDto usuariosDto) throws IOException {
		String imageNew = imageService.saveUserprofileImage(null, usuariosDto.getUsername(), usuariosDto.getProfileImageUrl());
		Usuarios usuariosEntity = mapper.mapToEntity(usuariosDto);
		usuariosEntity.setProfileImageUrl(imageNew);
		return usuarioRepository.save(usuariosEntity);
	}

	//Get All Users
		public List<UsuariosDto> getAllUsuarios(){
			List<Usuarios> usuarios = usuarioRepository.findAll();
			
			return usuarios.stream().map(mapper::mapToDto).collect(Collectors.toList());
		}
	//Get Usuario By Id	
		@Override
		public UsuariosDto getUsuarioById(Long id) {
			Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id));
			
			return mapper.mapToDto(usuario);
		}


	@Override
	public UsuariosDto updateUsuario(Long id, UsuariosDto usuariosDto) {
		Optional<Usuarios> usuariosExist = usuarioRepository.findById(id);
		if(usuariosExist.isPresent()){
			Usuarios updateUsuario = mapper.mapToEntity(usuariosDto);
			updateUsuario.setId(id);
			Usuarios usuarioUpdated = usuarioRepository.save(updateUsuario);

			return mapper.mapToDto(usuarioUpdated);
		}
		return null;
	}

	// Delete Usuario By Id
		@Override
		public void deleteUsuarioById(Long id) {
			Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuarios", "id", id));
			
			usuarioRepository.delete(usuario);
		}

	
}
