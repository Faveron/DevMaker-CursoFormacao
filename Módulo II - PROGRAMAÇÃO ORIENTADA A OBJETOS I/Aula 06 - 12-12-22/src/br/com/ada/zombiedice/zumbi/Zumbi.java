package br.com.ada.zombiedice.zumbi;

import br.com.ada.zombiedice.dado.Dado;
import br.com.ada.zombiedice.pote.PoteDado;

import java.util.ArrayList;
import java.util.List;

public class Zumbi {

    private final String nome;
    private int qtdCerebros;
    private int qtdTiros;

    public Zumbi(String nome) {
        this.nome = nome;
        this.qtdCerebros = 0;
        this.qtdTiros = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setQtdCerebros(int qtdCerebros) {
        this.qtdCerebros = qtdCerebros;
    }

    public int getQtdCerebros() {
        return qtdCerebros;
    }

    public List<Dado> lancarDados(PoteDado pote, List<Dado> dadosSortearamPassosNaJogadaAnterior) {
        pote.embaralhar();
        List<Dado> dadosDoPote = new ArrayList<>(dadosSortearamPassosNaJogadaAnterior);
        dadosDoPote.addAll(pote.entregarDado(3 - dadosSortearamPassosNaJogadaAnterior.size()));
        for(Dado dado: dadosDoPote){
            dado.jogar();
        }
        return dadosDoPote;
    }
}
