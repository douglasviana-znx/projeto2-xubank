package clientes;

class ContaRendaFixa extends Conta {
    private double taxaDeRendimento;
    private double rendimento;

    public ContaRendaFixa(Cliente cliente, double taxaDeRendimento) {
        super(cliente, "Conta de Renda Fixa", numeroConta);
        this.taxaDeRendimento = taxaDeRendimento;
        this.rendimento = 0;
    }

    public void aplicarRendimento() {
        rendimento = getSaldo() * taxaDeRendimento;
        setSaldo(getSaldo() + rendimento);
    }

    public double getRendimento() {
        return rendimento;
    }
}
