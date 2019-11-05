package dianabarreto.seplag.aposentadoria.domain;

public enum CategoriaEnum {

    IDENTIFICACAO("Identificação"),
    VIDA_FUNCIONAL("Vida Funcional"),
    CONTAGEM_TEMPO("Contagem de tempo"),
    REMUNERACAO_PROVENTOS("Remuneração/Proventos");

    private String descricao;

    CategoriaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
