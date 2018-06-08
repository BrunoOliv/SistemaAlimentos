/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaalimentos;
import java.util.Scanner;
/**
 *
 * @author Bruno
 */
public class Produto {
    public int idProduto, quantidade;
    public String descricao;
    public float preco;
    public BD bd;
    Scanner sc;
    
    public Produto(BD bd) {
        this.bd = bd;
    }
    
    public Produto(BD bd, int idProduto, String descricao, float preco, int quantidade) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public String entrada() {
        this.sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public void inserir() {
        
    }

    public void atualizar() {
        
    }

    public void consultar() {

    }

    public void deletar() {

    }

    public void listar() {

    }
    
    @Override
    public String toString() {
        return "Descricao: " + this.descricao + ", Preco: " 
                + this.preco + ", Quantidade: " + this.quantidade;
    }
}
