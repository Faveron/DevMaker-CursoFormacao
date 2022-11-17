/*
    Ler um elemento K
    Ler um vetor A de N elementos
    Verifique se o elemento K está presente no vetor
        Se estiver, primir a posição onde ele foi encontrado
        Caso contrário, imprimir mensagem "elemento K não encontrado"
 */

import java.util.Scanner;

public class Exercicio01
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        int posicao = -1;

        System.out.print("Digite o tamanho do vetor: ");
        int N = entrada.nextInt();

        int [] A = new int[N];
        for (int i = 0; i < A.length; i++)
        {
            System.out.printf("Digite o %d° elemento: ", i+1);
            A[i] = entrada.nextInt();
        }

        System.out.print("\nDigite um número inteiro a ser buscado: ");
        int K = entrada.nextInt();

        for (int i = 0; i < N && posicao == -1; i++)
        {
            if(A[i] == K)
            {
                posicao = i+1;
            }
        }

        if (posicao != -1)
        {
            System.out.printf("\nA posição do elemento %d é %d\n", K, posicao);
        }
        else
        {
            System.out.printf("\nElemento %d não enocntrado\n", K);
        }
    }
}