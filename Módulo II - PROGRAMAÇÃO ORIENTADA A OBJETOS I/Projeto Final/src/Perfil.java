import MinhasExcecoes.CampoVazioException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {
    private final String NOME;
    private final String LOGIN;
    private final String SENHA;
    List<Post> posts = new ArrayList<>();

    public Perfil(String nome, String login, String senha) {
        this.NOME = nome;
        this.LOGIN = login;
        this.SENHA = senha;
    }

    public String getNome() {
        return NOME;
    }

    public String getLogin() {
        return LOGIN;
    }

    public String getSenha() {
        return SENHA;
    }

    public void menuInicialPerfil() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tP - Postar");
        System.out.println("\tT - Timeline");
        System.out.println("\tS - Sair");
    }

    public void postar() {
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

    public void timeline() {
        if (posts.size() > 0) {
            System.out.println("\n\t\tTIMELINE");
            for (Post p : posts) {
                System.out.println("\n\t" + p.getData() + " às " + p.getHora() + " - " + p.getConteudo());
            }
        } else {
            System.out.println("\n\tNão há posts em seu perfil " + this.NOME);
        }
    }
}
