package pt.mstavares.cliente;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String INSTRUCAO_DE_TERMINAR = "TERMINAR";

    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente(args[0], args[1], Integer.parseInt(args[2]));
        cliente.inicializar();
        lerDoTeclado(cliente);
    }

    private static void lerDoTeclado(Cliente cliente) throws IOException {
        Scanner leitor = new Scanner(System.in);
        System.out.println("O cliente foi inicializado");
        while (true) {
            String mensagem = leitor.nextLine();
            if(INSTRUCAO_DE_TERMINAR.equals(mensagem)) {
                cliente.terminar();
                break;
            } else {
                cliente.enviarMensagem(mensagem);
            }
        }
    }

}