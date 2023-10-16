package clientes;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        XuBank xubank = new XuBank();

        Cliente cliente1 = new ClienteRegular("João", "123456789", "senha123");
        Cliente cliente2 = new ClienteVip("Maria", "987654321", "senha456");

        xubank.adicionarCliente(cliente1);
        xubank.adicionarCliente(cliente2);

        Conta conta1 = new ContaCorrente(cliente1);
        Conta conta2 = new ContaPoupanca(cliente1);
        Conta conta3 = new ContaRendaFixa(cliente2, 0.05);
        Conta conta4 = new ContaInvestimento(cliente2);

        cliente1.adicionarConta(conta1);
        cliente1.adicionarConta(conta2);
        cliente2.adicionarConta(conta3);
        cliente2.adicionarConta(conta4);

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar extrato");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Realizar saque");
            System.out.println("5. Transferência");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();

                    // Encontre a conta com base no número da conta
                    Conta contaSaldo = xubank.encontrarContaPorNumero(numeroConta);

                    if (contaSaldo != null) {
                        System.out.println("Saldo da conta: " + contaSaldo.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta2 = scanner.nextInt();

                    // Encontre a conta com base no número da conta
                    Conta contaExtrato = xubank.encontrarContaPorNumero(numeroConta2);

                    if (contaExtrato != null) {
                        String extrato = contaExtrato.consultaExtrato();
                        System.out.println("Extrato da conta: " + extrato);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta3 = scanner.nextInt();
                    System.out.println("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();

                    // Encontre a conta com base no número da conta
                    Conta contaDeposito = xubank.encontrarContaPorNumero(numeroConta3);

                    if (contaDeposito != null) {
                        contaDeposito.deposito(valorDeposito);
                        System.out.println("Depósito realizado com sucesso. Novo saldo: " + contaDeposito.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta4 = scanner.nextInt();
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();

                    // Encontre a conta com base no número da conta
                    Conta contaSaque = xubank.encontrarContaPorNumero(numeroConta4);

                    if (contaSaque != null) {
                        if (contaSaque.getSaldo() >= valorSaque) {
                            contaSaque.saque(valorSaque);
                            System.out.println("Saque realizado com sucesso. Novo saldo: " + contaSaque.getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente para o saque.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o número da conta de origem: ");
                    int origemConta = scanner.nextInt();
                    System.out.println("Digite o número da conta de destino: ");
                    int destinoConta = scanner.nextInt();
                    System.out.println("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();

                    // Encontre as contas de origem e destino com base nos números das contas
                    Conta contaOrigem = xubank.encontrarContaPorNumero(origemConta);
                    Conta contaDestino = xubank.encontrarContaPorNumero(destinoConta);

                    if (contaOrigem != null && contaDestino != null) {
                        if (contaOrigem.getSaldo() >= valorTransferencia) {
                            contaOrigem.transferencia(contaDestino, contaSaldo, valorTransferencia);
                            System.out.println("Transferência realizada com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente para a transferência.");
                        }
                    } else {
                        System.out.println("Conta de origem e/ou conta de destino não encontrada(s).");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do menu.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}