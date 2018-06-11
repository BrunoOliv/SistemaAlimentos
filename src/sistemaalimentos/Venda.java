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
 * @author Bruno
 */
public class Venda {

    public static int i = 1;
    public int idVenda;
    public String nomeVendedor;
    public String nomeCliente;
    public List<ProdutoLoja> produtos;
    public PagamentoVenda pagamento;
    public String data;
    public float total;
    public BD bd;
    Scanner sc;

    private static int incremento() {
        return i++;
    }

    public Venda(BD bd) {
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
        boolean verifica = false;
        do {
            if (this.nomeCliente == null) {
                System.out.print("Informe o nome do cliente: ");
                String nome = entrada();
                for (Cliente cliente : bd.cliente) {
                    if (nome.equalsIgnoreCase(cliente.nome)) {
                        this.nomeCliente = cliente.nome;
                        verifica = true;
                    }
                }
                if (verifica == false) {
                    System.out.println("Cliente nao encontrado! Tente novamente.");
                }
            } else {
                verifica = true;
            }
        } while (!verifica);

        System.out.print("Informe a descricao do produto: ");
        String descricao = entrada();
        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
            if (descricao.equalsIgnoreCase(produtoLoja.descricao)) {
                ProdutoLoja produto = new ProdutoLoja(bd);
                produto.descricao = produtoLoja.descricao;
                produto.preco = produtoLoja.preco;

                boolean confere = false;
                do {
                    System.out.print("Informe a quantidade do produto: ");
                    produto.quantidade = sc.nextInt();

                    if (produto.quantidade <= produtoLoja.quantidade && produto.quantidade > 0) {
                        produtoLoja.quantidade -= produto.quantidade;
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
        System.out.println("Inserir Venda:");

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
                    this.idVenda = incremento();
                    for (ProdutoLoja produto : this.produtos) {
                        this.total += produto.preco * produto.quantidade;
                    }
                    boolean salvo = bd.venda.add(this);
                    if (salvo) {
                        System.out.println("O produto foi armazenado na venda!");
                        System.out.println();
                    } else {
                        System.out.println("O produto não foi armazenado na venda!");
                    }
                    return;
                default:
                    System.out.print("Erro! Opcao invalida. Tente novamente.");
                    break;
            }
        } while (escolha <= 1 || escolha > 2);
    }

    public void consultar() {
        System.out.print("Informe o ID da Venda: ");
        int id = entradaInt();
        for (Venda venda : bd.venda) {
            if (id == venda.idVenda) {
                System.out.println(venda.toString());
                System.out.println("                           -- Itens --");
                for (ProdutoLoja produto : venda.produtos) {
                    System.out.println(produto.toString());
                }
                return;
            }
        }
        System.out.println("Venda nao encontrado!");
    }

    public void deletar() {
        System.out.print("Informe o ID da Venda: ");
        int id = entradaInt();
        for (Venda venda : bd.venda) {
            if (id == venda.idVenda) {
                if (venda.pagamento == null) {
                    for (ProdutoLoja produto : venda.produtos) {
                        for (ProdutoLoja produtoLoja : bd.produtoLoja) {
                            if (produto.descricao.equalsIgnoreCase(produtoLoja.descricao)) {
                                produtoLoja.quantidade += produto.quantidade;
                            }
                        }
                    }
                    bd.venda.remove(venda);
                    System.out.println("Venda removida com sucesso!");
                } else {
                    System.out.println("Erro! Venda nao pode ser removida, pagamento ja realizado.");
                }
                return;
            }
        }
        System.out.println("Venda nao encontrado!");
    }

    public void listar() {
        System.out.println("-- Lista de vendas --");
        System.out.println();
        for (Venda venda : bd.venda) {
            System.out.println(venda.toString());
            System.out.println("                           -- Itens --");
            for (ProdutoLoja produto : venda.produtos) {
                System.out.println(produto.toString());
            }
            System.out.println();
        }
    }

    public void listarDebito() {
        System.out.println("-- Relacao dos clientes em debito --");
        System.out.println();
        for (Venda venda : bd.venda) {
            if (venda.pagamento == null) {
                System.out.println(venda.nomeCliente);
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String descricaoPg;
        if (this.pagamento == null) {
            descricaoPg = ", Pagamento: Pendente ";
        } else {
            descricaoPg = ", Pagamento: Efetuado (id: " + pagamento.idPagamento + ") ";
        }
        String nomeVd;
        if (this.nomeVendedor == null) {
            nomeVd = ", Venda: Online ";
        } else {
            nomeVd = ", Nome Vendedor: " + nomeVendedor + " ";
        }
        return "idVenda: " + this.idVenda + ", Nome Cliente: "
                + this.nomeCliente + nomeVd + ", Data: " + this.data
                + ", Total: " + this.total + descricaoPg;
    }
}
