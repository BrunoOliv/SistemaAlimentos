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
public class Venda {
    int idVenda, idCliente, idVendedor, idProduto, idPagamento, quantidade;
    String data;
    float total;
    BD bd;
    
    public Venda(BD bd, int idCliente, String data, int idProduto, int quantidade ,float total) {
        this.bd = bd;
        this.idCliente = idCliente;
        this.data = data;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.total = total;
    }
    
    public void inserir () {
        bd.venda.add(this);
    }
    
    public void listar () {
        System.out.println("-- Lista de vendas --");
        System.out.println();
        for (Venda venda : bd.venda) {
            System.out.println(venda.toString());
        }
        System.out.println();
    }
    
    public String toString() {
        return "idCliente: " + this.idCliente + ", Data: " + this.data + ", idProduto: " +
                this.idProduto + ", quantidade: " + this.quantidade  + " Total: " + this.total;
    }
    
}
