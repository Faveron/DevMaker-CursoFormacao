package veiculo.automotor.carro;

public class HB20 extends Carro {

    public HB20(int anoFabricacao, String cor, int qtdePortas, boolean arCondicionado) {
        super(anoFabricacao, cor, qtdePortas, arCondicionado);
    }

    @Override
    public void ligar() {
        super.ligar();
        System.out.println("Ar condicionado ligado");
    }

}
