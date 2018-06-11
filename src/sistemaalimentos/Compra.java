/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaalimentos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bruno Oliveira
 */
public class Compra {

    public static int i = 1;
    public int idCompra;
    public String nomeGerente;
    public List<ProdutoFornecedor> produtos;
    public PagamentoCompra pagamento;
    public String data;
    public float total;
    public BD bd;
    Scanner sc;

    private static int incremento() {
        return i++;
    }

    public Compra(BD bd) {
        this.bd = bd;
        this.produtos = new ArrayList<>();
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.data = formatador.format(data);
    }

    public String entrada() {
        this.sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public int entradaInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void inicializar() {
        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoFornecedor produtoFornecedor : bd.produtoFornecedor) {
            if (descricao.equalsIgnoreCase(produtoFornecedor.descricao)) {
                ProdutoFornecedor produto = new ProdutoFornecedor(bd);
                produto.descricao = produtoFornecedor.descricao;
                produto.preco = produtoFornecedor.preco;
                produto.nomeFornecedor = produtoFornecedor.nomeFornecedor;

                boolean confere = false;
                do {
                    System.out.print("Informe a quantidade do produto: ");
                    produto.quantidade = sc.nextInt();

                    if (produto.quantidade <= produtoFornecedor.quantidade && produto.quantidade > 0) {
                        produtoFornecedor.quantidade -= produto.quantidade;
                        confere = true;
                    } else {
                        System.out.println("Erro! Quantidade nao confere no estoque. Tente novamente.");
                    }
                } while (!confere);
                this.produtos.add(produto);
                return;
            }
        }
        System.out.println("Produto nao encontrado! Tente novamente.");
        this.inicializar();
    }

    public void inserir() {
        System.out.println("Inserir Compra:");

        inicializar();

        int escolha;
        do {
            System.out.print("Adicionar mais produto (1 - Sim ou 2 - Nao): ");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    this.inicializar();
                    break;
                case 2:
                    this.idCompra = incremento();
                    for (ProdutoFornecedor produto : this.produtos) {
                        this.total += produto.preco * produto.quantidade;
                    }
                    boolean salvo = bd.compra.add(this);
                    if (salvo) {
                        System.out.println("O produto foi armazenado na compra!");
                        System.out.println();
                    } else {
                        System.out.println("O produto não foi armazenado na compra!");
                    }
                    return;
                default:
                    System.out.print("Erro! Opcao invalida. Tente novamente.");
                    break;
            }
        } while (escolha <= 1 || escolha > 2);
    }

    public void consultar() {
        System.out.print("Informe o ID da Compra: ");
        int id = entradaInt();
        for (Compra compra : bd.compra) {
            if (id == compra.idCompra) {
                System.out.println(compra.toString());
                System.out.println("                           -- Itens --");
                for (ProdutoFornecedor produto : compra.produtos) {
                    System.out.println(produto.toString());
                }
                return;
            }
        }
        System.out.println("Compra nao encontrado!");
    }

    public void deletar() {
        System.out.print("Informe o ID da Compra: ");
        int id = entradaInt();
        for (Compra compra : bd.compra) {
            if (id == compra.idCompra) {
                if (compra.pagamento == null) {
                    for (ProdutoFornecedor produto : compra.produtos) {
                        for(ProdutoFornecedor produtoFornecedor : bd.produtoFornecedor){
                            if(produto.descricao.equalsIgnoreCase(produtoFornecedor.descricao) 
                                    && produto.nomeFornecedor.equalsIgnoreCase(produtoFornecedor.nomeFornecedor)){
                                produtoFornecedor.quantidade += produto.quantidade;
                            }
                        }
                    }
                    bd.compra.remove(compra);
                    System.out.println("Compra removida com sucesso!");
                } else {
                    System.out.println("Erro! Compra nao pode ser removida, pagamento ja realizado.");
                }
                return;
            }
        }
        System.out.println("Compra nao encontrado!");
    }

    public void listar() {
        System.out.println("-- Lista de compras --");
        System.out.println();
        for (Compra compra : bd.compra) {
            System.out.println(compra.toString());
            System.out.println("                           -- Itens --");
            for (ProdutoFornecedor produto : compra.produtos) {
                System.out.println(produto.toString());
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String descricaoPg;
        if(this.pagamento == null){
            descricaoPg = ", Pagamento: Pendente ";
        }else{
            descricaoPg = ", Pagamento: Efetuado (id: " + pagamento.idPagamento + ") ";
        }
        return "idCompra: " + this.idCompra + ", Nome Gerente: "
                + this.nomeGerente + ", Data: " + this.data
                + ", Total: " + this.total + descricaoPg;
    }
}
