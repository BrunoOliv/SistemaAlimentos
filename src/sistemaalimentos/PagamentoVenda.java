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
public class PagamentoVenda extends Pagamento {

    public static int i = 1;

    public PagamentoVenda(BD bd) {
        super(bd);
    }

    private static int incremento() {
        return i++;
    }

    @Override
    public void inserir() {
        System.out.print("Informe o ID da Venda: ");
        int id = entradaInt();
        for (Venda venda : bd.venda) {
            if (id == venda.idVenda) {
                this.idPagamento = incremento();
                System.out.println("Valor da Venda: R$" + venda.total);
                super.inserir();
                venda.pagamento = this;
                bd.pagamentoVenda.add(this);
                return;
            }
        }
        System.out.println("Venda nao encontrado!");
    }

    @Override
    public void consultar() {
        System.out.print("Informe o ID do Pagamento: ");
        int id = entradaInt();
        for (PagamentoVenda pagamentoVenda : bd.pagamentoVenda) {
            if (id == pagamentoVenda.idPagamento) {
                System.out.println(pagamentoVenda.toString());
                return;
            }
        }
        System.out.println("Pagamento nao encontrado!");
    }

    @Override
    public void listar() {
        System.out.println("Lista de Pagamentos: ");
        for (PagamentoVenda pagamentoVenda : bd.pagamentoVenda) {
            System.out.println(pagamentoVenda.toString());
        }
    }
}
