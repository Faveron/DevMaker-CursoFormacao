/*
    Exercício 01
    Faça um programa para ler e escrever na tela o seu nome e sua idade
*/
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);

        entrada.close();
    }
}