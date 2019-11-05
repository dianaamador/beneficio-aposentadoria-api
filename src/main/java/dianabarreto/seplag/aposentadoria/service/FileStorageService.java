package dianabarreto.seplag.aposentadoria.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    @Value("${beneficio.raiz}")
    private String raiz;
    @Value("${beneficio.diretorio-imagens}")
    private String diretorio;

    public String storeFile(Long cpf, MultipartFile file) {
        return this.salvar(cpf, diretorio, file);
    }

    private String salvar(Long cpf, String diretorio, MultipartFile file) {
        Path diretorioPath = Paths.get(raiz, diretorio + File.separator + cpf);
        Path filePath = diretorioPath.resolve(file.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);

            file.transferTo(filePath.toFile());

            return filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
