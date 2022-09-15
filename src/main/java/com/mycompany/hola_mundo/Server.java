/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hola_mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class Server {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto "+ port);
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            int count = 0;
            String inputline;
            
            
            while((inputline = in.readLine()) != null){
                count++;
                System.out.println(inputline);
                if(".".equals(inputline)){
                    out.println("adios");
                    break;
                }
                out.println("msg " + count);
            }
            
        } catch (IOException ex) {
            //Logger.getLogger(GreetServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al comunicarse");
        }
        
    }
    
    public void stop() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.start(5555);
    }
    
}
