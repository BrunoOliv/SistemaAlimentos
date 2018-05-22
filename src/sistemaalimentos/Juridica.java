package sistemaalimentos;

public class Juridica extends Pessoa {
    public String cnpj, dataCriacao;
    
    public Juridica(BD bd) {
        super(bd);
    }
}