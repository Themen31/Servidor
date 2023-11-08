/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Martin
 */
public class Conectar extends Thread{
    
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida; 
    private BufferedReader entrada;
    final int puerto = 8000;
    
    public Conectar(String nombre){
        super(nombre);
    }
    
    public void enviarMSG(String msg){
        try{
            this.salida.writeUTF(msg+"\n");
        }catch(IOException e){};
    }
    
    public void run(){
        
        String text = "test";
        try{
            this.ss = new ServerSocket(puerto);
            this.s = ss.accept();
            
            //Creacion de entrada de daros para lectura de mensaje
            this.entradaSocket = new InputStreamReader(s.getInputStream());
            this.entrada = new BufferedReader(entradaSocket);
            
            //Creacion de salida de datos para el envio de mensajes
            this.salida = new DataOutputStream(s.getOutputStream());
            while(true){
                    text = this.entrada.readLine();
                    System.out.println(text);
                VServidor.jTextArea1.setText(VServidor.jTextArea1.getText()+"\n"+text);
            }
        }catch(IOException e){
            System.out.println("Algun tipo e error ha sucedido");
        };
    }
    
    public String leerMSG(){
        try{
            return this.entrada.readLine();
        }catch(IOException e){};
        return null;
    }
    
    public void desconectar(){
        try{
            s.close();
        }catch(IOException e){};
        try{
            ss.close();
        }catch(IOException e){};
        
    }
    
    
    
}
