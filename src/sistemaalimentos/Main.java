package sistemaalimentos;

public class Main {

    public static void main(String[] Args) {
        BD bd = new BD();
        Opcao op = new Opcao();
        int escolhaPessoa, escolhaOpcao;

        op.visualizarTipoPessoa();
        escolhaPessoa = op.escolherPessoa();
        
        Autenticacao aut = new Autenticacao();
        aut.logar();
        do {
        op.visualizarOpcao();
        escolhaOpcao = op.escolherOpcao();
        
            switch (escolhaPessoa) {
                case 1: {
                    Cliente cliente = new Cliente(bd);
                    op.tratarOpcao(cliente, escolhaOpcao);
                    break;
                }
                case 2: {
                    Vendedor vendedor = new Vendedor(bd);
                    op.tratarOpcao(vendedor, escolhaOpcao);
                    break;
                }
                case 3: {
                    Gerente gerente = new Gerente(bd);
                    op.tratarOpcao(gerente, escolhaOpcao);
                    break;
                }
                default: {
                    Fornecedor fornecedor = new Fornecedor(bd);
                    op.tratarOpcao(fornecedor, escolhaOpcao);
                    break;
                }
            }
        } while (escolhaOpcao != 0);
    }
}
