package sistemaalimentos;

public class Fisica extends Pessoa {

    public Fisica(BD bd) {
        super(bd);
    }

    public Fisica(BD bd, String nome, String dataNasc, String rg, String cpf, String usuario, String senha) {
        super(bd, nome, dataNasc, rg, cpf, usuario, senha);
    }
}
