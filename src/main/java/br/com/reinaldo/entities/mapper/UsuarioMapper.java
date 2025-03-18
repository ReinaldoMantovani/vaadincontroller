package br.com.reinaldo.entities.mapper;

import br.com.reinaldo.dto.UsuariosDto;
import br.com.reinaldo.entities.Usuarios;
import br.com.reinaldo.utils.CustomMultipartFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "profileImageUrl", ignore = true) // Ignorar se não for necessário
    Usuarios mapToEntity(UsuariosDto usuariosDto);

    UsuariosDto mapToDto(Usuarios usuario);

    // Método de mapeamento personalizado
    default MultipartFile map(String profileImageUrl) {
        if (profileImageUrl == null || profileImageUrl.isEmpty()) {
            return null; // Retorne null se a URL for vazia
        }

        // Crie um objeto File a partir da URL
        File file = new File(profileImageUrl);
        if (!file.exists()) {
            return null; // Retorne null se o arquivo não existir
        }

        // Retorne um novo CustomMultipartFile
        return new CustomMultipartFile(file);
    }
}