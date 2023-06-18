import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CadastroFuncionarios {
    private Set<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        this.funcionarios = new HashSet<>();
    }

    public void cadastrarFuncionario() {
        int codigo;
        while (true) {
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário:"));
            if (verificarCodigoUnico(codigo)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Código de funcionário já em uso. Digite um código único.");
            }
        }

        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
        String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário:"));

        Funcionario novoFuncionario = new Funcionario(codigo, nome, cargo, salario);
        funcionarios.add(novoFuncionario);

        int quantidadeDependentes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dependentes do funcionário:"));
        for (int i = 0; i < quantidadeDependentes; i++) {
            String nomeDependente = JOptionPane.showInputDialog("Digite o nome do dependente:");
            Dependente dependente = new Dependente(novoFuncionario, nomeDependente);
            novoFuncionario.adicionarDependente(dependente);
        }
    }

    private boolean verificarCodigoUnico(int codigo) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCodigo() == codigo) {
                return false;
            }
        }
        return true;
    }

    public void mostrarBonusMensal() {
        StringBuilder bonusMensal = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            String dadosFuncionario = funcionario.getDadosBonusMensal();
            bonusMensal.append(dadosFuncionario).append("\n");
        }

        JOptionPane.showMessageDialog(null, bonusMensal.toString());
        salvarDadosBonusMensalEmArquivo(bonusMensal.toString());
    }

    private void salvarDadosBonusMensalEmArquivo(String dados) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("folha_bonus_mensal.txt"));
            writer.write(dados);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados do bônus mensal em arquivo: " + e.getMessage());
        }
    }

    public void excluirFuncionario() {
        int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário a ser excluído:"));
        Funcionario funcionarioRemover = null;

        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getCodigo() == codigoFuncionario) {
                funcionarioRemover = funcionario;
                iterator.remove();
                break;
            }
        }

        if (funcionarioRemover != null) {
            for (Dependente dependente : funcionarioRemover.getDependentes()) {
                dependente.getFuncionario().removerDependente(dependente);
            }
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário Inexistente");
        }
    }

    public void alterarSalarioFuncionario() {
        int codigoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do funcionário para alterar o salário:"));
        double novoSalario = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo salário:"));
        Funcionario funcionarioAlterar = null;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCodigo() == codigoFuncionario) {
                funcionarioAlterar = funcionario;
                break;
            }
        }

        if (funcionarioAlterar != null) {
            funcionarioAlterar.setSalario(novoSalario);
            JOptionPane.showMessageDialog(null, "Salário alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário Inexistente");
        }
    }
}