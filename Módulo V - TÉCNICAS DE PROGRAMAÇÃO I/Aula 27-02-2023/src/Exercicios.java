/*
    1. Dado uma data e hora específica em string, use a nova API de datas do Java para criar um objeto
    LocalDate, um LocalTime e um LocalDateTime e imprimí-los;

    2. A partir da data atual, calcule e imprima uma compra de R$ 64.000,00
    parcelado em 48x. Imprima o valor e a data de cada parcela usando a nova API de datas do Java.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exercicios {
    public static void main(String[] args) {

        System.out.println("\n\t\t EXERCÍCIO 01");
        String data1 = "2023-12-25";
        String data2 = "25/12/2023";
        String hora1 = "22:10";

        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate1 = LocalDate.parse(data1);
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.parse(data2, formatacao);
        System.out.println(localDate2);

        LocalTime localTime = LocalTime.parse(hora1);
        System.out.println(localTime);

        System.out.println("\n\t\t EXERCÍCIO 02");

        final String PRECO_TOTAL = "64000";
        final String NUM_PARCELAS = "48";
        LocalDate agora = LocalDate.now();

        BigDecimal valorTotal = new BigDecimal(PRECO_TOTAL).divide(BigDecimal.ONE, 2, RoundingMode.FLOOR);
        System.out.println("\nValor total a ser pago: R$ " + valorTotal);
        BigDecimal parcela = new BigDecimal(String.valueOf(valorTotal.divide(new BigDecimal(NUM_PARCELAS), 2, RoundingMode.FLOOR)));

        for (int i = 0; i < Integer.parseInt(NUM_PARCELAS); i++) {
            System.out.printf("\n%02d° Parcela de R$ " + parcela + " a ser paga dia: " + agora.format(formatacao), i+1);
            agora = agora.plusMonths(1);
        }
        System.out.println();
    }
}