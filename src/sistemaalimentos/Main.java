package sistemaalimentos;

public class Main {

    public static void main(String[] Args) {
        BD bd = new BD();
        Opcao op = new Opcao(bd);
        Autenticacao aut = new Autenticacao();
        int escolhaPessoa;

        Cliente cl = new Cliente(bd, "BrunoCliente", "bruno", "123");
        bd.cliente.add(cl);

        Vendedor vd = new Vendedor(bd, "BrunoVendedor", "bruno2", "123");
        bd.vendedor.add(vd);

        Gerente gr = new Gerente(bd, "BrunoGerente", "bruno3", "123");
        bd.gerente.add(gr);

        Fornecedor fn = new Fornecedor(bd, "BrunoFornecedor", "bruno4", "123");
        bd.fornecedor.add(fn);

        /*
        ProdutoLoja produto1 = new ProdutoLoja(bd, 1, "Maca", 5, 10);
        produto1.inserir();
        ProdutoLoja produto2 = new ProdutoLoja(bd, 2, "Banana", 4, 20);
        produto2.inserir();
        ProdutoLoja produto3 = new ProdutoLoja(bd, 3, "Alface", 2, 15);
        produto3.inserir();
        produto3.listar();
        
        Venda venda1 = new Venda(bd, 1, "05-06-2018", 1, 2, 10);
        venda1.inserir();
        Venda venda2 = new Venda(bd, 2, "04-06-2018", 2, 2, 8);
        venda2.inserir();
        Venda venda3 = new Venda(bd, 3, "03-06-2018", 3, 2, 4);
        venda3.inserir();
        venda3.listar();
         */
        do {
            escolhaPessoa = op.escolherTipoPessoa();
           
            aut.logar(bd, escolhaPessoa);

            switch (escolhaPessoa) {
                case 1: {
                    op.escolherOpcaoCliente();
                    break;
                }
                case 2: {
                    op.escolherOpcaoVendedor();
                    break;
                }
                case 3: {
                    op.escolherOpcaoGerente();
                    break;
                }
                case 4: {
                    op.escolherOpcaoFornecedor();
                    break;
                }
            }
        } while (escolhaPessoa != 0);
    }
}
