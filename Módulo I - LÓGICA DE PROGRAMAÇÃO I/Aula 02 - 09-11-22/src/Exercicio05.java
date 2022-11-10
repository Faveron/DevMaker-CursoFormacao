/*
    Calcular o terço de férias sobre o salário informado
 */

import java.util.Scanner;

public class Exercicio05
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu salário: ");
        double salario = entrada.nextDouble();

        System.out.printf("O valor do INSS é R$ %.2f", salario/3);
    }
}
