package sistemaalimentos;

public class Fisica extends Pessoa {
    
    public Fisica(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }
    
    public Fisica(BD bd) {
        super(bd);
    }
    
}