package sistemaalimentos;

public class Main {

    public static void main(String[] Args) {
        BD bd = new BD();
        Opcao op = new Opcao();
        int escolhaPessoa, escolhaOpcao;

        Cliente cl = new Cliente(bd, "Bruno", "bruno", "123");
        bd.cliente.add(cl);

        Vendedor vd = new Vendedor(bd, "Bruno", "bruno2", "123");
        bd.vendedor.add(vd);

        Gerente gr = new Gerente(bd, "Bruno", "bruno3", "123");
        bd.gerente.add(gr);

        Fornecedor fn = new Fornecedor(bd, "Bruno", "bruno4", "123");
        bd.fornecedor.add(fn);

        do {
            op.visualizarTipoPessoa();
            escolhaPessoa = op.escolherPessoa();

            if (escolhaPessoa == 0) {
                return;
            }

            Autenticacao aut = new Autenticacao();
            aut.logar(bd, escolhaPessoa);

            do {
                op.visualizarOpcao();
                escolhaOpcao = op.escolherOpcao();
                op.tratarPessoa(escolhaPessoa, escolhaOpcao, bd);
            } while (escolhaOpcao != 0);
        } while (escolhaPessoa != 0);
    }
}
