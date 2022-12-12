package veiculo.automotor.carro;

import veiculo.automotor.VeiculoAutomotor;

public class Carro extends VeiculoAutomotor {

    private int qtdePortas;
    private boolean arCondicionado;

    public Carro(int anoFabricacao, String cor, int qtdePortas, boolean arCondicionado) {
        super(anoFabricacao, cor);
        this.qtdePortas = qtdePortas;
        this.arCondicionado = arCondicionado;
    }

    public Carro(int anoFabricacao, String cor, int qtdePortas) {
        super(anoFabricacao, cor);
        this.qtdePortas = qtdePortas;
    }

    public int getQtdePortas() {
        return qtdePortas;
    }

    public boolean getArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean getLigado() {
        return ligado;
    }

    @Override
    public void ligar() {
        System.out.println("Contato da chave");
        System.out.println("Acionando parte eletrica");
        System.out.println("Acionando motor de partida");
        System.out.println("Motor ligado");
        this.ligado = true;
    }

    @Override
    public void desligar() {
        System.out.println("Cortando fornecimento de combutível");
        System.out.println("Cortando fornecimento de energia");
        System.out.println("Motor desligado");
        this.ligado = false;
    }

    @Override
    public void mover() {
        System.out.println("Rodas girando");
    }

}
