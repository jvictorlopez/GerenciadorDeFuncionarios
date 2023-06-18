import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int codigo;
    private String nome;
    private String cargo;
    private double salario;
    private List<Dependente> dependentes;

    public Funcionario(int codigo, String nome, String cargo, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dependentes = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void adicionarDependente(Dependente dependente) {
        dependentes.add(dependente);
    }

    public void removerDependente(Dependente dependente) {
        dependentes.remove(dependente);
    }

    public String getDadosBonusMensal() {
        int quantidadeDependentes = dependentes.size();
        double bonus = salario * (quantidadeDependentes * 0.02);

        StringBuilder dados = new StringBuilder();
        dados.append("Funcionário: ").append(nome)
                .append(", Dependentes: ").append(quantidadeDependentes)
                .append(", Bônus: ").append(bonus);

        return dados.toString();
    }
}