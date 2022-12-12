package veiculo;

public abstract class Veiculo {

    protected int anoFabricacao;
    private String cor;

    protected Veiculo(int anoFabricacao, String cor) {
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public abstract void mover();

}
