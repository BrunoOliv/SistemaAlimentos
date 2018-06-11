package sistemaalimentos;
import java.util.List;

public class Cliente extends Fisica {

    public Cliente(BD bd) {
        super(bd);
    }
    
    public Cliente(BD bd, String nome, String dataNasc, String rg, String cpf, String usuario, String senha) {
        super(bd, nome, dataNasc, rg, cpf, usuario, senha);
    }
    
    @Override
    public void inserir () {
        System.out.println("Cadastro:");
        super.inserir();
        boolean salvo = bd.cliente.add(this);
        if(salvo){
            System.out.println("O cliente foi armazenado!");
        }else{
            System.out.println("O cliente não foi armazenado!");
        }
    }
    
    private void alterar () {
        System.out.println("Atualizacao:");
        super.inserir();
        System.out.println("Atualizado com sucesso!");
    }
    
    @Override
    public void atualizar () {
        System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Cliente cliente : bd.cliente) {
            if(nome.equalsIgnoreCase(cliente.nome)) {
                cliente.alterar();
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void consultar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Cliente cliente : bd.cliente) {
            if(nome.equalsIgnoreCase(cliente.nome)) {
                System.out.println(cliente.toString());
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void deletar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Cliente cliente : bd.cliente) {
            if(nome.equalsIgnoreCase(cliente.nome)) {
                bd.cliente.remove(cliente);
                System.out.println("Cliente removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void listar () {
        System.out.println("-- Lista de clientes --");
        System.out.println();
        for (Cliente cliente : bd.cliente) {
            System.out.println(cliente.toString());
        }
        System.out.println();
    }
}