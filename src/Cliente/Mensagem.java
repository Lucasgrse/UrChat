/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.Serializable;
import java.text.DateFormat;

/**
 *
 * @author lucas
 */
public class Mensagem implements Serializable { //
    private String texto;
    private String nome;
    private DateFormat date;
    
    public Mensagem(String texto, String nome){
        this.texto = texto;
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Mensagem ["+ "Data=" +date + "nome=" + nome + ", texto=" + texto + "]";
    }
}
