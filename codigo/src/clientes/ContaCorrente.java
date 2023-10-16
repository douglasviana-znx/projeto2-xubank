package clientes;

class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente, "Conta Corrente", numeroConta);
    }
}
