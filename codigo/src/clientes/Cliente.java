package clientes;
import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

   
}