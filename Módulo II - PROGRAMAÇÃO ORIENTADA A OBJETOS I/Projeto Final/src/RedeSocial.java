import MinhasExcecoes.CampoVazioException;
import MinhasExcecoes.SenhaInvalidaException;
import MinhasExcecoes.UsuarioExistenteException;
import MinhasExcecoes.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeSocial {
    public static void main(String[] args) {
        List<Perfil> perfis = new ArrayList<>();
        RedeSocial redeSocial = new RedeSocial();
        String opcao;

        do {
            System.out.println("\n\t\tBEM-VIMDO a rede social dos Dev_Makers");
            redeSocial.menuInicial();
            opcao = redeSocial.getOpcao();
            redeSocial.linha();
            switch (opcao) {
                case "C" -> redeSocial.cadastrarPerfil(perfis);
                case "E" -> redeSocial.logarPerfil(perfis, redeSocial);
                case "L" -> redeSocial.listarPerfis(perfis);
                case "F" -> System.out.println("\n\tFechando...");
                default -> System.out.println("\n\tOpção inválida!");
            }
            redeSocial.linha();
        } while (!opcao.equals("F"));
    }

    public void linha() {
        for (int i = 0; i < 150; i++) {
            System.out.print("-");
        }
    }

    public void menuInicial() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tC - Cadastrar");
        System.out.println("\tE - Entrar");
        System.out.println("\tL - Lista de perfis cadastrados");
        System.out.println("\tF - Fechar");
    }

    public String getOpcao() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Opção: ");
        return entrada.nextLine().toUpperCase();
    }

    public void cadastrarPerfil(List<Perfil> perfis) {
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
                if (p.getLogin().equals(login)) {
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

    public void logarPerfil(List<Perfil> perfis, RedeSocial redeSocial) {
        if (perfis.size() == 0) {
            System.out.println("\n\tNenhum perfil cadastrado.");
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
                    if (perfis.get(i).getLogin().equals(login)) {
                        verifica++;
                        if (perfis.get(i).getSenha().equals(senha)) {
                            redeSocial.acoesPerfil(perfis.get(i), redeSocial);
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

    public void acoesPerfil(Perfil p, RedeSocial r) {
        String opcao;
        do {
            r.linha();
            System.out.println("\n\tBem-vindo, " + p.getNome());
            p.menuInicialPerfil();
            opcao = r.getOpcao();
            r.linha();
            switch (opcao) {
                case "P" -> p.postar();
                case "T" -> p.timeline();
                case "S" -> System.out.println("\n\tLogout...");
                default -> System.out.println("\n\tOpção inválida!");
            }
        } while (!opcao.equals("S"));
    }

    public void listarPerfis(List<Perfil> perfis) {
        if (perfis.size() > 0) {
            System.out.println("\n\tLISTA DE PERFIS CADASTRADOS.\n");
            for (Perfil p : perfis) {
                System.out.println("\t[ Nome: " + p.getNome() + "; Login: " + p.getLogin() + "; Senha: " + p.getSenha() + " ]");
            }
        } else {
            System.out.println("\n\tNENHUM PERFIL CADASTRADO!!");
        }
    }
}