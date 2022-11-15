/*
    Crie um programa que receba nomes e preços de produtos e
    depois no final mostre qual o produto mais caro e o mais barato.

    Entradas:
        Nome e preço do produto
        Finalizar operação

    Saida:
        Nome e preço do produto mais caro
        Nome e preço do produto mais barato
 */

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Tarefa03
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        String nome, operacao;
        double preco, max, min;
        int indexMax, indexMin;

        do
        {
            listaDeOperacoes();
            operacao = entrada.nextLine().toLowerCase();

            switch (operacao)
            {
                case "c" ->
                {
                    System.out.print("Digite o nome do produto: ");
                    nome = entrada.nextLine();
                    preco = getNumberDouble();
                    produtos.add(new Produto(nome, preco));
                }
                case "f" -> System.out.println("Saindo...");
                default -> System.out.printf("\nOperação '%s' inválida", operacao);
            }
        }while (!Objects.equals(operacao, "f"));

        if (produtos.size() > 0)
        {
            indexMax = 0;
            max = produtos.get(0).preco;
            indexMin = 0;
            min = produtos.get(0).preco;

            for (int i = 1; i < produtos.size(); i++)
            {
                if(produtos.get(i).preco >= max)
                {
                    indexMax = i;
                    max = produtos.get(i).preco;
                }
                else if(produtos.get(i).preco <= min)
                {
                    indexMin = i;
                    min = produtos.get(i).preco;
                }
            }

            System.out.println("\nNome e preço do produto mais caro");
            System.out.printf("Nome: %s", produtos.get(indexMax).nome);
            System.out.printf("\nPreço: R$ %.2f", produtos.get(indexMax).preco);
            System.out.println();
            System.out.println("\nNome e preço do produto mais barato");
            System.out.printf("Nome: %s", produtos.get(indexMin).nome);
            System.out.printf("\nPreço: R$ %.2f", produtos.get(indexMin).preco);
        }
        else
        {
            System.out.println("Nenhum produto cadastrado!");
        }
    }

    public static void listaDeOperacoes()
    {
        System.out.println("\nDigite uma das operações a ser feita");
        System.out.println("\t c - Cadastrar");
        System.out.println("\t f - Sair");
        System.out.print("Operação: ");
    }

    public static double getNumberDouble()
    {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do
        {
            System.out.print("Digite o valor: ");
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

class Produto
{
    String nome;
    double preco;

    Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }
}


