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

    public static int i = 1;
    int idMensalidade;
    String descricao;
    String data;
    float valor;
    boolean pagamento;
    Cliente cliente;
    BD bd;
    Scanner sc;

    private static int incremento() {
        return i++;
    }

    public Mensalidade(BD bd) {
        this.bd = bd;
    }

    public Mensalidade(String descricao, String data, float valor, boolean pagamento, Cliente cliente) {
        this.idMensalidade = incremento();
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.pagamento = pagamento;
        this.cliente = cliente;
    }

    public String entrada() {
        this.sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int entradaInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
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
        this.idMensalidade = incremento();
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
        System.out.print("Informe o ID da Mensalidade: ");
        int id = entradaInt();
        for (Mensalidade mensalidade : bd.mensalidade) {
            if (id == mensalidade.idMensalidade) {
                mensalidade.alterar();
                return;
            }
        }
        System.out.println("Mensalidade nao encontrado!");
    }

    public void consultar() {
        System.out.print("Informe o ID da Mensalidade: ");
        int id = entradaInt();
        for (Mensalidade mensalidade : bd.mensalidade) {
            if (id == mensalidade.idMensalidade) {
                System.out.println(mensalidade.toString());
                return;
            }
        }
        System.out.println("Mensalidade nao encontrado!");
    }

    public void deletar() {
        System.out.print("Informe o ID da Mensalidade: ");
        int id = entradaInt();
        for (Mensalidade mensalidade : bd.mensalidade) {
            if (id == mensalidade.idMensalidade) {
                if (!mensalidade.pagamento) {
                    bd.mensalidade.remove(mensalidade);
                    System.out.println("A mensalidade foi removida com sucesso!");
                } else {
                    System.out.println("A mensalidade nao pode ser removida! O pagamento da mesma ja foi efetuado.");
                }
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
        return "idMensalidade: " + this.idMensalidade + ", Descricao: " + this.descricao
                + ", Data: " + this.data + ", Valor: " + this.valor + ", Pagamento: "
                + this.pagamento + ", Cliente: " + this.cliente.nome;
    }
}
