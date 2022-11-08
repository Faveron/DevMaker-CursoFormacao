/*
    Exercício 02
    Faça um programa para ler e escrever na tela os seguintes dados:
    - Nome
    - Endereço
    - Telefone
    - Cidade
    - CEP
*/

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite seu endereço: ");
        String endereco = entrada.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("Digite seu Cidade: ");
        String cidade = entrada.nextLine();

        System.out.print("Digite seu CEP: ");
        String cep = entrada.nextLine();

        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Cdade: " + cidade);
        System.out.println("CEP: " + cep);

        entrada.close();
    }
}
