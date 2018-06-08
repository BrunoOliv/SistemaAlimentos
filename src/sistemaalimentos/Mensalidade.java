/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaalimentos;

import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Mensalidade {

    int idMensalidade;
    String descricao;
    String data;
    float valor;
    boolean pagamento;
    Cliente cliente;
    BD bd;
    Scanner sc;
    
    public Mensalidade(BD bd){
        this.bd = bd;
    }
    
    public String entrada() {
        this.sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void inicializar() {
        boolean encontrado = false;
        System.out.println("Informe a descricao: ");
        this.descricao = entrada();
        System.out.println("Informe a data: ");
        this.data = entrada();
        System.out.println("Informe o valor: ");
        this.valor = sc.nextFloat();
        System.out.println("Informe TRUE ou FALSE p/ o pagamento: ");
        this.pagamento = sc.nextBoolean();

        do {
            System.out.println("Informe o nome do cliente: ");
            String nome = entrada();

            for (Cliente cliente : bd.cliente) {
                if (nome.equalsIgnoreCase(cliente.nome)) {
                    this.cliente = cliente;
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Usuario nao encontrado! Tente novamente.");
            }
        } while (!encontrado);
    }

    public void inserir() {
        System.out.println("Inserir Mensalidade:");

        inicializar();

        boolean salvo = bd.mensalidade.add(this);
        if (salvo) {
            System.out.println("A mensalidade foi armazenada!");
        } else {
            System.out.println("A mensalidade não foi armazenada!");
        }
    }

    private void alterar() {
        System.out.println("Atualizar Mensalidade:");
        inicializar();
        System.out.println("Atualizado com sucesso!");
    }

    public void atualizar() {
        System.out.print("Informe a descricao da mensalidade: ");
        String descricao = entrada();
        for (Mensalidade mensalidade : bd.mensalidade) {
            if (descricao.equalsIgnoreCase(mensalidade.descricao)) {
                mensalidade.alterar();
                return;
            }
        }
        System.out.println("Mensalidade nao encontrado!");
    }

    public void consultar() {
        System.out.print("Informe a descricao da mensalidade: ");
        String descricao = entrada();
        for (Mensalidade mensalidade : bd.mensalidade) {
            if (descricao.equalsIgnoreCase(mensalidade.descricao)) {
                System.out.println(mensalidade.toString());
                return;
            }
        }
        System.out.println("Mensalidade nao encontrado!");
    }

    public void deletar() {
        System.out.print("Informe a descricao da mensalidade: ");
        String descricao = entrada();
        for (Mensalidade mensalidade : bd.mensalidade) {
            if (descricao.equalsIgnoreCase(mensalidade.descricao)) {
                bd.mensalidade.remove(mensalidade);
                System.out.println("Mensalidade removida com sucesso!");
                return;
            }
        }
        System.out.println("Mensalidade nao encontrado!");
    }

    public void listar() {
        System.out.println("-- Lista de mensalidades --");
        System.out.println();
        for (Mensalidade mensalidade : bd.mensalidade) {
            System.out.println(mensalidade.toString());
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return "Descricao: " + this.descricao + ", Data: " + this.data
                + ", Valor: " + this.valor + ", Pagamento: " + this.pagamento
                + ", Cliente: " + this.cliente.nome;
    }
}
