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
public class PagamentoCompra extends Pagamento {

    public static int i = 1;

    public PagamentoCompra(BD bd) {
        super(bd);
    }

    private static int incremento() {
        return i++;
    }

    @Override
    public void inserir() {
        System.out.print("Informe o ID da Compra: ");
        int id = entradaInt();
        for (Compra compra : bd.compra) {
            if (id == compra.idCompra) {
                this.idPagamento = incremento();
                System.out.println("Valor da Compra: R$" + compra.total);
                super.inserir();
                compra.pagamento = this;
                bd.pagamentoCompra.add(this);
                return;
            }
        }
        System.out.println("Compra nao encontrado!");
    }

    @Override
    public void consultar() {
        System.out.print("Informe o ID do Pagamento: ");
        int id = entradaInt();
        for (PagamentoCompra pagamentoCompra : bd.pagamentoCompra) {
            if (id == pagamentoCompra.idPagamento) {
                System.out.println(pagamentoCompra.toString());
                return;
            }
        }
        System.out.println("Pagamento nao encontrado!");
    }

    @Override
    public void listar() {
        System.out.println("Lista de Pagamentos: ");
        for (PagamentoCompra pagamentoCompra : bd.pagamentoCompra) {
            System.out.println(pagamentoCompra.toString());
        }
    }
}
