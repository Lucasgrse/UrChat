/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lucas
 */
public class TrataCliente implements Runnable {

    private Socket sk_cliente;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private ArrayList<Mensagem> msgs;

    public TrataCliente(Socket soquete_cliente, ArrayList<Mensagem> mensagens) throws Exception {
        super();
        this.sk_cliente = soquete_cliente;
        this.saida = new ObjectOutputStream(this.sk_cliente.getOutputStream());
        this.entrada = new ObjectInputStream(this.sk_cliente.getInputStream());
        this.msgs = msgs;
    }

    public void enviar_mensagem(Object mensagem) throws Exception {
        DateFormat formato = new SimpleDateFormat("hh:mm:ss"); 
            this.saida.writeObject(mensagem);
    }
    public Object receber_mensagem() throws Exception {
        DateFormat formato = new SimpleDateFormat("hh:mm:ss"); 
        return this.entrada.readObject();
    }

    public void finalizar() throws IOException {
        this.sk_cliente.close();
    }

    @Override
    public void run() {
        try{
            Mensagem msg = (Mensagem)receber_mensagem();
            System.out.println(msg.toString());
            this.msgs.add(msg);
            enviar_mensagem(msg);
            finalizar();           
    }   catch (Exception ex) {
        ex.printStackTrace(); //Mostra o rastro do erro
            System.out.println("Houve um erro ao enviar uma mensagem! Verifique sua conexão e tente novamente.");
            Logger.getLogger(TrataCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
