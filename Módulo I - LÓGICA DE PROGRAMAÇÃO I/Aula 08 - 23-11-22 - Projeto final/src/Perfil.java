import MinhasExcecoes.CampoVazioException;

import java.util.ArrayList;
import java.util.Scanner;

public class Perfil {
    String nome;
    String login;
    String senha;
    ArrayList<Post> posts = new ArrayList<>();

    Perfil(String n, String l, String s) {
        this.nome = n;
        this.login = l;
        this.senha = s;
    }

    void inicializacao() {
        String opcao;

        do {
            System.out.println("\n\tBem-vindo, " + this.nome);
            menuInicialPerfil();
            opcao = getOpcao();
            switch (opcao) {
                case "P" -> Postar();
                case "T" -> timeline();
                case "S" -> System.out.println("Logout...");
                default -> System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("S"));
    }

    void menuInicialPerfil() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tP - Postar");
        System.out.println("\tT - Timeline");
        System.out.println("\tS - Sair");
    }

    String getOpcao() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Opção: ");
        return entrada.nextLine().toUpperCase();
    }

    void Postar() {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Digite a data: ");
            String data = entrada.nextLine();

            System.out.print("Digite a hora: ");
            String hora = entrada.nextLine();

            System.out.print("Digite o conteúdo: ");
            String conteudo = entrada.nextLine();

            if (data.isEmpty() || data.isBlank() || hora.isEmpty() || hora.isBlank() || conteudo.isEmpty() || conteudo.isBlank()) {
                throw new CampoVazioException();
            }

            posts.add(new Post(data, hora, conteudo));
            System.out.println("\n\tPost realizado!");
        } catch (CampoVazioException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro!!!");
        }
        for (int i = 0; i < 120; i++) {
            System.out.print("-");
        }
    }

    void timeline() {
        if (posts.size() > 0) {
            System.out.println("\n\t\tTIMELINE");
            for (Post p : posts) {
                System.out.println("\n\t" + p.data + " às " + p.hora + " - " + p.conteudo);
            }
        } else {
            System.out.println("\n\tNão há posts em seu perfil " + this.nome);
        }
        for (int i = 0; i < 120; i++) {
            System.out.print("-");
        }
    }
}
