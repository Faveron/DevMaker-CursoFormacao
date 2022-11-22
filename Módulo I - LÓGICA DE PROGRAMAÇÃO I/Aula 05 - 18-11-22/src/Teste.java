/*
    Tentando aprimorar a validação de entrada de número
 */

import java.util.Scanner;

public class Teste
{
    public static void main(String[] args)
    {
        double n;
        boolean verificador;

        do
        {
            System.out.print("\nDigite um inteiro: ");
            n = getDouble();
            if (n <= 0)
            {
                System.out.print("Digite um valor maior que zero!");
                verificador = true;
            } else verificador = false;
        }while (verificador);

        System.out.println();
        System.out.println(n);
    }

    public static int getInt()
    {
        Scanner entrada = new Scanner(System.in);
        boolean verificador;
        String numero;

        do
        {
            try
            {
                numero = entrada.nextLine();
                Integer.parseInt(numero);
                verificador = false;
            } catch (Exception e)
            {
                numero = "";
                System.out.print("Entrada inválida!\nTente novamente: ");
                verificador = true;
            }
        } while (verificador);

        return Integer.parseInt(numero);
    }

    public static float getFloat()
    {
        Scanner entrada = new Scanner(System.in);
        boolean verificador;
        String numero;

        do
        {
            try
            {
                numero = entrada.nextLine();
                Float.parseFloat(numero);
                verificador = false;
            } catch (Exception e)
            {
                numero = "";
                System.out.print("Entrada inválida!\nTente novamente: ");
                verificador = true;
            }
        } while (verificador);

        return Float.parseFloat(numero);
    }

    public static double getDouble()
    {
        Scanner entrada = new Scanner(System.in);
        boolean verificador;
        String numero;

        do
        {
            try
            {
                numero = entrada.nextLine();
                Double.parseDouble(numero);
                verificador = false;
            } catch (Exception e)
            {
                numero = "";
                System.out.print("Entrada inválida!\nTente novamente: ");
                verificador = true;
            }
        } while (verificador);

        return Double.parseDouble(numero);
    }

    public static char getChar()
    {
        Scanner entrada = new Scanner(System.in);
        boolean verificador;
        char caracter;

        do
        {
            try
            {
                caracter = entrada.next().charAt(0);
                verificador = false;
            } catch (Exception e)
            {
                caracter = '*';
                System.out.print("Entrada inválida!\nTente novamente: ");
                verificador = true;
            }
        } while (verificador);

        return caracter;
    }

    public static String getString()
    {
        Scanner entrada = new Scanner(System.in);
        boolean verificador;
        String texto;

        do
        {
            try
            {
                texto = entrada.nextLine();
                verificador = false;
            } catch (Exception e)
            {
                texto = "";
                System.out.print("Entrada inválida!\nTente novamente: ");
                verificador = true;
            }
        } while (verificador);

        return texto;
    }
}
