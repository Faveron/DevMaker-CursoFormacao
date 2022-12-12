package veiculo.automotor.motocicleta;

import veiculo.automotor.VeiculoAutomotor;

public class Motoquinha extends VeiculoAutomotor {

    public Motoquinha(int anoFabricacao, String cor) {
        super(anoFabricacao, cor);
    }

    @Override
    public void ligar() {
        System.out.println("Motoca sempre pronta, já to ligada");
        this.ligado = true;
    }

    @Override
    public void desligar() {
        System.out.println("Eita, vamos roda");
        System.out.println("Motoca desligada");
        this.ligado = false;
    }

    @Override
    public void mover() {
        System.out.println("Não caia, continue a acelerar");
    }

    public void mover(int aumentoDeVelocidade) {
        System.out.println("Velocidade aumentada em: "+aumentoDeVelocidade);
    }

}
