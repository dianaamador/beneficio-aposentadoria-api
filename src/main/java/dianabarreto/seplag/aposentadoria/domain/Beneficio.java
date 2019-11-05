package dianabarreto.seplag.aposentadoria.domain;

import lombok.Data;

@Data
public class Beneficio {

    private String nome;
    private Long cpf;
    private String orgao;
    private String matricula;
    private CategoriaEnum categoria;
    private String pathDocumento;


}
