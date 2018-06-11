package sistemaalimentos;

import java.util.Scanner;

public class Opcao {

    int op, escolhaOpcaoCrud, escolhaPessoa;
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

    public int escolherOpcaoCrudPagamento() {
        System.out.println(" -- Menu CRUD / Listar -- ");
        System.out.println("    1 - Inserir");
        System.out.println("    2 - Consultar");
        System.out.println("    3 - Listar");
        System.out.println("    0 - Voltar");
        entrada();

        if (this.op < 0 || this.op >= 4) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoCrud();
        }
        incrementarLinhas();
        return this.op;
    }

    public void escolherOpcaoGerente(String nome) {
        System.out.println(" -- Menu Gerente -- ");
        System.out.println("    1 - CRUD/Listar Pessoa");
        System.out.println("    2 - CRUD/Listar ProdutoLoja");
        System.out.println("    3 - CRUD/Listar Mensalidade");
        System.out.println("    4 - CRUD/Listar Compra");
        System.out.println("    5 - Listar ProdutoFornecedor");
        System.out.println("    6 - Inserir Pagamento de Compra (Fornecedor)");
        System.out.println("    7 - Consultar Pagamento de Compra (Fornecedor)");
        System.out.println("    8 - Listar Pagamento de Compra (Fornecedor)");
        System.out.println("    0 - Sair");
        this.entrada();

        if (this.op < 0 || this.op >= 9) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoGerente(nome);
        }
        incrementarLinhas();

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
                do {
                    Compra compra = new Compra(bd);
                    compra.nomeGerente = nome;
                    escolhaOpcaoCrud = escolherOpcaoCrud();
                    tratarOpcaoCrudCompra(compra, escolhaOpcaoCrud);
                } while (escolhaOpcaoCrud != 0);
                break;
            }
            case 5: {
                ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(bd);
                tratarOpcaoCrudProduto(produtoFornecedor, 5);
                break;
            }
            case 6: {
                PagamentoCompra pagamentoCompra = new PagamentoCompra(bd);
                tratarOpcaoCrudPagamento(pagamentoCompra, 1);
                break;
            }
            case 7: {
                PagamentoCompra pagamentoCompra = new PagamentoCompra(bd);
                tratarOpcaoCrudPagamento(pagamentoCompra, 2);
                break;
            }
            case 8: {
                PagamentoCompra pagamentoCompra = new PagamentoCompra(bd);
                tratarOpcaoCrudPagamento(pagamentoCompra, 3);
                break;
            }
            default: {
                System.out.println("Deslogado com sucesso!");
                return;
            }
        }
        this.escolherOpcaoGerente(nome);
    }

    public void escolherOpcaoVendedor(String nome) {
        System.out.println(" -- Menu Vendedor -- ");
        System.out.println("    1 - CRUD/Listar Venda");
        System.out.println("    2 - Listar ProdutoLoja");
        System.out.println("    3 - Inserir Pagamento de Venda (Cliente)");
        System.out.println("    4 - Consultar Pagamento de Venda (Cliente)");
        System.out.println("    5 - Listar Pagamento de Venda (Cliente)");
        System.out.println("    6 - Relacao dos clientes em debito");
        System.out.println("    0 - Sair");
        entrada();

        if (this.op < 0 || this.op >= 7) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoVendedor(nome);
        }
        incrementarLinhas();

        switch (op) {
            case 1: {
                do {
                    Venda venda = new Venda(bd);
                    venda.nomeVendedor = nome;
                    escolhaOpcaoCrud = escolherOpcaoCrud();
                    tratarOpcaoCrudVenda(venda, escolhaOpcaoCrud);
                } while (escolhaOpcaoCrud != 0);
            }
            case 2: {
                ProdutoLoja produtoLoja = new ProdutoLoja(bd);
                tratarOpcaoCrudProduto(produtoLoja, 5);
                break;
            }
            case 3: {
                PagamentoVenda pagamentoVenda = new PagamentoVenda(bd);
                tratarOpcaoCrudPagamento(pagamentoVenda, 1);
                break;
            }
            case 4: {
                PagamentoVenda pagamentoVenda = new PagamentoVenda(bd);
                tratarOpcaoCrudPagamento(pagamentoVenda, 2);
                break;
            }
            case 5: {
                PagamentoVenda pagamentoVenda = new PagamentoVenda(bd);
                tratarOpcaoCrudPagamento(pagamentoVenda, 3);
                break;
            }
            case 6: {
                Venda venda = new Venda(bd);
                venda.listarDebito();
                break;
            }
            default: {
                System.out.println("Deslogado com sucesso!");
                return;
            }
        }
        this.escolherOpcaoVendedor(nome);
    }

    public void escolherOpcaoFornecedor(String nome) {
        System.out.println(" -- Menu Fornecedor -- ");
        System.out.println("    1 - CRUD/Listar ProdutoFornecedor");
        System.out.println("    2 - Listar VendaFornecedor");
        System.out.println("    0 - Sair");
        entrada();

        if (this.op < 0 || this.op >= 3) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoFornecedor(nome);
        }
        incrementarLinhas();

        switch (op) {
            case 1: {
                do {
                    ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor(bd);
                    produtoFornecedor.nomeFornecedor = nome;
                    escolhaOpcaoCrud = escolherOpcaoCrud();
                    tratarOpcaoCrudProduto(produtoFornecedor, escolhaOpcaoCrud);
                } while (escolhaOpcaoCrud != 0);
                break;
            }
            case 2: {
                Compra compra = new Compra(bd);
                tratarOpcaoCrudCompra(compra, 5);
                break;
            }
            default: {
                System.out.println("Deslogado com sucesso!");
                return;
            }
        }
        this.escolherOpcaoFornecedor(nome);
    }

    public void escolherOpcaoCliente(String nome) {
        System.out.println(" -- Menu Cliente -- ");
        System.out.println("    1 - Inserir Compra");
        System.out.println("    2 - Listar ProdutoLoja");
        System.out.println("    3 - Listar Compra");
        System.out.println("    0 - Sair");
        entrada();

        if (this.op < 0 || this.op >= 4) {
            System.out.println("Opcao invalida! Tente novamente.");
            this.escolherOpcaoCliente(nome);
        }
        incrementarLinhas();

        switch (op) {
            case 1: {
                Venda venda = new Venda(bd);
                venda.nomeCliente = nome;
                tratarOpcaoCrudVenda(venda, 1);
                break;
            }
            case 2: {
                ProdutoLoja produtoLoja = new ProdutoLoja(bd);
                tratarOpcaoCrudProduto(produtoLoja, 5);
                break;
            }
            case 3: {
                Venda venda = new Venda(bd);
                tratarOpcaoCrudVenda(venda, 5);
                break;
            }
            default: {
                System.out.println("Deslogado com sucesso!");
                return;
            }
        }
        this.escolherOpcaoCliente(nome);
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

    private void tratarOpcaoCrudCompra(Compra compra, int op) {
        switch (op) {
            case 1: {
                compra.inserir();
                break;
            }

            case 2: {
                System.out.println("Opcao nao permitida!");
                break;
            }

            case 3: {
                compra.consultar();
                break;
            }

            case 4: {
                compra.deletar();
                break;
            }

            case 5: {
                compra.listar();
                break;
            }
        }
    }

    private void tratarOpcaoCrudVenda(Venda venda, int op) {
        switch (op) {
            case 1: {
                venda.inserir();
                break;
            }

            case 2: {
                System.out.println("Opcao nao permitida!");
                break;
            }

            case 3: {
                venda.consultar();
                break;
            }

            case 4: {
                venda.deletar();
                break;
            }

            case 5: {
                venda.listar();
                break;
            }
        }
    }

    private void tratarOpcaoCrudPagamento(Pagamento pagamento, int op) {
        switch (op) {
            case 1: {
                pagamento.inserir();
                break;
            }

            case 2: {
                pagamento.consultar();
                break;
            }

            case 3: {
                pagamento.listar();
                break;
            }
        }
    }
}
