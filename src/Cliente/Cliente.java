/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Cliente {
    private Socket socket;
    private ObjectOutputStream entrada;
    private ObjectInputStream saida;
    private ArrayList<Mensagem> msgs;
    
    public Cliente(String endereco, int door) throws Exception {
        super();
        this.socket = new Socket(endereco, door);
        this.entrada = new ObjectOutputStream(this.socket.getOutputStream());
        this.saida = new ObjectInputStream(this.socket.getInputStream());
        
    }
    public void enviarMessagem(Object msg) throws Exception {
        DateFormat formato = new SimpleDateFormat("hh:mm:ss"); 
        ((ObjectOutput) this.saida).writeObject(msg);      
    }
    public Object receberMessagem() throws Exception {
       DateFormat formato = new SimpleDateFormat("hh:mm:ss"); 
       return ((ObjectInput) this.entrada).readObject();
    }        
    public void finalizar() throws IOException {
        this.socket.close();
    }
    private void abrirChat(){
    }
        
      
}
