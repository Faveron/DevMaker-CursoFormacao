/*
    Os funcionáris de uma empresa receberam um aumento de salário
    - Técnico 50%
    - Gerentes 30%
    - Demais 20%
    Escreva um programa que recebe como entrada o salário atual e o cargo do funcionário,
    e apresente o novo salário após o aumento
 */

import java.util.Scanner;

public class Exercicio02
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o cargo: ");
        String cargo = entrada.nextLine();

        System.out.print("Digite seu salário atual: ");
        double salario = entrada.nextDouble();

        switch (cargo)
        {
            case "Tecnico" -> System.out.printf("Seu salário será de R$ %.2f", salario * 1.5);

            case "Gerente" -> System.out.printf("Seu salário será de R$ %.2f", salario * 1.3);

            case "Demais" -> System.out.printf("Seu salário será de R$ %.2f", salario * 1.2);

            default -> System.out.print("Cargo inválido");
        }
    }
}
