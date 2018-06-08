package sistemaalimentos;

import java.util.Scanner;

public class Opcao {

    int op;
    Scanner sc;
    BD bd;

    public Opcao(BD bd) {
        this.sc = new Scanner(System.in);
        this.bd = bd;
    }

    private void incrementarLinhas() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void entrada() {
        System.out.print("Opcao: ");
        this.op = this.sc.nextInt();
    }

    public int escolherTipoPessoa() {
        System.out.println("-- Menu Pessoa --");
        System.out.println("    1 - Cliente");
        System.out.println("    2 - Vendedor");
        System.out.println("    3 - Gerente");
        System.out.println("    4 - Fornecedor");
        entrada();

        if (this.op <= 0 || this.op >= 5) {
            System.out.println("Opcao invalida! Tente novamente.");
            System.out.println();
            this.escolherTipoPessoa();
        }
        return this.op;
    }

    public int escolherOpcaoCrud() {
        System.out.println(" -- Menu CRUD / Listar -- ");
        System.out.println("    1 - Inserir");
        System.out.println("    2 - Atualizar");
        System.out.println("    3 - Consultar");
        System.out.println("    4 - Deletar");
        System.out.println("    5 - Listar");
        System.out.println("    0 - Voltar");
        entrada();

        if (this.op < 0 || this.op >= 6) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoCrud();
        }
        incrementarLinhas();
        return this.op;
    }

    public void escolherOpcaoGerente() {
        System.out.println(" -- Menu Gerente -- ");
        System.out.println("    1 - CRUD/Listar Pessoa");
        System.out.println("    2 - CRUD/Listar ProdutoLoja");
        System.out.println("    3 - CRUD/Listar Mensalidade");
        System.out.println("    4 - CRUD/Listar Compra");
        System.out.println("    5 - Inserir Pagamento de Compra (Fornecedor)");
        System.out.println("    6 - Consultar Pagamento de Compra (Fornecedor)");
        System.out.println("    7 - Listar Pagamento de Compra (Fornecedor)");
        System.out.println("    0 - Sair");
        this.entrada();

        if (this.op < 0 || this.op >= 8) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoGerente();
        }
        incrementarLinhas();
        
        int escolhaOpcaoCrud;
        int escolhaPessoa;
        switch (op) {
            case 1: {
                escolhaPessoa = escolherTipoPessoa();
                do {
                    escolhaOpcaoCrud = escolherOpcaoCrud();
                    tratarPessoa(escolhaPessoa, escolhaOpcaoCrud);
                } while (escolhaOpcaoCrud != 0);
                break;
            }
            case 2: {
                do {
                    ProdutoLoja produtoLoja = new ProdutoLoja(bd);
                    escolhaOpcaoCrud = escolherOpcaoCrud();
                    tratarOpcaoCrudProduto(produtoLoja, escolhaOpcaoCrud);
                } while (escolhaOpcaoCrud != 0);
                break;
            }
            case 3: {
                do {
                    Mensalidade mensalidade = new Mensalidade(bd);
                    escolhaOpcaoCrud = escolherOpcaoCrud();
                    tratarOpcaoCrudMensalidade(mensalidade, escolhaOpcaoCrud);
                } while (escolhaOpcaoCrud != 0);
                break;
            }
            case 4: {

                break;
            }
            case 5: {

                break;
            }
            case 6: {

                break;
            }
            case 7: {

                break;
            }
            default: {
                System.out.println("Deslogado com sucesso!");
                return;
            }
        }
        this.escolherOpcaoGerente();
    }

    public int escolherOpcaoVendedor() {
        System.out.println(" -- Menu Vendedor -- ");
        System.out.println("    1 - CRUD/Listar Venda");
        System.out.println("    2 - Listar ProdutoLoja");
        System.out.println("    3 - Inseir Pagamento de Venda (Cliente)");
        System.out.println("    4 - Consultar Pagamento de Venda (Cliente)");
        System.out.println("    5 - Listar Pagamento de Venda (Cliente)");
        System.out.println("    6 - Listar Debito de Pagamento de Venda (Cliente)");
        entrada();

        if (this.op <= 0 || this.op >= 7) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoVendedor();
        }
        incrementarLinhas();
        return this.op;
    }

    public int escolherOpcaoFornecedor() {
        System.out.println(" -- Menu Fornecedor -- ");
        System.out.println("    1 - CRUD/Listar ProdutoFornecedor");
        System.out.println("    2 - Listar VendaFornecedor");
        entrada();

        if (this.op <= 0 || this.op >= 3) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoFornecedor();
        }
        incrementarLinhas();
        return this.op;
    }

    public int escolherOpcaoCliente() {
        System.out.println(" -- Menu Cliente -- ");
        System.out.println("    1 - Inserir Compra");
        System.out.println("    2 - Listar Compra");
        entrada();

        if (this.op <= 0 || this.op >= 3) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoCliente();
        }
        incrementarLinhas();
        return this.op;
    }

    public void tratarOpcaoCrud(Pessoa ps, int op) {
        switch (op) {
            case 1: {
                ps.inserir();
                break;
            }

            case 2: {
                ps.atualizar();
                break;
            }

            case 3: {
                ps.consultar();
                break;
            }

            case 4: {
                ps.deletar();
                break;
            }

            case 5: {
                ps.listar();
                break;
            }
        }
    }

    public void tratarPessoa(int escolhaPessoa, int escolhaOpcao) {
        switch (escolhaPessoa) {
            case 1: {
                Cliente cliente = new Cliente(bd);
                tratarOpcaoCrud(cliente, escolhaOpcao);
                break;
            }
            case 2: {
                Vendedor vendedor = new Vendedor(bd);
                tratarOpcaoCrud(vendedor, escolhaOpcao);
                break;
            }
            case 3: {
                Gerente gerente = new Gerente(bd);
                tratarOpcaoCrud(gerente, escolhaOpcao);
                break;
            }
            default: {
                Fornecedor fornecedor = new Fornecedor(bd);
                tratarOpcaoCrud(fornecedor, escolhaOpcao);
                break;
            }
        }
    }
    
    public void tratarOpcaoCrudProduto(Produto produto, int op) {
        switch (op) {
            case 1: {
                produto.inserir();
                break;
            }

            case 2: {
                produto.atualizar();
                break;
            }

            case 3: {
                produto.consultar();
                break;
            }

            case 4: {
                produto.deletar();
                break;
            }

            case 5: {
                produto.listar();
                break;
            }
        }
    }

    private void tratarOpcaoCrudMensalidade(Mensalidade mensalidade, int op) {
        switch (op) {
            case 1: {
                mensalidade.inserir();
                break;
            }

            case 2: {
                mensalidade.atualizar();
                break;
            }

            case 3: {
                mensalidade.consultar();
                break;
            }

            case 4: {
                mensalidade.deletar();
                break;
            }

            case 5: {
                mensalidade.listar();
                break;
            }
        }
    }
}
