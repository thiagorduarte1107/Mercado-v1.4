package View;

public enum FormaDePagamento {
    CARTAO_DE_CREDITO(1, "Cartão de Crédito"),
    PIX(2, "PIX"),
    BOLETO(3, "Boleto");

    private final int codigo;
    private final String descricao;

    FormaDePagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FormaDePagamento porCodigo(int codigo) {
        for (FormaDePagamento forma : values()) {
            if (forma.codigo == codigo) {
                return forma;
            }
        }
        throw new IllegalArgumentException("Código de pagamento inválido: " + codigo);
    }
}

