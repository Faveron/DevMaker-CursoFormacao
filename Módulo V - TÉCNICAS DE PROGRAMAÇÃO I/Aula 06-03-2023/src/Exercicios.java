/*
    1) Filtragem de dados: dada uma lista de números inteiros
    crie uma stream finita e use o método filter para retornar apenas os números pares.

    2) Agregação de dados: dada uma lista de números inteiros
    crie uma stream finita e use o método reduce para calcular a soma de todos os números.

    3) Transformação de dados: dada uma lista de strings
    crie uma stream finita e use o método map para convertê-las em números inteiros.

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
        System.out.println("Lista: " + numeros);
        List<Integer> numeroPares = numeros.stream().filter((n) -> n % 2 == 0).toList();
        System.out.println("Números pares: " + numeroPares);

        System.out.println("\n\t\tExercicio 02");
        System.out.println("Lista: " + numeros);
        int soma = numeros.stream().reduce(0, Integer::sum);
        System.out.println("Soma: " + soma);

        System.out.println("\n\t\tExercicio 03");
        var nomes = List.of("AA", "BBB", "CCCC", "DDDDD", "EEEEEE");
        List<String> tamanhoNomes = nomes.stream().map(x -> x +" - tamanho: " + x.length()).toList();
        System.out.println(tamanhoNomes);

        System.out.println("\n\t\tExercicio 04");
        System.out.println("Lista: " + numeros);
        List<Integer> numerosOrdenados = numeros.stream().sorted().toList();
        System.out.println("Números ordenados: " + numerosOrdenados);

        System.out.println("\n\t\tExercicio 05");
        List<PessoaEx5> pessoas = List.of(
                new PessoaEx5("Wesley", 18),
                new PessoaEx5("Faveron", 20),
                new PessoaEx5("Almeida", 25),
                new PessoaEx5("Jorge", 20),
                new PessoaEx5("Lucas", 25));
        List<String> somenteNomes = pessoas.stream().filter(x -> x.idade > 18).map(x -> x.nome).limit(3).toList();
        System.out.println(somenteNomes);
    }
}