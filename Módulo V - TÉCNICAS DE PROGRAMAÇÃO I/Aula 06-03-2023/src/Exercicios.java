/*
    1) Filtragem de dados: dada uma lista de números inteiros
    crie uma stream finita e use o método filter para retornar apenas os números pares.

    2) Agregação de dados: dada uma lista de números inteiros
    crie uma stream finita e use o método reduce para calcular a soma de todos os números.

    3) Transformação de dados: dada uma lista de strings
    crie uma stream finita e use o método map para convertê-las em números inteiros.

    Jorge Lucas21:49
    4) Ordenação de dados: dada uma lista de números inteiros
    crie uma stream finita e use o método sorted para classificá-los em ordem crescente.

    5) Crie o objeto Pessoa com os atributos nome:string e idade:integer
    no metodo main inicialize uma lista de pessoas
    use a stream para:
     - filtrar somente pessoas com mais de 18 anos de idade
     - tranformar em uma lista somente dos nomes dessas pessoas
     - limitar a no máximo 3 resultados | limit()
     - e retorne uma lista dessa stream
    imprima essa lista
 */

import java.util.List;

public class Exercicios {
    public static void main(String[] args) {
        var numeros = List.of(1, 10, 2, 9, 3, 8, 4, 7, 5, 6);

        System.out.println("\n\t\tExercicio 01");
        List<Integer> numeroPares = numeros.stream().filter((n) -> n % 2 == 0).toList();
        System.out.println(numeroPares);

        System.out.println("\n\t\tExercicio 02");
        Integer soma = numeros.stream().reduce(0, (n1, n2) -> n1+n2);
        System.out.println(soma);
    }
}