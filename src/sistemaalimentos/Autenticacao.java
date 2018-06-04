package sistemaalimentos;

import java.util.Scanner;

public class Autenticacao {

    String user, pass;

    public String entrada() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void logar(BD bd, int escolhaPessoa) {
        System.out.println();
        System.out.println("-- Autenticacao --");
        System.out.print("Informe o usuario: ");
        this.user = entrada();
        System.out.print("Informe a senha: ");
        this.pass = entrada();

        switch (escolhaPessoa) {
            case 1: {
                for (Cliente cliente : bd.cliente) {
                    if (user.equalsIgnoreCase(cliente.usuario) && pass.equalsIgnoreCase(cliente.senha)) {
                        System.out.println("Logado com sucesso!");
                        return;
                    }
                }
                System.out.println("Usuario ou senha invalida!");
                logar(bd, escolhaPessoa);
                break;
            }
            case 2: {
                
                break;
            }
            case 3: {
                
                break;
            }
            default: {
                
                break;
            }
        }
        
        /*if ("bruno".equalsIgnoreCase(this.user) && "123456".equalsIgnoreCase(this.pass)) {
            System.out.println("Usuario logado com sucesso");
        } else {
            System.out.println("Usuario não logado! Tente novamente.");
            logar();
        }*/
    }
}
