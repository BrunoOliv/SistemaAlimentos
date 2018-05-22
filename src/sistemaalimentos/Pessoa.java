package sistemaalimentos;

import java.util.List;
import java.util.Scanner;

public class Pessoa {

    private int idPessoa;
    public String nome, dataNac, rg, cpf, usuario, senha;
    BD bd;

    public Pessoa(BD bd) {
        this.bd = bd;
    }

    public String entrada() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void inserir() {
        System.out.println("Cadastro:");
        System.out.println("Informe o Nome: ");
        this.nome = entrada();

        System.out.println("Informe a Data de Nascimento: ");
        this.dataNac = entrada();

        System.out.println("Informe o RG: ");
        this.rg = entrada();

        System.out.println("Informe o CPF: ");
        this.cpf = entrada();
    }

    public void atualizar(int idPessoa) {

    }

    public void consultar() {

    }

    public void deletar(int idPessoa) {

    }

    public void listar() {

    }
}
