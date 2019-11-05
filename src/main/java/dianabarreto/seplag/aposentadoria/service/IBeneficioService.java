package dianabarreto.seplag.aposentadoria.service;

import dianabarreto.seplag.aposentadoria.domain.Beneficio;
import dianabarreto.seplag.aposentadoria.domain.CategoriaEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBeneficioService {

    List<Beneficio> list();

    void uploadFile(Long cpf, CategoriaEnum categoria, MultipartFile files) throws IOException;

    String getFilePath(Long cpf);
}
