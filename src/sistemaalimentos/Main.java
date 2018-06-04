package sistemaalimentos;

public class Main {
    
    public static void main(String[] Args) {
        BD bd = new BD();
        Opcao op = new Opcao();
        int escolhaPessoa, escolhaOpcao;
        
        Cliente cl = new Cliente("Bruno", "bruno", "123");
        
        bd.cliente.add(cl);

        op.visualizarTipoPessoa();
        escolhaPessoa = op.escolherPessoa();
        
        Autenticacao aut = new Autenticacao();
        aut.logar(bd, escolhaPessoa);
        
        do {
            op.visualizarOpcao();
            escolhaOpcao = op.escolherOpcao();
            op.tratarPessoa(escolhaPessoa, escolhaOpcao, bd);
        } while (escolhaOpcao != 0);
    }
}
