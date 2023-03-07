/*
    1. Escreva um método utilizando Predicate que recebe um número e verifica se é par;

    2. Escreva um método utilizando Function que receba um número e retorne o dobro daquele número;

    3. Escreva um método utilizando Consumer para imprimir elementos de uma lista;

    4. Escreva um método utilizando Supplier para retornar uma data com o LocalDate.now();
 */

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CorrecaoAula3 {

    public static void main(String[] args) {

        System.out.println("\n\t\tExercicio 01");
        int num = 8;
        Predicate<Integer> par = (numero) -> numero % 2 == 0;
        if (par.test(num)) {
            System.out.println(num + " é par");
        } else {
            System.out.println(num + " é ímpar");
        }

        System.out.println("\n\t\tExercicio 02");
        double numero = 5.7;
        System.out.println(dobroNumero(numero, (x) -> x * 2));

        Function<Double, Double> dobrador = (y) -> y*2;
        System.out.println(dobrador.apply(numero));

        System.out.println("\n\t\tExercicio 03");
        var numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> print = System.out::println;
        numeros.forEach(print);

        System.out.println("\n\t\tExercicio 04");
        var dataAtual = pegarDataHoje(() -> LocalDate.now());
        System.out.println(dataAtual);

    }

    private static double dobroNumero(double numero, Function<Double, Double> map) {
        double numeroDobrado = map.apply(numero);
        return numeroDobrado;
    }

    public static LocalDate pegarDataHoje(Supplier<LocalDate> suplier) {
        return suplier.get();
    }
}