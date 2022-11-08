/*
    Exercício 04
    Entre com 2 números e apresente-os de forma ordenada
*/

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[2];

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite %d° número: ", i+1);
            numeros[i] = entrada.nextInt();
        }

        if(numeros[0] >= numeros[1])
        {
            System.out.printf("%d >= %d", numeros[0], numeros[1]);
        }
        else
        {
            System.out.printf("%d >= %d", numeros[1], numeros[0]);
        }

        entrada.close();
    }
}
