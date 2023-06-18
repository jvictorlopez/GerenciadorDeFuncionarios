import javax.swing.JOptionPane;


class Main {
   public static void main(String[] args) {
        CadastroFuncionarios cadastro = new CadastroFuncionarios();

        while (true) {
            String opcao = JOptionPane.showInputDialog("Digite a opção desejada:\n" +
                    "1. Cadastrar funcionário\n" +
                    "2. Mostrar bônus mensal de cada funcionário\n" +
                    "3. Excluir funcionário\n" +
                    "4. Alterar salário de um funcionário\n" +
                    "5. Sair");

            if (opcao.equals("1")) {
                cadastro.cadastrarFuncionario();
            } else if (opcao.equals("2")) {
                cadastro.mostrarBonusMensal();
            } else if (opcao.equals("3")) {
                cadastro.excluirFuncionario();
            } else if (opcao.equals("4")) {
                cadastro.alterarSalarioFuncionario();
            } else if (opcao.equals("5")) {
                break;
            }
        }
   }
}