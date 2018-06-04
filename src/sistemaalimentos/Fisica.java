package sistemaalimentos;

public class Fisica extends Pessoa {
    
    public Fisica(BD bd, String nome, String usuario, String senha) {
        super(bd, nome, usuario, senha);
    }
    
    public Fisica(BD bd) {
        super(bd);
    }
    
}