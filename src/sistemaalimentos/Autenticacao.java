package sistemaalimentos;

import java.util.Scanner;

public class Autenticacao {

    String user, pass, nome;

    public String entrada() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void logar(BD bd, int escolhaPessoa) {
        System.out.println();
        System.out.println("-- Autenticacao --");
        System.out.print("Informe o usuario: ");
        this.user = entrada();
        System.out.print("Informe a senha: ");
        this.pass = entrada();

        switch (escolhaPessoa) {
            case 1: {
                for (Cliente cliente : bd.cliente) {
                    if (user.equalsIgnoreCase(cliente.usuario) && pass.equalsIgnoreCase(cliente.senha)) {
                        for (Mensalidade mensalidade : bd.mensalidade) {
                            if (cliente.nome.equalsIgnoreCase(mensalidade.cliente.nome) 
                                    && mensalidade.pagamento == true 
                                    && mensalidade.data.equalsIgnoreCase("05/06/2018") ) {
                                System.out.println("Logado com sucesso!");
                                System.out.println();
                                this.nome = cliente.nome;
                                return;
                            }
                        }
                        System.out.println("Permissao negada! Mensalidade pendente.");
                        logar(bd, escolhaPessoa);
                        return;
                    }
                }
                System.out.println("Usuario ou senha invalida!");
                System.out.println();
                logar(bd, escolhaPessoa);
                break;
            }
            case 2: {
                for (Vendedor vendedor : bd.vendedor) {
                    if (user.equalsIgnoreCase(vendedor.usuario) && pass.equalsIgnoreCase(vendedor.senha)) {
                        System.out.println("Logado com sucesso!");
                        System.out.println();
                        this.nome = vendedor.nome;
                        return;
                    }
                }
                System.out.println("Usuario ou senha invalida!");
                System.out.println();
                logar(bd, escolhaPessoa);
                break;
            }
            case 3: {
                for (Gerente gerente : bd.gerente) {
                    if (user.equalsIgnoreCase(gerente.usuario) && pass.equalsIgnoreCase(gerente.senha)) {
                        System.out.println("Logado com sucesso!");
                        System.out.println();
                        this.nome = gerente.nome;
                        return;
                    }
                }
                System.out.println("Usuario ou senha invalida!");
                System.out.println();
                logar(bd, escolhaPessoa);
                break;
            }
            default: {
                for (Fornecedor fornecedor : bd.fornecedor) {
                    if (user.equalsIgnoreCase(fornecedor.usuario) && pass.equalsIgnoreCase(fornecedor.senha)) {
                        System.out.println("Logado com sucesso!");
                        System.out.println();
                        this.nome = fornecedor.nome;
                        return;
                    }
                }
                System.out.println("Usuario ou senha invalida!");
                System.out.println();
                logar(bd, escolhaPessoa);
                break;
            }
        }
    }
}
