public class Dependente {
    private Funcionario funcionario;
    private String nome;

    public Dependente(Funcionario funcionario, String nome) {
        this.funcionario = funcionario;
        this.nome = nome;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getNome() {
        return nome;
    }
}
