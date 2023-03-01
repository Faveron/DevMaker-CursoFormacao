import java.util.Map;
import java.util.Scanner;

public class Cadastro {

    public Map cadastrar(Map<String, Cliente> clientes) {
        Scanner entrada = new Scanner(System.in);
        String nome;
        String login = "";
        String senha;

        System.out.println("\n\tTela de Cadastro");
        System.out.println("\nInsira os dados de cadastro");
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        do {
            System.out.print("Login: ");
            login = entrada.nextLine();
            if (clientes.get(login) != null) {
                System.out.println("\t\tLogin inválido ele já é existente");
            }
        } while (clientes.get(login) != null);

        System.out.print("Senha: ");
        senha = entrada.nextLine();
        clientes.put(login, new Cliente(nome, login, senha));
        return clientes;
    }

    public Cliente Logar(Map<String, Cliente> clientes, String login, String senha) {
        if(clientes.get(login) != null && clientes.get(login).getSenha().equals(senha)){
            return clientes.get(login);
        } else {
            return null;
        }
    }
}
