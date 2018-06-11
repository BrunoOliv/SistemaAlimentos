package sistemaalimentos;

import java.util.ArrayList;
import java.util.List;

public class BD {
	List<Cliente> cliente = new ArrayList<>();
	List<Vendedor> vendedor  = new ArrayList<>();
	List<Gerente> gerente = new ArrayList<>();
	List<Fornecedor> fornecedor = new ArrayList<>();
        List<ProdutoLoja> produtoLoja = new ArrayList<>();
        List<ProdutoFornecedor> produtoFornecedor = new ArrayList<>();
        List<Venda> venda = new ArrayList<>();
        List<Compra> compra = new ArrayList<>();
        List<PagamentoCompra> pagamentoCompra = new ArrayList<>();
        List<PagamentoVenda> pagamentoVenda = new ArrayList<>();
        List<Mensalidade> mensalidade = new ArrayList<>();
}