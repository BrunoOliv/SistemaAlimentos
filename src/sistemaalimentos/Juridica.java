package sistemaalimentos;

public class Juridica extends Pessoa {
    public String cnpj, dataCriacao;
    
    public Juridica(BD bd) {
        super(bd);
    }
    
    public Juridica(BD bd, String nome, String usuario, String senha) {
        super(bd, nome, usuario, senha);
    }
}