/*
    Dado um salário, informado pelo system.in, deve ser calculado o toal anual incluindo o
    terço de férias e décimo. Também deve ser descontado o valor do INSS e assim obter o salário líquido anual
 */

import java.util.Scanner;

public class Exercicio06
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu salário: ");
        double salario = entrada.nextDouble();

        System.out.printf("Férias: R$ %.2f", salario/3);
        System.out.printf("\nDesconto: R$ %.2f", salario*0.075);
        System.out.printf("\nSalário total anual: R$ %.2f", salario*13 + salario/3);
        System.out.printf("\nSalário total anual líquido: R$ %.2f", salario*13 + salario/3 - salario*0.075*13);
    }
}
