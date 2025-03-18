package br.com.reinaldo.service.impl;

import br.com.reinaldo.service.ImageService;
import br.com.reinaldo.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static br.com.reinaldo.constants.StorageConstant.PROFILE_STORAGE_PATH;

@Service
public  class ImageServiceImpl implements ImageService {

    @Override
    public String saveUserprofileImage(String imageOldName, String imageNewName, MultipartFile profileImage) throws IOException {
        if (profileImage.getSize() == 0 ){
            return "default.png";
        }

        Path userFolderPath = Paths.get(PROFILE_STORAGE_PATH).toAbsolutePath().normalize();
        if (imageOldName != null){
            FileUtils.deleteFileIfExists(userFolderPath.resolve(imageOldName));
        }

        FileUtils.ensureDirectoryExists(userFolderPath);

        String originalFilename = profileImage.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.')+ 1);
        String finalFileName = imageNewName + "." + extension;
        FileUtils.saveFile(profileImage.getInputStream(), userFolderPath.resolve(finalFileName), StandardCopyOption.REPLACE_EXISTING);

        return finalFileName;
    }

    @Override
    public void deleteUserProfileImage(String profileImafeUrl) {
        try {
            Path userFolderPath = Paths.get(PROFILE_STORAGE_PATH).toAbsolutePath().normalize();
            FileUtils.deleteFileIfExists(userFolderPath.resolve(profileImafeUrl));
        } catch (IOException e) {
            throw new RuntimeException("Ocorreu um erro ao tentar deletar image do perfil do usuário", e);
        }
    }
}
