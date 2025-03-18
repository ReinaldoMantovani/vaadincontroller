package br.com.reinaldo.service;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {

    String saveUserprofileImage(String imageOldName, String imageNewName, MultipartFile profileImage) throws IOException;
    void deleteUserProfileImage(String profileImageUrl);
}
