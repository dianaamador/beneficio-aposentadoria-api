package dianabarreto.seplag.aposentadoria.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dianabarreto.seplag.aposentadoria.domain.Beneficio;
import dianabarreto.seplag.aposentadoria.domain.CategoriaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficioService implements IBeneficioService{

    private ArrayList<Beneficio> beneficios;

    @Autowired
    private FileStorageService fileStorageService;

    {
        loadBeneficiarios();
    }

    @Override
    public List<Beneficio> list() {
        return beneficios;
    }

    @Override
    public void uploadFile(Long cpf, CategoriaEnum categoria, MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            String fileLocation = fileStorageService.storeFile(cpf, file);
            atualizaPath(cpf, categoria, fileLocation);
        }
    }

    public void atualizaPath(final Long cpf, final  CategoriaEnum categoria, final String fileLocation) {
        if(cpf != null) {
            Optional<Beneficio> beneficio = beneficios.stream().filter(b -> cpf.equals(b.getCpf())).findFirst();
            if(beneficio.isPresent()) {
                beneficio.get().setPathDocumento(fileLocation);
                beneficio.get().setCategoria(categoria);
            }
        }
    }

    @Override
    public String getFilePath(Long cpf) {
        Optional<Beneficio> beneficio = beneficios.stream().filter(b -> cpf.equals(b.getCpf())).findFirst();
        if(beneficio.isPresent())
            return beneficio.get().getPathDocumento();

        return null;
    }

    private void loadBeneficiarios() {
        beneficios = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();

        try {
            beneficios.addAll(mapper.readValue(new File("src/main/resources/Beneficiarios.json"), new TypeReference<List<Beneficio>>(){}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
