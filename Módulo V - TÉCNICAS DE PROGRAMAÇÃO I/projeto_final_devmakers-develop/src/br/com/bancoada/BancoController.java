package br.com.bancoada;

import br.com.bancoada.domain.Conta;
import br.com.bancoada.domain.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BancoController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("## BEM-VINDO AO BANCO ADA ##");
            System.out.println("Escolha uma opção:");
            System.out.println();
            System.out.println("0. Sair");
            System.out.println("1. Listar contas");
            System.out.println("2. Criar nova conta");
            System.out.println("3. Detalhar conta por ID");
            System.out.println("4. Novo deposito");
            System.out.println("5. Novo saque");
            System.out.println("6. Obter todas as transacoes");
            System.out.println("7. Transacão por ID");
            System.out.println("8. Extrato");
            System.out.println();

            int escolha = scanner.nextInt();
            scanner.nextLine();

            executarOpcao(scanner, escolha);
        }
    }

    private static void executarOpcao(Scanner scanner, int choice) {
        switch (choice) {
            case 0:
                System.out.println("Obrigado!");
                System.exit(0);
                break;

            case 1:
                // todo: implemente o service com a lógica para buscar todas as contas do arquivo contas.txt
                List<Conta> contas = null;

                listarContasOpcao(contas);
                break;

            case 2:
                System.out.println();
                System.out.println("## CADASTRAR NOVA CONTA ##");
                System.out.println();

                System.out.print("Entre com o titular: ");
                String titular = scanner.nextLine();

                System.out.print("Entre com o cpf do titular: ");
                String cpf = scanner.nextLine();

                // todo: implemente o service para salvar uma nova conta no arquivo contas.txt e retorne o novo ID
                String novoId = "";

                System.out.printf("Nova conta adicionada. [id=%s]\n", novoId);
                break;

            case 3:
                System.out.println();
                System.out.println("## DETALHAR CONTA ##");
                System.out.println();

                System.out.print("entre com o ID da conta: ");
                String idInformado = scanner.nextLine();

                // todo: implemente a service da conta para verificar se essa conta existe e obte-la pelo idInformado,
                // caso não exista, mostre CONTA INEXISTENTE para o usuário
                Conta contaOpcao3 = null;

                // todo: em seguida implemente o service da transacao para obter o saldo baseado no arquivo <id>_transacoes.txt
                BigDecimal saldo = null;

                detalharContaMenu(contaOpcao3, saldo);
                break;

            case 4:
                System.out.println();
                System.out.println("## MENU EFETUAR TRANSACAO | DEPOSITO ##");

                System.out.print("entre com o ID da conta: ");
                String idContaNovoDeposito = scanner.nextLine();

                // todo: implemente a service da conta para verificar se essa conta existe e obte-la pelo idInformado,
                // caso não exista, mostre CONTA INEXISTENTE para o usuário
                Conta contaOpcao4 = null;


                System.out.print("Valor do deposito: ");
                var valorDeposito = new BigDecimal(scanner.nextLine());

                // todo: em seguida implemente o service da transacao para registrar uma nova transacao do tipo DEPOSITO no arquivo <id>_transacoes.txt
                // e retorne o id da nova transacao efetuada

                String idNovaTransacaoDeposito = null;

                System.out.println("Transacao efetivada: " + idNovaTransacaoDeposito);
                System.out.println();
                break;

            case 5:
                System.out.println();
                System.out.println("## EFETUAR TRANSACAO | SAQUE ##");
                System.out.println();

                System.out.print("entre com o ID da conta: ");
                String idContaNovoSaque = scanner.nextLine();

                // todo: implemente a service da conta para verificar se essa conta existe e obte-la pelo idInformado,
                // caso não exista, mostre CONTA INEXISTENTE para o usuário
                Conta contaOpcao5 = null;

                System.out.print("Valor do saque: ");
                var valorSaque = new BigDecimal(scanner.nextLine());

                // todo: em seguida implemente o service da transacao para registrar uma nova transacao do tipo DEPOSITO no arquivo <id>_transacoes.txt
                // e retorne o id da nova transacao efetuada
                String idNovaTransacaoSaque = null;

                System.out.println("Transacao efetivada: " + idNovaTransacaoSaque);
                System.out.println();
                break;

            case 6:
                System.out.println();
                System.out.println("## OBTER TODAS AS TRANSACOES POR CONTA ##");
                System.out.println();

                System.out.print("entre com o ID da conta: ");
                String idContaGetAllTransacoes = scanner.nextLine();

                // todo: implemente a service da conta para verificar se essa conta existe e obte-la pelo idInformado,
                // caso não exista, mostre CONTA INEXISTENTE para o usuário
                Conta contaOpcao6 = null;

                // todo: em seguida implemente o service da transacao para obter todas as transacoes do arquivo <id>_transacoes.txt
                // específico desse usuário

                List<Transacao> transacoes = null;

                listarTransacoesOpcao(transacoes);
                break;

            case 7:
                System.out.println();
                System.out.println("## TRANSACAO POR ID ##");
                System.out.println();

                System.out.print("entre com o ID da conta: ");
                String idContaGetTransacaoPorId = scanner.nextLine();

                // todo: implemente a service da conta para verificar se essa conta existe e obte-la pelo idInformado,
                // caso não exista, mostre CONTA INEXISTENTE para o usuário
                Conta contaOpcao7 = null;

                System.out.print("entre com o ID da transacao: ");
                String idTransacaoGetTransacaoPorId = scanner.nextLine();

                // todo: em seguida implemente o service da transacao para obter uma transacão por ID do arquivo <id>_transacoes.txt
                // específico desse usuário, caso a transação não exista retorne ao usuário a mensagem TRANSACAO INEXISTENTE!

                Transacao transacaoEncontrada = null;

                detalharTransacaoOpcao(transacaoEncontrada);
                break;
            case 8:
                System.out.println();
                System.out.println("## RELATORIOS ##");
                System.out.println();

                System.out.print("Informe o ID da conta: ");
                String idContaRelatorio = scanner.nextLine();

                // todo: implemente a service da conta para verificar se essa conta existe e obte-la pelo idInformado,
                // caso não exista, mostre CONTA INEXISTENTE para o usuário
                Conta contaOpcao8 = null;


                // todo: implemente o servico de transação de uma conta específica para passar para o método relatorioOpcao()
                relatorioOpcao(scanner, contaOpcao8);
                break;

            default:
                System.out.println("Opção inválida. Esolha novamente.");
        }
    }

    private static void listarContasOpcao(List<Conta> contas) {
        System.out.println("##");
        System.out.println("## TODAS AS CONTAS ##");
        System.out.println();
        for (Conta conta : contas) {
            var formatador = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
            var criacao = LocalDateTime.ofInstant(conta.dataCriacao(), ZoneId.systemDefault()).format(formatador);
            System.out.printf("%s | criado em=%s, id=%s\n", conta.titular().toUpperCase(), criacao, conta.id());
        }
        System.out.println();
        System.out.println("##");
    }

    private static void detalharContaMenu(Conta conta, BigDecimal saldo) {

        var formatador = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
        var criacao = LocalDateTime.ofInstant(conta.dataCriacao(), ZoneId.systemDefault()).format(formatador);

        System.out.println();
        System.out.println("## DETALHAR CONTA ##");
        System.out.printf("# ID: %s\n", conta.id());
        System.out.printf("# TITULAR: %s\n", conta.titular());
        System.out.printf("# SALDO: %.2f\n", saldo);
        System.out.printf("# CRIADO EM: %s\n", criacao);
        System.out.println();
    }

    private static void listarTransacoesOpcao(List<Transacao> transacoes) {
        System.out.println();
        System.out.println("## LISTAR TRANSACOES ##");
        System.out.println();

        transacoes.forEach(System.out::println);

        System.out.println();
    }

    private static void detalharTransacaoOpcao(Transacao transacaoEncontrada) {
        var formatadorDataTransacoes = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
        var criacaoTransacao = LocalDateTime.ofInstant(transacaoEncontrada.dataCriacao(), ZoneId.systemDefault()).format(formatadorDataTransacoes);

        System.out.println();
        System.out.println("## DETALHAR TRANSACAO ##");
        System.out.printf("# ID: %s\n", transacaoEncontrada.id());
        System.out.printf("# TIPO: %s\n", transacaoEncontrada.tipo());
        System.out.printf("# VALOR: %.2f\n", transacaoEncontrada.valor());
        System.out.printf("# CRIADO: %s\n", criacaoTransacao);
        System.out.println();
    }

    private static void relatorioOpcao(Scanner scanner, Conta conta) {
        System.out.println("Agora, informe informe o filtro conforme as opções abaixo:");
        System.out.println("0) Sem filtro");
        System.out.println("1) Mês atual");
        System.out.println("2) Ano atual");
        System.out.println("3) Ultimos 15 dias");
        System.out.println("4) Ultimos 30 dias");
        System.out.println("5) personalizado");
        String filtroPeriodo = scanner.nextLine();

        LocalDateTime filtroDe;
        LocalDateTime filtroAte = LocalDateTime.now();

        switch (filtroPeriodo) {
            case "1":
                filtroDe = null; // todo: implemente a lógica
                break;
            case "2":
                filtroDe = null; // todo: implemente a lógica
                break;
            case "3":
                filtroDe = null; // todo: implemente a lógica
                break;
            case "4":
                filtroDe = null; // todo: implemente a lógica
                break;
            case "5":
                // todo: implemente a lógica
                System.out.println("Personalizado: dd/MM/yy HH:mm");
                System.out.print("De: ");
                String filtroPeriodoPersonalizadoDe = scanner.nextLine();

                System.out.print("Ate: ");
                String filtroPeriodoPersonalizadoAte = scanner.nextLine();

                filtroDe = null;
                filtroAte = null;
                break;
            default:
                // devem ficar nulos
                filtroDe = null;
                filtroAte = null;
                break;
        }

        System.out.println("Gerando relatorio...");

        // todo: receba o serviço de transação por parametro deste método para invocar o gerarRelatorio() baseado nesses filtros
        System.out.println("Relatorio gerado com sucesso!!!");
    }
}
