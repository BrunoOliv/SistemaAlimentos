/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaalimentos;

import java.util.Scanner;

/**
 *
 * @author Bruno Oliveira
 */
public class Pagamento {
    int idPagamento;
    String data;
    float valorPg;
    Scanner sc;
    BD bd;
    
    public Pagamento(BD bd) {
        this.bd = bd;
    }
    
    public String entrada() {
        this.sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int entradaInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public float entradaFloat() {
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }

    public void inserir() {
        System.out.println("Informe o valor pago: ");
        this.valorPg = entradaFloat();
        System.out.println("Informe a data do pagamento: ");
        this.data = entrada();
    }

    public void consultar() {

    }

    public void listar() {

    }
    
    public String toString() {
        return "idPagamento: " + this.idPagamento + ", Data: "
                + this.data + ", Valor pago: " + this.valorPg;
    }
}
