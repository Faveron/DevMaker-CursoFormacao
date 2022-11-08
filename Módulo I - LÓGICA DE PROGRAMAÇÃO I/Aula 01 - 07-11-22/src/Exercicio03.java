/*
    Exercício 03
    Entre com 3 números, verifique qual o maior valor dentro os valores informados e imprima na tela a frase
    "o maior númeor é X"
        onde X é a variável contendo o maior valor
*/

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[3];

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Digite %d° número: ", i+1);
            numeros[i] = entrada.nextInt();
        }

        if(numeros[0] >= numeros[1] && numeros[0] >= numeros[2])
        {
            System.out.printf("O maior valor é: %d", numeros[0]);
        }
        else if(numeros[1] >= numeros[0] && numeros[1] >= numeros[2])
        {
            System.out.printf("O maior valor é: %d", numeros[1]);
        }
        else if(numeros[2] >= numeros[0] && numeros[2] >= numeros[1])
        {
            System.out.printf("O maior valor é: %d", numeros[2]);
        }

        entrada.close();
    }
}
