package pt.mstavares.cliente;

import pt.mstavares.comum.Mensagem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

    private String remetente;
    private String enderecoServidor;
    private int porta;
    private boolean execucao;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Cliente(String remetente, String enderecoServidor, int porta) {
        this.remetente = remetente;
        this.enderecoServidor = enderecoServidor;
        this.porta = porta;
    }

    public void inicializar() throws IOException {
        execucao = true;
        Socket socket = new Socket(InetAddress.getByName(enderecoServidor), porta);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        receberMensagens();
    }

    public void terminar() {

    }

    public void enviarMensagem(String conteudo) throws IOException {
        Mensagem mensagemParaEnviar = new Mensagem(remetente, conteudo);
        out.writeObject(mensagemParaEnviar);
    }

    private void receberMensagens() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (execucao) {
                        Mensagem mensagemRecebida = (Mensagem) in.readObject();
                        System.out.println(mensagemRecebida);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
