package sistemaalimentos;

public class Fornecedor extends Juridica {
    
    public Fornecedor(BD bd) {
        super(bd);
    }
    
    public Fornecedor(BD bd, String nome, String usuario, String senha) {
        super(bd, nome, usuario, senha);
    }
    
    @Override
    public void inserir () {
        System.out.println("Cadastro:");
        super.inserir();
        boolean salvo = bd.fornecedor.add(this);
        if(salvo){
            System.out.println("O fornecedor foi armazenado!");
        }else{
            System.out.println("O fornecedor não foi armazenado!");
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
        for (Fornecedor fornecedor : bd.fornecedor) {
            if(nome.equalsIgnoreCase(fornecedor.nome)) {
                fornecedor.alterar();
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void consultar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Fornecedor fornecedor : bd.fornecedor) {
            if(nome.equalsIgnoreCase(fornecedor.nome)) {
                System.out.println(fornecedor.toString());
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void deletar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Fornecedor fornecedor : bd.fornecedor) {
            if(nome.equalsIgnoreCase(fornecedor.nome)) {
                bd.fornecedor.remove(fornecedor);
                System.out.println("Fornecedor removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void listar () {
        System.out.println("-- Lista de fornecedores--");
        System.out.println();
        for (Fornecedor fornecedor : bd.fornecedor) {
            System.out.println(fornecedor.toString());
        }
        System.out.println();
    }
}