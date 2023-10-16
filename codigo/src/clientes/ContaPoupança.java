package clientes;

class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente, "Conta Poupança", numeroConta);
    }

    // Implementação de rendimento fixo de 0,5% no dia 5 de cada mês
    
    public void aplicarRendimentoMensal() {
        setSaldo(getSaldo() + getSaldo() * 0.005);
    }
}
