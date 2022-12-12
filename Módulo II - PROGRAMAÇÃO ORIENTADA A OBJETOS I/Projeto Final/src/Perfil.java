import MinhasExcecoes.CampoVazioException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {
    private String nome;
    final String login;
    private String senha;
    List<Post> posts = new ArrayList<>();

    public Perfil(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void inicializacao() {
        String opcao;
        linha();

        do {
            System.out.println("\n\tBem-vindo, " + this.nome);
            menuInicialPerfil();
            opcao = getOpcao();
            switch (opcao) {
                case "P" -> postar();
                case "T" -> timeline();
                case "S" -> System.out.println("Logout...");
                default -> System.out.println("Opção inválida!");
            }
            linha();
        } while (!opcao.equals("S"));
    }

    private void menuInicialPerfil() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tP - Postar");
        System.out.println("\tT - Timeline");
        System.out.println("\tS - Sair");
    }

    private String getOpcao() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Opção: ");
        return entrada.nextLine().toUpperCase();
    }

    private void linha() {
        for (int i = 0; i < 150; i++) {
            System.out.print("-");
        }
    }

    private void postar() {
        linha();
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.println("\n\tPOSTAR.");
            System.out.print("\nDigite a data: ");
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
            timeline();
        } catch (CampoVazioException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro!!!");
        }
    }

    private void timeline() {
        linha();
        if (posts.size() > 0) {
            System.out.println("\n\t\tTIMELINE");
            for (Post p : posts) {
                System.out.println("\n\t" + p.getData() + " às " + p.getHora() + " - " + p.getConteudo());
            }
        } else {
            System.out.println("\n\tNão há posts em seu perfil " + this.nome);
        }
    }
}
