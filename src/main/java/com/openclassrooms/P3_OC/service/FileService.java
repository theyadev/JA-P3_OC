package com.openclassrooms.P3_OC.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FileService {

    @Value("${server.hostname}")
    private String HOSTNAME;

    @Value("${server.port}")
    private String SERVER_PORT;

    @Value("${upload.folder}")
    private String UPLOAD_FOLDER;

    // Upload picture file and return the fileURL if success
    public String uploadPicture(MultipartFile multipartFile) throws IOException {

        // define the folder for the upload
        // !note use of resource folder to allow external access to the uploaded files
        Path uploadPath = Paths.get(String.format("./src/main/resources/static/%s", UPLOAD_FOLDER)).normalize();

        // create directory if not found
        if (!Files.exists(uploadPath)) {

            Files.createDirectories(uploadPath);

        }

        try (InputStream inputStream = multipartFile.getInputStream()) {

            String filename = multipartFile.getOriginalFilename();

            Path filePath = uploadPath.resolve(filename);

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            return getFileUrl(filename);

        } catch (IOException ioe) {
            return null;
        }
    }

    private String getFileUrl(String filename) {

        String url = String.format("http://%s:%s/%s/%s", this.HOSTNAME, this.SERVER_PORT, this.UPLOAD_FOLDER, filename);

        return UriComponentsBuilder.fromHttpUrl(url).toUriString();
    }

}