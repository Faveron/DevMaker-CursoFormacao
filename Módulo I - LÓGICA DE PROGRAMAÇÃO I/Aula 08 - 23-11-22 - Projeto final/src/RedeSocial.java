import MinhasExcecoes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class RedeSocial {
    static ArrayList<Perfil> perfis = new ArrayList<>();

    public static void main(String[] args) {
        String opcao;

        do {
            System.out.println("\n\t\tBEM-VIMDO a rede social dos Dev_Makers");
            menuInicial();
            opcao = getOpcao();
            switch (opcao) {
                case "C" -> cadastrarPerfil();
                case "E" -> entrar();
                case "F" -> System.out.println("Fechando...");
                case "L" -> listarPerfis();
                default -> System.out.println("Opção inválida!");
            }
            linha();
        } while (!opcao.equals("F"));
    }

    static void menuInicial() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tC - Cadastrar");
        System.out.println("\tE - Entrar");
        System.out.println("\tL - Lista de perfis cadastrados");
        System.out.println("\tF - Fechar");
    }

    static String getOpcao() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Opção: ");
        return entrada.nextLine().toUpperCase();
    }

    static void cadastrarPerfil() {
        linha();
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.println("\n\t\tCADASTRAR\n");
            System.out.print("Digite seu nome: ");
            String nome = entrada.nextLine().toUpperCase();

            System.out.print("Digite o login: ");
            String login = entrada.nextLine();

            System.out.print("Digite a senha: ");
            String senha = entrada.nextLine();

            if (nome.isEmpty() || nome.isBlank() || login.isEmpty() || login.isBlank() || senha.isEmpty() || senha.isBlank()) {
                throw new CampoVazioException();
            }
            for (Perfil p : perfis) {
                if (p.login.equals(login)) {
                    throw new UsuarioExistenteException();
                }
            }

            perfis.add(new Perfil(nome, login, senha));
            System.out.println("\n\tCadastro realizado com sucesso!");
        } catch (CampoVazioException e) {
            System.out.println(e.getMessage());
        } catch (UsuarioExistenteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro!!!");
        }
    }

    static void entrar() {
        linha();
        if (perfis.size() == 0) {
            System.out.println("Nenhum perfil cadastrado.");
        } else {
            try {
                Scanner entrada = new Scanner(System.in);
                int verifica = 0;
                System.out.println("\n\t\tENTRAR\n");

                System.out.print("Login: ");
                String login = entrada.nextLine();

                System.out.print("Senha: ");
                String senha = entrada.nextLine();

                for (int i = 0; i < perfis.size() && verifica == 0; i++) {
                    if (perfis.get(i).login.equals(login)) {
                        verifica++;
                        if (perfis.get(i).senha.equals(senha)) {
                            perfis.get(i).inicializacao();
                        } else {
                            throw new SenhaInvalidaException();
                        }
                    }
                }
                if (verifica == 0) {
                    throw new UsuarioNaoEncontradoException();
                }
            } catch (UsuarioNaoEncontradoException e) {
                System.out.println(e.getMessage());
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro!!!");
            }
        }
    }

    static void listarPerfis() {
        linha();
        if (perfis.size() > 0) {
            System.out.println("\n\tLISTA DE PERFIS CADASTRADOS.\n");
            for (Perfil p : perfis) {
                System.out.println("\t[ Nome: " + p.nome + "; Login: " + p.login + "; Senha: " + p.senha + " ]");
            }
        } else {
            System.out.println("\n\tNENHUM PERFIL CADASTRADO!!\n");
        }
    }

    static void linha() {
        for (int i = 0; i < 120; i++) {
            System.out.print("-");
        }
    }
}