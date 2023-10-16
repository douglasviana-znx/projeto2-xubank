package clientes;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Cliente cliente;
    private String tipo;
    private double saldo;
    public static int numeroConta; 
    private List<String> extrato = new ArrayList<>();

    public Conta(Cliente cliente, String tipo, int numeroConta) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.setSaldo(0);
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getNumeroConta() {
        return numeroConta;
    }

    public void deposito(double valor) {
        setSaldo(getSaldo() + valor);
        extrato.add("Depósito: +" + valor); // Adiciona transação ao extrato
    }

    public void saque(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            extrato.add("Saque: -" + valor); // Adiciona transação ao extrato
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public String consultaExtrato() {
        // Retorna uma representação simples do extrato
        StringBuilder sb = new StringBuilder();
        sb.append("Extrato da conta ").append(numeroConta).append(" - Tipo: ").append(tipo).append("\n");
        for (String transacao : extrato) {
            sb.append(transacao).append("\n");
        }
        return sb.toString();
    }

    public String getTipo() {
        return tipo;
    }

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void transferencia(Conta origem, Conta destino, double valor) {
	    if (origem == null || destino == null) {
	        System.out.println("Conta de origem ou destino inválida.");
	        return;
	    }

	    if (origem.getSaldo() < valor) {
	        System.out.println("Saldo insuficiente na conta de origem.");
	        return;
	    }

	    origem.saque(valor);
	    destino.deposito(valor);
	    System.out.println("Transferência de " + valor + " realizada com sucesso de " + origem.getTipo() + " para " + destino.getTipo());
	}
}