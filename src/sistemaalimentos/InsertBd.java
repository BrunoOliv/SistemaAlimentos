/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaalimentos;

/**
 *
 * @author Bruno Oliveira
 */
public class InsertBd {
    public static void iniciar(BD bd){
        // ------------------------ Pessoas ---------------------------------
        Cliente cl = new Cliente(bd, "Bruno Oliveira", "20/07/1996", "278.041-1", "873.223.412.23", "BrunoCliente", "123");
        bd.cliente.add(cl);
        
        Cliente c2 = new Cliente(bd, "Lucas", "10/09/1997", "355.021-4", "343.233.422.35", "LucasCliente", "123");
        bd.cliente.add(c2);

        Vendedor vd = new Vendedor(bd, "BrunoVendedor", "20/07/1996", "278.041-1", "873.223.412.23", "BrunoVendedor", "123");
        bd.vendedor.add(vd);

        Gerente gr = new Gerente(bd, "BrunoGerente", "20/07/1996", "278.041-1", "873.223.412.23", "BrunoGerente", "123");
        bd.gerente.add(gr);

        Fornecedor fn = new Fornecedor(bd, "BrunoFornecedor", "20/07/1996", "278.041-1", "873.223.412.23", "BrunoFornecedor", "123");
        bd.fornecedor.add(fn);

        // ------------------------ Mensalidade -----------------------------
        Mensalidade mensalidade = new Mensalidade("Mensalidade de Junho", "05/06/2018", 100, true, c2);
        bd.mensalidade.add(mensalidade);
        
        // ------------------------ ProfutoLoja -----------------------------
        ProdutoLoja prod1 = new ProdutoLoja("Arroz", 12, 50);
        bd.produtoLoja.add(prod1);
        
        ProdutoLoja prod2 = new ProdutoLoja("Feijao", 5, 30);
        bd.produtoLoja.add(prod2);
        
        ProdutoLoja prod3 = new ProdutoLoja("Acucar", 8, 35);
        bd.produtoLoja.add(prod3);
        
        // ------------------------ ProfutoFornecedor -----------------------
        ProdutoFornecedor prod4 = new ProdutoFornecedor("Arroz", 10, 20, "BrunoFornecedor");
        bd.produtoFornecedor.add(prod4);
        
        ProdutoFornecedor prod5 = new ProdutoFornecedor("Feijao", 4, 25, "BrunoFornecedor");
        bd.produtoFornecedor.add(prod5);
        
        ProdutoFornecedor prod6 = new ProdutoFornecedor("Acucar", 7, 30, "BrunoFornecedor");
        bd.produtoFornecedor.add(prod6);
    }
}
