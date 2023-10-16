package clientes;

import java.util.ArrayList;
import java.util.List;

class XuBank {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente autenticarCliente(String cpf, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null;
    }

    public Conta encontrarContaPorNumero(int numeroConta) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumeroConta() == numeroConta) {
                    return conta;
                }
            }
        }
        return null;
    }

    
    
}
