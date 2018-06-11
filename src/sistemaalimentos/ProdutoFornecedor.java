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
public class ProdutoFornecedor extends Produto {
    
    String nomeFornecedor;
    
    public ProdutoFornecedor(BD bd) {
        super(bd);
    }
    
    public ProdutoFornecedor(String descricao, float preco, int quantidade, String nomeFornecedor) {
        super(descricao, preco, quantidade);
        this.nomeFornecedor = nomeFornecedor;
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

        boolean salvo = bd.produtoFornecedor.add(this);
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
        for (ProdutoFornecedor produtoFornecedor : bd.produtoFornecedor) {
            if (descricao.equalsIgnoreCase(produtoFornecedor.descricao)) {
                produtoFornecedor.alterar();
                return;
            }
        }
        System.out.println("Produto nao encontrado!");
    }

    @Override
    public void consultar() {
        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoFornecedor produtoFornecedor : bd.produtoFornecedor) {
            if (descricao.equalsIgnoreCase(produtoFornecedor.descricao)) {
                System.out.println(produtoFornecedor.toString());
                return;
            }
        }
        System.out.println("Produto nao encontrado!");
    }

    @Override
    public void deletar() {
        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoFornecedor produtoFornecedor : bd.produtoFornecedor) {
            if (descricao.equalsIgnoreCase(produtoFornecedor.descricao)) {
                bd.produtoFornecedor.remove(produtoFornecedor);
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
        for (ProdutoFornecedor produtoFornecedor : bd.produtoFornecedor) {
            System.out.println(produtoFornecedor.toString());
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return "Descricao: " + this.descricao + ", Preco: " 
                + this.preco + ", Quantidade: " + this.quantidade 
                + ", Fornecedor: " + this.nomeFornecedor;
    }
}
