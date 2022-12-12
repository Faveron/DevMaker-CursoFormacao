package veiculo.automotor;

import veiculo.Veiculo;

public abstract class VeiculoAutomotor extends Veiculo {

    protected boolean ligado;

    public VeiculoAutomotor(int anoFabricacao, String cor) {
        super(anoFabricacao, cor);
    }

    public abstract void ligar();

    public abstract void desligar();

}
