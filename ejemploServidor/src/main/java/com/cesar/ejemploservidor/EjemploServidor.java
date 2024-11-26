/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cesar.ejemploservidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2 DAM CIFP Cesar Manrique
 */
public class EjemploServidor {

   // Se establece el puerto en el que abrimos el canal de comunicación
   static final int PUERTO = 69;
   
   public static void main(String args[]) {
    try {
            // Se inicia el servidor en el equipo local en el puerto indicado
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            // Espera la conexión con un cliente. accept es un método bloqueante
            Socket socketCliente = socketServidor.accept();

            // Establece los flujos de salida y entrada (desde y hacia el cliente, respectivamente)
            PrintWriter entradaCliente = new PrintWriter(socketCliente.getOutputStream(),true);
            BufferedReader salidaCliente = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            // Envía algunos ç
            entradaCliente.println("Hola " + socketCliente.getInetAddress().getHostAddress());
            entradaCliente.println("Dame dos numeros y te devuelvo la suma :)");
            /*
             * Esta sucesión de instrucciones siempre ocurrirá en este
             * orden.
             */
            int n1 = Integer.parseInt(salidaCliente.readLine());
            System.out.println("El primer operando es:  " + n1);
            
            int n2 = Integer.parseInt(salidaCliente.readLine());
            System.out.println("El segundo operando es:  " + n2);
     
           
            entradaCliente.println("Te paso la suma:" + (n1 + n2) );
            
            
            entradaCliente.println("Hasta otra, amigo del alma . . .");
            // Cierra la conexión con el cliente
            socketCliente.close();
            // Paramos el servidor, a partir de ahora no aceptamos conexiones
            socketServidor.close();
                   
    } catch (IOException ioe) {
            ioe.printStackTrace();
    }
}
}
