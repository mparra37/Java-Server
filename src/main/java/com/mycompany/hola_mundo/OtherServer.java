/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hola_mundo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class OtherServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("The server is running at port 5678");
        
       String msg;
       ServerSocket ss = new ServerSocket(5678);
       
       while(true){
           Socket s = ss.accept();
           DataInputStream dis = new DataInputStream(s.getInputStream());
           msg = dis.readUTF();
           
           dis.close();
           s.close();
           System.out.println("Msg: " + msg);
       }
        
    }
    
}
