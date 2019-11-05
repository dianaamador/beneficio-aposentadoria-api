package dianabarreto.seplag.aposentadoria.controller;

import dianabarreto.seplag.aposentadoria.domain.Beneficio;
import dianabarreto.seplag.aposentadoria.domain.CategoriaEnum;
import dianabarreto.seplag.aposentadoria.service.IBeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("${origem-permitida}")
@RequestMapping("/Beneficio")
public class BeneficioController {

    @Autowired
    private IBeneficioService service;

    @GetMapping
    public List<Beneficio> list(){
        return service.list();
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public ResponseEntity upload(@RequestParam("cpf") Long cpf, @RequestParam("categoria") CategoriaEnum categoria, @RequestParam("file") MultipartFile file) throws IOException {
        service.uploadFile(cpf, categoria, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/pathFile")
    public String getFilePath(@RequestParam("cpf") Long cpf) {
        return service.getFilePath(cpf);
    }
}
