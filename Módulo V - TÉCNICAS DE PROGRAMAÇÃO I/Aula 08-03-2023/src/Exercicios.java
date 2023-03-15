/*
    Obs.: utilizar stream de primitivos quando necessário
    1. Dado uma lista de inteiros, encontre a soma de todos os numeros da lista;
    2. Dado uma lista de pessoas, agrupe os nomes por idade;
    3. Dado uma lista de funcionarios, calcule a média de salário por departamento;
    4. Dado uma lista de transações, encontre o total de transações por cliente;
        Transacao: jorge, 10
        Transacao: maria, 20
        Transacao: jorge, 5

        resultado: Map -> jorge=2, maria=1
    5. Dado uma lista de livros, encontre o autor mais popular baseado na quantidade de livros vendidos;
    6. Dado uma lista de numeros, encontre o segundo maior número;
    7. Dado um texto, retorne um mapa com a frequencia de cada palavra;
    --> feliz dia das mulheres para vocês mulheres da turma
    feliz=1, dia=1, das=1, mulheres=2, para=1, vocês=1, da=1, turma=1
 */

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercicios {
    public static void main(String[] args) {
        System.out.println("\n\t\tExercicio 01");
        IntStream streamListaInteiros = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Soma: " + streamListaInteiros.sum());

        System.out.println("\n\t\tExercicio 02");
        List<PessoaEx2> pessoas = List.of(
                new PessoaEx2("AAA", 5),
                new PessoaEx2("BBB", 5),
                new PessoaEx2("CCC", 10),
                new PessoaEx2("DDD", 15),
                new PessoaEx2("EEE", 10),
                new PessoaEx2("FFF", 5));
        Map<Integer, List<PessoaEx2>> agrupaPessoas = pessoas
                .stream()
                .collect(Collectors.groupingBy(PessoaEx2::idade));
        System.out.println("Agrupamento de pessoas:\n" + agrupaPessoas);

        Map<Integer, String> agrupaNomesPessoas = pessoas
                .stream()
                .collect(Collectors.toMap(
                        PessoaEx2::idade,
                        PessoaEx2::nome,
                        (a, b) -> a + "; " + b)
                );
        System.out.println("Agrupamento de nomes de pessoas:\n" + agrupaNomesPessoas);

        System.out.println("\n\t\tExercicio 03");
        List<Funcionario> funcionarios = List.of(
                new Funcionario("Joao", Funcionario.Departamento.RECURSO_HUMANO, new BigDecimal("1350.0")),
                new Funcionario("Maria", Funcionario.Departamento.RECURSO_HUMANO, new BigDecimal("1200.0")),
                new Funcionario("Caio", Funcionario.Departamento.LIMPEZA, new BigDecimal("1100.0")),
                new Funcionario("Bruno", Funcionario.Departamento.LIMPEZA, new BigDecimal("1150.0")),
                new Funcionario("Joana", Funcionario.Departamento.ENGENHARIA, new BigDecimal("2000.0")),
                new Funcionario("Icaro", Funcionario.Departamento.ENGENHARIA, new BigDecimal("1800.0")),
                new Funcionario("Ivana", Funcionario.Departamento.ENGENHARIA, new BigDecimal("2200.0")));

        Map<Funcionario.Departamento, Double> collect = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::departamento,
                        Collectors.averagingDouble(funcionario -> funcionario.salario().doubleValue())));
        System.out.println("Media por departamento: " + collect);

        System.out.println("\n\t\tExercicio 04");

        List<Transacao> transacoes = List.of(
                new Transacao("felipe", 4),
                new Transacao("laura", 7),
                new Transacao("felipe", 10),
                new Transacao("laura", 7),
                new Transacao("laura", 7),
                new Transacao("laura", 7),
                new Transacao("laura", 7),
                new Transacao("robertinho", 20)
        );

        Map<String, Integer> novaLista = transacoes.stream()
                .collect(Collectors.toMap(
                        Transacao::nomePessoa,
                        transacao -> 1,
                        (x, y) -> ++x)
                );
        System.out.println("Nova lista: " + novaLista);

        System.out.println("\n\t\tExercicio 05");
        List<Livro> lirvos = List.of(
                new Livro("AAA", "dsa", 10),
                new Livro("AAA", "ewq", 5),
                new Livro("BBB", "hgf", 1),
                new Livro("BBB", "trerte", 50),
                new Livro("CCC", "dsa", 100)
        );

        Map<String, Integer> vendasPorAutores = lirvos.stream()
                .collect(Collectors.groupingBy(Livro::autor,
                        Collectors.summingInt(livro -> livro.qtdVendida())));
        System.out.println("Autores e suas vendas:\n" + vendasPorAutores);
        System.out.println("Autor com mais vendas: " + Collections.max(vendasPorAutores.entrySet(), Map.Entry.comparingByValue()).getKey());

        System.out.println("\n\t\tExercicio 06");
        List<Integer> inteiros = Arrays.asList(1, 10, 2, 9, 3, 8, 4, 7, 5, 6);
        int segundoMaior = inteiros.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .max(Integer::compare)
                .get();
        System.out.println("Lista: " + inteiros);
        System.out.println("O segundo maior valor é: " + segundoMaior);

        System.out.println("\n\t\tExercicio 07");
        String texto = """
                feliz dia das mulheres para vocês mulheres da turma
                """;
        List<String> textoSeparadoPorEspaco = Arrays.stream(texto.split(" ")).toList();
        Map<String, Long> textoMapeado = textoSeparadoPorEspaco.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
        System.out.println(textoMapeado);
    }
}

record PessoaEx2(String nome, int idade) {
}

record Funcionario(String nome, Departamento departamento, BigDecimal salario) {
    public enum Departamento {
        LIMPEZA, RECURSO_HUMANO, ENGENHARIA
    }
}

record Transacao(String nomePessoa, Integer qtd) {
}

record Livro(String autor, String nomeLivro, int qtdVendida) {
}
