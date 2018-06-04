package sistemaalimentos;

import java.util.Scanner;

public class Opcao {

    int op;
    Scanner sc;

    public Opcao() {
        this.sc = new Scanner(System.in);
    }

    public void entrada() {
        System.out.print("Opcao: ");
        this.op = this.sc.nextInt();
    }

    public void visualizarTipoPessoa() {
        System.out.println("-- Menu Pessoa --");
        System.out.println("    1 - Cliente");
        System.out.println("    2 - Vendedor");
        System.out.println("    3 - Gerente");
        System.out.println("    4 - Fornecedor");
    }

    public void visualizarOpcao() {
        System.out.println(" --Menu Principal-- ");
        System.out.println("    1 - Inserir");
        System.out.println("    2 - Atualizar");
        System.out.println("    3 - Consultar");
        System.out.println("    4 - Deletar");
        System.out.println("    5 - listar");
        System.out.println("    0 - Sair");
    }

    public int escolherPessoa() {
        entrada();

        if (this.op <= 0 || this.op >= 5) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherPessoa();
        }
        return this.op;
    }

    public int escolherOpcao() {
        entrada();

        if (this.op < 0 || this.op >= 6) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcao();
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        return this.op;
    }

    public void tratarOpcao(Pessoa ps, int op) {
        switch (op) {
            case 1: {
                ps.inserir();
                break;
            }
            case 3: {
                ps.consultar();
                //ps.inserir();
                break;
            }
            case 5: {
                ps.listar();
                break;
            }
        }
    }
    
    public void tratarPessoa(int escolhaPessoa, int escolhaOpcao, BD bd) {
        switch (escolhaPessoa) {
                case 1: {
                    Cliente cliente = new Cliente(bd);
                    tratarOpcao(cliente, escolhaOpcao);
                    break;
                }
                case 2: {
                    Vendedor vendedor = new Vendedor(bd);
                    tratarOpcao(vendedor, escolhaOpcao);
                    break;
                }
                case 3: {
                    Gerente gerente = new Gerente(bd);
                    tratarOpcao(gerente, escolhaOpcao);
                    break;
                }
                default: {
                    Fornecedor fornecedor = new Fornecedor(bd);
                    tratarOpcao(fornecedor, escolhaOpcao);
                    break;
                }
            }
    }
}
