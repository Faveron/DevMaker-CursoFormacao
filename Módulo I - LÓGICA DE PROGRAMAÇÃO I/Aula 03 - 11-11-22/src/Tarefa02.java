/*
    Crie um programa calculadora que recebe a operação matemática
    (somar, subtrair, multiplicar ou dividir) e os dois números.
    Mostre o resultado da operação.

    Entrada:
        Operação (somar, subtrair, multiplicar ou dividir)
        Número 1
        Número 2

    Saida:
        Resultado da operaçao
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Tarefa02
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Double> valores = new ArrayList<>();

        final int QUANTIDADE = 5;
        double resultado;
        int verifica = 0;

        listaDeOperacoes();
        char operacao = entrada.next().charAt(0);

        for (int i = 0; i < QUANTIDADE; i++)
        {
            valores.add(getNumberDouble(i+1));
        }

        resultado = valores.get(0);
        switch (operacao)
        {
            case '+' ->
            {
                for (int i = 1; i < QUANTIDADE; i++)
                {
                    resultado += valores.get(i);
                }
            }
            case '-' ->
            {
                for (int i = 1; i < QUANTIDADE; i++)
                {
                    resultado -= valores.get(i);
                }
            }
            case 'x' ->
            {
                for (int i = 1; i < QUANTIDADE; i++)
                {
                    resultado *= valores.get(i);
                }
            }
            case ':' ->
            {
                for (int i = 1; i < QUANTIDADE; i++)
                {
                    if (valores.get(i) == 0.0)
                    {
                        System.out.println("Dvisão por zero, não é possível realizar a operação");
                        verifica = 1;
                        break;
                    }else
                    {
                        resultado /= valores.get(i);
                    }
                }
            }
            default ->
            {
                verifica = 1;
                System.out.printf("\nOperação '%c' inválida", operacao);
            }
        }

        for (int i = 0; i < QUANTIDADE && verifica == 0; i++)
        {
            if (i != QUANTIDADE - 1)
            {
                System.out.printf("%.2f %c ", valores.get(i), operacao);
            }else
            {
                System.out.printf("%.2f = %f", valores.get(i), resultado);
            }
        }
    }
    public static void listaDeOperacoes()
    {
        System.out.print("Digite uma das operações a ser feita");
        System.out.print("\n\t + somar");
        System.out.print("\n\t - subtrair");
        System.out.print("\n\t x multiplicar");
        System.out.print("\n\t : dividir");
        System.out.print("\nOperação: ");
    }

    public static double getNumberDouble(int i)
    {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do
        {
            System.out.printf("Digite o %d° valor: ", i);
            numero = entrada.nextLine();
        } while (!eDouble(numero));

        return Double.parseDouble(numero);
    }

    public static boolean eDouble(String texto)
    {
        try
        {
            Double.parseDouble(texto);
            return true;
        } catch (Exception e)
        {
            System.out.println("O número digitado não é real (ou é muito grande), tente novamente");
            return false;
        }
    }
}
