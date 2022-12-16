package br.com.ada.zombiedice.jogo;

import br.com.ada.zombiedice.dado.Dado;
import br.com.ada.zombiedice.dado.Face;
import br.com.ada.zombiedice.pote.PoteDado;
import br.com.ada.zombiedice.zumbi.Zumbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turno {
    private final List<Dado> dadosUtilizadosNoTurno;
    private int qtdTirosSorteados;
    private int qtdCerebrosSorteados;
    private final Zumbi jogador;
    private final PoteDado pote;

    public Turno(Zumbi jogador, PoteDado pote) {
        this.jogador = jogador;
        this.pote = pote;
        this.qtdTirosSorteados = 0;
        this.qtdCerebrosSorteados = 0;
        this.dadosUtilizadosNoTurno = new ArrayList<>();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        String continuarJogando;
        List<Dado> dadosASeremRelancados = new ArrayList<>();
        do {
            System.out.print("\nJogador " + jogador.getNome() + " é a sua vez, realize uma jogada\nAperte ENTER para lançar");
            scanner.nextLine();
            System.out.println();
            List<Dado> dadosLancados = jogador.lancarDados(pote, dadosASeremRelancados);
            dadosASeremRelancados.clear();
            for (Dado dado : dadosLancados) {
                System.out.println("Voce lançou o dado " + dado.getTipoDado() + " e obteve " + dado.getFaceSorteada());
                boolean dadoContabilizado = contabilizarDadoJogado(dado);
                if (!dadoContabilizado) {
                    dadosASeremRelancados.add(dado);
                }
            }
            if (forcarEncerramentoTurno()) {
                System.out.println("\nQue pena "+jogador.getNome()+" seu turno foi encerrado, você levou " + qtdTirosSorteados + " tiros");
                break;
            }
            System.out.println("\nPontuação atual no turno: "+ qtdCerebrosSorteados + " cerebros consumidos, " + qtdTirosSorteados + " tiros levaoos");
            System.out.print("\n" + jogador.getNome() + " deseja jogar novamente(s/n)? ");
            continuarJogando = scanner.nextLine();
        } while (continuarJogando.equalsIgnoreCase("s"));
        contabilizarTurno();
        pote.devolverDado(dadosUtilizadosNoTurno);
        pote.devolverDado(dadosASeremRelancados);
    }

    private boolean forcarEncerramentoTurno() {
        return qtdTirosSorteados >= 3 || jogador.getQtdCerebros() + qtdCerebrosSorteados >= 13;
    }

    private boolean contabilizarDadoJogado(Dado dado) {
        boolean contabilizado = dado.getFaceSorteada() != Face.PASSOS;
        if (contabilizado) {
            dadosUtilizadosNoTurno.add(dado);
            if (dado.getFaceSorteada() == Face.CEREBRO) {
                System.out.println("Você consumiu mais cerebros");
                qtdCerebrosSorteados++;
            } else {
                System.out.println("Levou tiro");
                qtdTirosSorteados++;
            }
        } else {
            System.out.println("Vai aprecisar correr mais, sua presa fugiu");
        }
        return contabilizado;
    }

    private void contabilizarTurno() {
        if (qtdTirosSorteados < 3) {
            int qtdeCerebrosAtual = jogador.getQtdCerebros();
            int novaQtdeCerebrosConsumidos = qtdeCerebrosAtual + qtdCerebrosSorteados;
            jogador.setQtdCerebros(novaQtdeCerebrosConsumidos);
            System.out.println("\nContabilizado turno do jogador\n\t" + jogador.getNome() +
                    " tem " + novaQtdeCerebrosConsumidos +
                    " cerebros ao todo");
        }
    }
}
