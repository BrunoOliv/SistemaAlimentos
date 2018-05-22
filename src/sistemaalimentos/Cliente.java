package sistemaalimentos;
import java.util.List;

public class Cliente extends Fisica {

    public Cliente(BD bd) {
        super(bd);
    }
    
    @Override
    public void inserir () {
        super.inserir();
        boolean salvo = bd.cliente.add(this);
        if(salvo){
            System.out.println("O cliente foi armazenado!");
        }else{
            System.out.println("O cliente não doi armazenado!");
        }
    }
    
    @Override
    public void consultar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Cliente cliente : bd.cliente) {
            if(nome.equalsIgnoreCase(cliente.nome)) {
                System.out.println("Nome: " + cliente.nome);
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void listar () {
        for (Cliente cliente : bd.cliente) {
            System.out.println("Nome: " + cliente.nome);
            System.out.println();	
        }
    }
}