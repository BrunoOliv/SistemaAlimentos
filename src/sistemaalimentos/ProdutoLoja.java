/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaalimentos;

/**
 *
 * @author Bruno
 */
public class ProdutoLoja extends Produto {
    public ProdutoLoja(BD bd, int idProduto, String descricao, float preco, int quantidade) {
        super(bd, idProduto, descricao, preco, quantidade);
    }
    
    public void inserir () {
        bd.produtoLoja.add(this);
    }
    
    public void listar () {
        System.out.println("-- Lista de produtos --");
        System.out.println();
        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
            System.out.println(produtoLoja.toString());
        }
        System.out.println();
    }
}
