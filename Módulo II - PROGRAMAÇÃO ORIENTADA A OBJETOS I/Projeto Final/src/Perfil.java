import MinhasExcecoes.CampoVazioException;
import MinhasExcecoes.SenhaInvalidaException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Perfil {
    private String nome;
    private final String LOGIN;
    private String senha;
    List<Post> posts = new ArrayList<>();

    public Perfil(String nome, String login, String senha) {
        this.nome = nome;
        this.LOGIN = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return LOGIN;
    }

    public String getSenha() {
        return senha;
    }

    public void menuInicialPerfil() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tP - Postar");
        System.out.println("\tE - Editar Post");
        System.out.println("\tT - Timeline");
        System.out.println("\tD - Editar dados de Perfil");
        System.out.println("\tS - Sair");
    }

    public void postar() {
        Scanner entrada = new Scanner(System.in);
        Date date = new Date();
        try {
            System.out.println("\n\tPOSTAR.");
            SimpleDateFormat formatoDiaMesAno = new SimpleDateFormat("dd/MM/yyyy");
            String data = formatoDiaMesAno.format(date);

            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            String hora = formatoHora.format(date);

            System.out.print("Digite o conteúdo: ");
            String conteudo = entrada.nextLine();

            if (conteudo.isEmpty() || conteudo.isBlank()) {
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
            System.out.println("\n\tNão há posts em seu perfil " + this.nome);
        }
    }

    public void editarPost(){
        Scanner entrada = new Scanner(System.in);
        if (posts.size() > 0) {
            System.out.println("\n\t\tTIMELINE");
            for (Post p : posts) {
                System.out.println("\n\t" + (posts.indexOf(p)+1) + " - " + p.getData() + " às " + p.getHora() + " - " + p.getConteudo());
            }
            try{
                System.out.print("\nDigite o número do Post: ");
                int numeroPost = getNumberInt()-1;
                System.out.print("\nDigite o novo conteudo do Post: ");
                String novoPost = entrada.nextLine();
                if(novoPost.isEmpty() || novoPost.isBlank()){
                    throw new CampoVazioException();
                }else{
                    Date date = new Date();
                    SimpleDateFormat formatoDiaMesAno = new SimpleDateFormat("dd/MM/yyyy");
                    String data = formatoDiaMesAno.format(date);
                    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                    String hora = formatoHora.format(date);
                    posts.get(numeroPost).setData(data);
                    posts.get(numeroPost).setHora(hora);
                    posts.get(numeroPost).setConteudo(novoPost);
                    System.out.println("\n\tPost atualizado com sucesso!");
                    timeline();
                }
            }catch (CampoVazioException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println("Erro!!!\n\tEdição não realizada");
            }
        } else {
            System.out.println("\n\tNão há posts em seu perfil " + this.nome);
        }
    }

    private int getNumberInt() {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do {
            System.out.print("\nNúmero do Post: ");
            numero = entrada.nextLine();
        } while (!eInteriro(numero));

        return Integer.parseInt(numero);
    }

    private boolean eInteriro(String texto) {
        try {
            if(Integer.parseInt(texto) > 0 && Integer.parseInt(texto) <= posts.size())
            {
                return true;
            }else
            {
                System.out.println("Número inválido, tente novamente");
                return false;
            }
        } catch (Exception e) {
            System.out.println("O número digitado não é inteiro (ou é muito grande), tente novamente");
            return false;
        }
    }

    public void editarDadosPerfil(){
        Scanner entrada = new Scanner(System.in);
        try{
            System.out.print("\nDigite sua senha: ");
            String senha = entrada.nextLine();
            if(this.senha.equals(senha)){
                System.out.println("\n\tDigite N para editar Nome");
                System.out.println("\tDigite S para editar Senha");
                System.out.print("\nOpção: ");
                String opcao = entrada.nextLine().toUpperCase();
                switch (opcao) {
                    case "N" -> {
                        System.out.print("Digite o novo nome: ");
                        String nome = entrada.nextLine().toUpperCase();
                        if (nome.isEmpty() || nome.isBlank()){
                            throw new CampoVazioException();
                        }
                        else {
                            this.nome = nome;
                            System.out.println("\n\tNome atualizado com sucesso! " + this.nome);
                        }
                    }
                    case "S" -> {
                        System.out.print("Digite a nova senha: ");
                        String novaSenha = entrada.nextLine().toUpperCase();
                        if (novaSenha.isEmpty() || novaSenha.isBlank()){
                            throw new CampoVazioException();
                        }
                        else {
                            this.senha = novaSenha;
                            System.out.println("\n\tSenha atualizado com sucesso! " + this.nome);
                        }
                    }
                    default -> System.out.println("\n\tOpção inválida!");
                }
            }else {
                throw new SenhaInvalidaException();
            }
        }
        catch (SenhaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
