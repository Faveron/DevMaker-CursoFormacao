package veiculo;

public class Bicicleta extends Veiculo {

    public Bicicleta(int anoFabricacao, String cor) {
        super(anoFabricacao, cor);
    }

    @Override
    public void mover() {
        System.out.println("Continue a pedalar");
    }

}
