package clientes;

class ClienteVip extends Cliente {
    public ClienteVip(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }

    public double consultaSaldo(Conta conta) {
        return conta.getSaldo();
    }

    public String consultaExtrato(Conta conta) {
        return conta.consultaExtrato();
    }

    public void deposito(Conta conta, double valor) {
        conta.deposito(valor);
    }

    public void saque(Conta conta, double valor) {
        conta.saque(valor);
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