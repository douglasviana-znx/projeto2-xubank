package clientes;

class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente, "Conta de Investimento", numeroConta);
    }

    // Implementação de rendimento diário (positivo ou negativo)
    public void aplicarRendimentoDiario(double taxaDiaria) {
        setSaldo(getSaldo() + getSaldo() * taxaDiaria);
    }
}
