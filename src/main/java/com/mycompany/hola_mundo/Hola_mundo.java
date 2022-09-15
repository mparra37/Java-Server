/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hola_mundo;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class Hola_mundo {

    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        GreetClient client = new GreetClient();
        
        try{
                client.startConnection("localhost", 5555);
                
            
            }catch(IOException e){
                System.out.println("Error al conectarse");
                
            }
        
        while(true){
            System.out.print("Msg: ");
            String linea = in.nextLine();
            
            if(linea.equalsIgnoreCase("")){
                break;
            }else{
                 try{
                 
                String response = client.sendMessage(linea);
                 System.out.println(response);
            
            }catch(IOException e){
                System.out.println("Error al conectarse");
                System.out.println(e.getStackTrace());
            }
            }
            
             
            
        }
        
       
        
        
    }
}
