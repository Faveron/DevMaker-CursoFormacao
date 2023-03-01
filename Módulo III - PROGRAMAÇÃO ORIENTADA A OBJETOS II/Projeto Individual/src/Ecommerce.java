import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ecommerce {
    Map<String, Cliente> clientes = new HashMap<>();
    Cadastro cadastro = new Cadastro();
    Estoque estoque = new Estoque();

    private void linha() {
        for (int i = 0; i < 150; i++) {
            System.out.print("-");
        }
    }

    private String getOpcao() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Opção: ");
        return entrada.nextLine().toUpperCase();
    }

    public void iniciar() {
        String opcao;
        do {
            linha();
            System.out.println("\n\t\tBEM-VIMDO ao E-commerce dos Dev_Makers");
            menuInicial();
            opcao = getOpcao();
            switch (opcao) {
                case "C" -> cadastrar();
                case "E" -> entrar();
                case "F" -> System.out.println("\n\tFechando...");
                default -> System.out.println("\n\tOpção inválida!");
            }
        } while (!opcao.equals("F"));
    }

    private void menuInicial() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tC - Cadastrar");
        System.out.println("\tE - Entrar");
        System.out.println("\tF - Fechar");
    }

    private void cadastrar() {
        linha();
        clientes = cadastro.cadastrar(clientes);
    }

    private void entrar() {
        Scanner entrada = new Scanner(System.in);
        int tentativas = 0;

        linha();
        System.out.print("\n\tTela de Login");
        while (tentativas < 3) {
            System.out.print("\nLogin: ");
            String login = entrada.nextLine();
            System.out.print("Senha: ");
            String senha = entrada.nextLine();
            Cliente cliente = cadastro.Logar(clientes, login, senha);
            if (cliente == null) {
                tentativas++;
                System.out.println("\t\tLogin ou senha inválidos. Você tem mais " + (3 - tentativas) + " tentativas.");
            } else {
                tentativas = 3;
                IniciarCliente(cliente);
            }
        }
    }

    private void IniciarCliente(Cliente c) {
        String opcao = "";
        do {
            linha();
            System.out.println("\n\tBem-vindo, " + c.getNome().toUpperCase());
            menuInicialCliente();
            opcao = getOpcao();
            switch (opcao) {
                case "P" -> {
                    linha();
                    estoque.listar();
                }
                case "C" -> {
                    linha();
                    c.listar();
                }
                case "A" -> adicionarAoCarrinho(c);
                case "R" -> System.out.println("\n\tDel do carrinho");
                case "S" -> System.out.println("\n\tSaindo...");
                default -> System.out.println("\n\tOpção inválida!");
            }
        } while (!opcao.equals("S"));
    }

    private void menuInicialCliente() {
        System.out.println("\nSelecione um das opções:");
        System.out.println("\tP - Vasualizar produtos");
        System.out.println("\tC - Vasualizar carrinho");
        System.out.println("\tA - Adicionar ao carrinho");
        System.out.println("\tR - Retirar do carrinho");
        System.out.println("\tS - Sair");
    }

    private void adicionarAoCarrinho(Cliente c) {
        Scanner entrada = new Scanner(System.in);
        int cod, qtd;

        do {
            System.out.print("Código do produto: ");
            cod = entrada.nextInt();
            if (estoque.mapProdutos.get(cod) == null) {
                System.out.println("\t\tProduto não encontrado!");
            }
        } while (estoque.mapProdutos.get(cod) == null);

        do {
            System.out.print("Quantidade do produto: ");
            qtd = entrada.nextInt();
            if (estoque.mapProdutos.get(cod).getQuantidade() < qtd) {
                System.out.println("\t\tEstoque insuficiente!");
            }
        } while (estoque.mapProdutos.get(cod).getQuantidade() < qtd);

    }
}
