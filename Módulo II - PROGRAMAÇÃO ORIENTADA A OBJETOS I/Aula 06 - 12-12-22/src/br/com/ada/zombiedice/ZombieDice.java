package br.com.ada.zombiedice;

import br.com.ada.zombiedice.dado.Dado;
import br.com.ada.zombiedice.dado.DadoAmarelo;
import br.com.ada.zombiedice.dado.DadoVerde;
import br.com.ada.zombiedice.dado.DadoVermelho;
import br.com.ada.zombiedice.jogo.Turno;
import br.com.ada.zombiedice.pote.PoteDado;
import br.com.ada.zombiedice.zumbi.Zumbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZombieDice {
    public static void main(String[] args) {
        ZombieDice tabuleiro = new ZombieDice();
        ArrayList<Dado> dados = new ArrayList<>();
        ArrayList<Zumbi> jogadores = new ArrayList<>();

        tabuleiro.cadastrarJogadores(jogadores);

        tabuleiro.criarDados(dados);
        PoteDado pote = new PoteDado(dados);

        tabuleiro.jogar(jogadores, pote);
    }

    public void cadastrarJogadores(ArrayList<Zumbi> jogadores) {
        Scanner entrada = new Scanner(System.in);
        String opcao = "s";
        String nome;
        for (int i = 0; opcao.equalsIgnoreCase("s"); i++) {
            System.out.printf("Digite o nome do %dº jogador: ", i + 1);
            nome = entrada.nextLine();
            jogadores.add(new Zumbi(nome));
            System.out.print("Deseja cadastrar outro jogador(s/n)? ");
            opcao = entrada.nextLine();
        }
    }

    public void criarDados(ArrayList<Dado> dados) {
        for (int i = 0; i < 6; i++) {
            dados.add(new DadoVerde());
        }
        for (int i = 0; i < 4; i++) {
            dados.add(new DadoAmarelo());
        }
        for (int i = 0; i < 3; i++) {
            dados.add(new DadoVermelho());
        }
    }

    public void jogar(List<Zumbi> jogadores, PoteDado pote) {
        for (Zumbi j : jogadores) {
            placar(jogadores);
            Turno turno = new Turno(j, pote);
            turno.jogar();
            if (j.getQtdCerebros() >= 13) {
                System.out.println("\nParabéns " + j.getNome() + " você VENCEU!!!!!!");
                System.exit(0);
            }
        }
        jogar(jogadores, pote);
    }

    public void placar(List<Zumbi> jogadores){
        System.out.println("\n\t\tPONTUAÇÃO");
        for (Zumbi j : jogadores){
            System.out.println("\t"+j.getNome()+": "+j.getQtdCerebros()+" cerebros");
        }
    }
}