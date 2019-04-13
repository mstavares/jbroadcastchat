package pt.mstavares.comum;

import java.io.Serializable;
import java.util.Date;

public class Mensagem implements Serializable {

    private String remetente;
    private String conteudo;
    private Date date = new Date();

    public Mensagem(String remetente, String conteudo) {
        this.remetente = remetente;
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "[" + date.toString() + "] " + remetente + " diz: " + conteudo;
    }


}
