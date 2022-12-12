package veiculo.automotor.carro;

public class VwGol extends Carro {

    public static int numeroDoProjeto = 54;

    //Mesmo sem que seja escrito o código desse construtor o Java cria quando não há outro
    public VwGol(int anoFabricacao, String cor, int qtdePortas) {
        super(anoFabricacao, cor, qtdePortas);
    }

    public VwGol(int anoFabricacao, String cor, int qtdePortas, boolean arCondicionado) {
        super(anoFabricacao, cor, qtdePortas, arCondicionado);
    }

    @Override
    public void ligar() {
        // Sem a palavra static o método pertence ao contexto do objeto
        // e não da classe
        // A palavra 'this' referencia o objeto que estou manipulando
        habilitarCircuitosEletricos();
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    private void habilitarCircuitosEletricos() {
        System.out.println("Circuitos eletricos habilitados");
    }

}
