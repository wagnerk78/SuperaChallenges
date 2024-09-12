package desafioResistores;

public enum CoresResistores {
    PRETO(0, "preto"),
    MARROM(1, "marrom"),
    VERMELHO(2,"vermelho"),
    LARANJA(3, "laranja"),
    AMARELO(4, "amarelo"),
    VERDE(5, "verde"),
    AZUL(6, "azul"),
    VIOLETA(7, "violeta"),
    CINZA(8, "cinza"),
    BRANCO(9, "branco");

    private final int valor;
    private final String cor;

    CoresResistores(int valor, String cor) {
        this.valor = valor;
        this.cor = cor;
    }

    public int getValor() {
        return valor;
    }

    public String getCor() {
        return cor;
    }


    public static CoresResistores fromValor(int valor) {
        for (CoresResistores cor : CoresResistores.values()) {
            if (cor.getValor() == valor) {
                return cor;
            }
        }
        throw new IllegalArgumentException("Valor não encontrado: " + valor);
    }
}

