/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hola_mundo;

import java.io.*;
import java.net.*;

/**
 *
 * @author Mario
 */
public class GreetClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void startConnection(String ip, int port) throws IOException{
        clientSocket = new Socket(ip, port);
        System.out.println("Conexión existosa");
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
    
    public String sendMessage(String msg) throws IOException{
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }
    
    public void stopConnection() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
    }
    
    
}
