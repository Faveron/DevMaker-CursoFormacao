/*
    Dada uma dívida de 10 mil reais que cresce a juros de 2,5% ao mês e uma aplicação de 1500 reais
    com rendimento de 4% ao mês, escrever um algoritmo que determine o número de meses necessário
    para pagar a dívida
 */

public class Exercicio02
{
    public static void main(String[] args)
    {
        double divida = 10000.0;
        double rendimento = 1500.0;
        int meses = 0;

        while (divida > rendimento)
        {
            divida *= 1.025;
            rendimento *= 1.04;
            meses++;
        }
        System.out.printf("O número de meses para pagar a dívida é: %d", meses);
    }
}
