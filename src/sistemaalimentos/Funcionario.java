package sistemaalimentos;

public class Funcionario extends Fisica {
    
    public Funcionario(BD bd) {
        super(bd);
    }
    
    public Funcionario(BD bd, String nome, String usuario, String senha) {
        super(bd, nome, usuario, senha);
    }
}