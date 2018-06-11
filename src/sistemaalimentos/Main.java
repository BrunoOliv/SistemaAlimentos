package sistemaalimentos;

public class Main {

    public static void main(String[] Args) {
        BD bd = new BD();
        Opcao op = new Opcao(bd);
        Autenticacao aut = new Autenticacao();
        int escolhaPessoa;

        InsertBd.iniciar(bd);
        
        do {
            escolhaPessoa = op.escolherTipoPessoa();
           
            aut.logar(bd, escolhaPessoa);

            switch (escolhaPessoa) {
                case 1: {
                    op.escolherOpcaoCliente(aut.nome);
                    break;
                }
                case 2: {
                    op.escolherOpcaoVendedor(aut.nome);
                    break;
                }
                case 3: {
                    op.escolherOpcaoGerente(aut.nome);
                    break;
                }
                case 4: {
                    op.escolherOpcaoFornecedor(aut.nome);
                    break;
                }
            }
        } while (escolhaPessoa != 0);
    }
}
