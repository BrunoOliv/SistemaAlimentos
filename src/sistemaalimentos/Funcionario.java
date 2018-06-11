package sistemaalimentos;

public class Funcionario extends Fisica {
    
    public Funcionario(BD bd) {
        super(bd);
    }
    
    public Funcionario(BD bd, String nome, String dataNasc, String rg, String cpf, String usuario, String senha) {
        super(bd, nome, dataNasc, rg, cpf, usuario, senha);
    }
}