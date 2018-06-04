package sistemaalimentos;

public class Vendedor extends Funcionario {
    
    public Vendedor(BD bd) {
        super(bd);
    }
    
    public Vendedor(BD bd, String nome, String usuario, String senha) {
        super(bd, nome, usuario, senha);
    }
    
    @Override
    public void inserir () {
        System.out.println("Cadastro:");
        super.inserir();
        boolean salvo = bd.vendedor.add(this);
        if(salvo){
            System.out.println("O vendedor foi armazenado!");
        }else{
            System.out.println("O vendedor não foi armazenado!");
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
        for (Vendedor vendedor : bd.vendedor) {
            if(nome.equalsIgnoreCase(vendedor.nome)) {
                vendedor.alterar();
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void consultar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Vendedor vendedor : bd.vendedor) {
            if(nome.equalsIgnoreCase(vendedor.nome)) {
                System.out.println(vendedor.toString());
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void deletar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Vendedor vendedor : bd.vendedor) {
            if(nome.equalsIgnoreCase(vendedor.nome)) {
                bd.vendedor.remove(vendedor);
                System.out.println("Vendedor removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void listar () {
        System.out.println("-- Lista de vendedores --");
        System.out.println();
        for (Vendedor vendedor : bd.vendedor) {
            System.out.println(vendedor.toString());
        }
        System.out.println();
    }
}