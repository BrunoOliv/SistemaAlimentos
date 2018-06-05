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
public class Produto {
    public int idProduto, quantidade;
    public String descricao;
    public float preco;
    public BD bd;
    
    public Produto(BD bd, int idProduto, String descricao, float preco, int quantidade) {
        this.bd = bd;
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "idProduto: " + this.idProduto + ", Descricao: " + this.descricao + ", Preco: " 
                + this.preco + ", Quantidade: " + this.quantidade;
    }
}
