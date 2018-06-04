package sistemaalimentos;

public class Gerente extends Funcionario {

    public Gerente(BD bd) {
        super(bd);
    }
    
    public Gerente(BD bd, String nome, String usuario, String senha) {
        super(bd, nome, usuario, senha);
    }
    
    @Override
    public void inserir () {
        System.out.println("Cadastro:");
        super.inserir();
        boolean salvo = bd.gerente.add(this);
        if(salvo){
            System.out.println("O gerente foi armazenado!");
        }else{
            System.out.println("O gerente não foi armazenado!");
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
        for (Gerente gerente : bd.gerente) {
            if(nome.equalsIgnoreCase(gerente.nome)) {
                gerente.alterar();
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void consultar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Gerente gerente : bd.gerente) {
            if(nome.equalsIgnoreCase(gerente.nome)) {
                System.out.println(gerente.toString());
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void deletar () {
	System.out.print("Informe o nome: ");
        String nome = entrada();
        for (Gerente gerente : bd.gerente) {
            if(nome.equalsIgnoreCase(gerente.nome)) {
                bd.gerente.remove(gerente);
                System.out.println("Gerente removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }
    
    @Override
    public void listar () {
        System.out.println("-- Lista de gerentes --");
        System.out.println();
        for (Gerente gerente : bd.gerente) {
            System.out.println(gerente.toString());
        }
        System.out.println();
    }
}