/*
    2. A partir da data atual, calcule e imprima uma compra de R$ 64.000,00
    parcelado em 48x, imprima o valor e a data de cada parcela usando a nova API de datas do Java.
    Obs.: com uma nova regra;
    Caso a data do pagamento seja no final de semana, a data do pagamento deve ser postergada para
    a primeira segunda feira subsequente, porém sem alterar a data dos próximos pagamentos!

    3. A partir da sua data de nascimento, faça um programa que calcule as seguintes informações;
    a) Qual dia da semana era;
    b) Qual foi o dia da semana do primeiro dia daquele mês;
    c) Qual foi o dia da semana do primeiro dia daquele ano;
    d) Qual foi o dia da semana do último dia daquele mês;
    e) Qual foi o dia da semana do último dia daquele ano;
    f) Qual foi o dia da primeira sexta feira após aquela data;

    Monday — Segunda-feira
    Tuesday — Terça-feira
    Wednesday — Quarta-feira
    Thursday — Quinta-feira
    Friday — Sexta-feira
    Saturday — Sábado
    Sunday — Domingo
*/

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Exercicios {
    public static void main(String[] args) {
        System.out.println("\n\t\t EXERCÍCIO 02");
        final String PRECO_TOTAL = "64000";
        final String NUM_PARCELAS = "48";
        LocalDate agora = LocalDate.now();
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        BigDecimal valorTotal = new BigDecimal(PRECO_TOTAL).divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN);
        System.out.println("\nValor total a ser pago: R$ " + valorTotal);
        BigDecimal valorParcela = valorTotal.divide(new BigDecimal(NUM_PARCELAS), 2, RoundingMode.HALF_EVEN);

        for (int i = 0; i < Integer.parseInt(NUM_PARCELAS); i++) {
            LocalDate dataPagamento = agora.plusMonths(i);
            if (dataPagamento.getDayOfWeek() == DayOfWeek.SATURDAY || dataPagamento.getDayOfWeek() == DayOfWeek.SUNDAY) {
                dataPagamento = dataPagamento.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
            System.out.printf("\n%02d° Parcela de R$ " + valorParcela + " a ser paga dia: " + dataPagamento.format(formatacao), i + 1);
        }
        System.out.println();


        System.out.println("\n\t\t EXERCÍCIO 03");
        var dataNascimento = LocalDate.of(2023, 3, 3);
        System.out.println("Data inicial: " + dataNascimento);
        System.out.println("Dia da semana: " + dataNascimento.getDayOfWeek());

        DayOfWeek primeiroDiaDq = dataNascimento.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek();
        System.out.println("\nData: " + dataNascimento.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Dia da semana do primeiro dia do mês: " + primeiroDiaDq);

        DayOfWeek primeiroDiaAno = dataNascimento.with(TemporalAdjusters.firstDayOfYear()).getDayOfWeek();
        System.out.println("\nData: " + dataNascimento.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Dia da semana do primeiro dia do ano: " + primeiroDiaAno);

        DayOfWeek ultimoDiaMes = dataNascimento.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
        System.out.println("\nData: " + dataNascimento.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Dia da semana do ultimo dia do mês: " + ultimoDiaMes);

        DayOfWeek ultimoDiaAno = dataNascimento.with(TemporalAdjusters.lastDayOfYear()).getDayOfWeek();
        System.out.println("\nData: " + dataNascimento.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("Dia da semana do ultimo dia do ano: " + ultimoDiaAno);

        LocalDate proximaSexta = dataNascimento.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("\nProxima Sexta: " + proximaSexta);
    }
}
