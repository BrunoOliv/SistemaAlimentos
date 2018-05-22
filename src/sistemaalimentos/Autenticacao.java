package sistemaalimentos;
import java.util.Scanner;

public class Autenticacao {
    String user, pass;
    
    public String entrada() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public void logar() {
        System.out.println();
        System.out.println("-- Autenticacao --");
        System.out.print("Informe o usuario: ");
        this.user = entrada();
        System.out.print("Informe a senha: ");
        this.pass = entrada();
        if ("bruno".equalsIgnoreCase(this.user) && "123456".equalsIgnoreCase(this.pass)) {
            System.out.println("Usuario logado com sucesso");
        }else{
            System.out.println("Usuario não logado! Tente novamente.");
            logar();
        }
    }
}
