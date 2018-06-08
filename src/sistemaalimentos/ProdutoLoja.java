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
public class ProdutoLoja extends Produto {

    public ProdutoLoja(BD bd) {
        super(bd);
    }
    
    public ProdutoLoja(BD bd, int idProduto, String descricao, float preco, int quantidade) {
        super(bd, idProduto, descricao, preco, quantidade);
    }

    private void inicializar() {
        System.out.println("Informe a descricao: ");
        this.descricao = entrada();
        System.out.println("Informe o preco: ");
        this.preco = sc.nextFloat();
        System.out.println("Informe a quantidade: ");
        this.quantidade = sc.nextInt();
    }

    @Override
    public void inserir() {
        System.out.println("Cadastro de Produto:");

        inicializar();

        boolean salvo = bd.produtoLoja.add(this);
        if (salvo) {
            System.out.println("O produto foi armazenada!");
            System.out.println();
        } else {
            System.out.println("O produto não foi armazenada!");
        }
    }

    private void alterar() {
        System.out.println("Atualizar Produto:");
        inicializar();
        System.out.println("Atualizado com sucesso!");
    }

    @Override
    public void atualizar() {
        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
            if (descricao.equalsIgnoreCase(produtoLoja.descricao)) {
                produtoLoja.alterar();
                return;
            }
        }
        System.out.println("Produto nao encontrado!");
    }

    @Override
    public void consultar() {
        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
            if (descricao.equalsIgnoreCase(produtoLoja.descricao)) {
                System.out.println(produtoLoja.toString());
                return;
            }
        }
        System.out.println("Produto nao encontrado!");
    }

    @Override
    public void deletar() {
        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
            if (descricao.equalsIgnoreCase(produtoLoja.descricao)) {
                bd.produtoLoja.remove(produtoLoja);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto nao encontrado!");
    }

    @Override
    public void listar() {
        System.out.println("-- Lista de produtos --");
        System.out.println();
        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
            System.out.println(produtoLoja.toString());
        }
        System.out.println();
    }
}
