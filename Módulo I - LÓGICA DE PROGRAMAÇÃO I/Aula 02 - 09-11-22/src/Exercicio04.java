/*
    Inforar um salário e calcular o INSS, utilizando o valor fixo de 7,5%
 */

import java.util.Scanner;

public class Exercicio04
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu salário: ");
        double salario = entrada.nextDouble();

        System.out.printf("O valor do INSS é R$ %.2f", salario*0.075);
    }
}
