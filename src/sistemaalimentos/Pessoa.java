package sistemaalimentos;

import java.util.List;
import java.util.Scanner;

public class Pessoa {

    private int idPessoa;
    public String nome, dataNac, rg, cpf, usuario, senha;
    BD bd;
    
    public Pessoa(BD bd, String nome, String dataNasc, String rg, String cpf, String usuario, String senha) {
        this.bd = bd;
        this.nome = nome;
        this.dataNac = dataNasc;
        this.rg = rg;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Pessoa(BD bd) {
        this.bd = bd;
    }

    public String entrada() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void inserir() {
        System.out.println("Informe o Nome: ");
        this.nome = entrada();

        System.out.println("Informe a Data de Nascimento: ");
        this.dataNac = entrada();

        System.out.println("Informe o RG: ");
        this.rg = entrada();

        System.out.println("Informe o CPF: ");
        this.cpf = entrada();
        
        System.out.println("Informe o Usuário: ");
        this.usuario = entrada();
        
        System.out.println("Informe a Senha: ");
        this.senha = entrada();
    }

    public void atualizar() {
        
    }

    public void consultar() {

    }

    public void deletar() {

    }

    public void listar() {

    }
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Dt Nascimento: " + this.dataNac + ", RG: "
                + this.rg + ", CPF: " + this.cpf;
    }
}
