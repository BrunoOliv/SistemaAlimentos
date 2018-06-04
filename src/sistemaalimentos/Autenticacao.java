package sistemaalimentos;

import java.util.Scanner;

public class Autenticacao {

    String user, pass;

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
                        System.out.println("Logado com sucesso!");
                        System.out.println();
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
