package it.aesys.courses.springboot.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Service
public class TestBase64 {

    public String upload(MultipartFile file) throws IOException {
        String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
        return encodedString;
    }

    public byte[] download(String encoded){
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        return decodedBytes;
    }
}
