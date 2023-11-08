/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

/**
 *
 * @author Martin
 */
public class Messenger {

    /**
     * @param args the command line arguments
     */
    public static Conectar servidor;
    public static void main(String[] args) {
        
        VServidor server = new VServidor();
        server.main();
    }
    
    public static void initServer(){
        servidor = new Conectar("");
        servidor.start();
        
    }
    
}
