/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;
import Mensagem.Mensagem;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.*;
import java.net.ServerSocket;
import java.io.IOException;
/**
 *
 * @author lucas
 */
public class Servidor implements Runnable {
    private ServerSocket serverSocket;
    private ArrayList<Mensagem> msg;   

    public Servidor(int porta) throws Exception{
        super();
        this.serverSocket = new ServerSocket(porta);
        this.msg = new ArrayList<Mensagem>();
        this.buscarMessagem(); 
        
    }
    public void finalizar() throws IOException {
        this.serverSocket.close();
    }
    public void buscarMessagem() throws IOException {
        entrada = new DataInputStream(new BufferedInputStream(serverSocket.getInputStream()));
        

    }

    @Override
    public void run() {
        while (true) {
            String mensagem;
            mensagem = entrada.readUTF();
            System.out.println(mensagem);
        }
    }
}
