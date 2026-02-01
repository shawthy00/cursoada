package Trabalho;

public enum Status {
    PENDENTE(1),
    EXECUTANDO(2),
    CONCLUIDO(3);

    private final int codigo;

    // construtor para uso de códigos, o que simplifica a classe Cadastro
    Status(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Status fromCodigo(int codigo) {
        for (Status s : values()) {
            if (s.codigo == codigo) {
                return s;
            }
        }
        throw new IllegalArgumentException("O código " + codigo +  " é inválido!");
    }
}
