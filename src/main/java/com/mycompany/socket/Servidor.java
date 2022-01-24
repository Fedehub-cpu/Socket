package com.mycompany.socket;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

   
    public static void main(String[] args) {
        
        ServerSocket mi_servicio = null;
        String linea_recibida;
        BufferedReader entrada;
        DataOutputStream salida;
        Socket socket_conectado = null;
        
        
        try {
            
            //Abrimos el puerto a la escucha
            mi_servicio = new ServerSocket(2517);
            
        } catch (IOException excepcion) {
            System.out.println(excepcion);
        }
  
        try {
            //Aceptamos la info que venga hacia nuestro puerto
            socket_conectado = mi_servicio.accept();
            
            //Creamos el Input que nos va garantizar captar el flujo de datos.
            entrada=new BufferedReader(new
            InputStreamReader(socket_conectado.getInputStream()));
            
            //Mediante printstream agregamos funcionalidad al flujo de salida
           salida = new
           DataOutputStream(socket_conectado.getOutputStream());
            
            //Creamos el string que lee la línea de texto recibida
            linea_recibida = entrada.readLine();
            
            

           
            /*String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            
            String suma = String.valueOf(Integer.parseInt(b) + Integer.parseInt(c));
            if(a.equals("Suma")){
                
                salida.println("La suma es: " + suma);
                        
                        }
            String resta = String.valueOf(Integer.parseInt(b) - Integer.parseInt(c)); 
            if(a.equals("Resta")){
                
                salida.println("La resta es: " + resta);
                        
                        }
            String Multiplicacion = String.valueOf(Integer.parseInt(b) * Integer.parseInt(c));
            if(a.equals("Multiplicacion")){
                
                salida.println("La multiplicación es: " + Multiplicacion);
                        
                        }
            String Division = String.valueOf(Integer.parseInt(b) / Integer.parseInt(c));
            if(a.equals("Division")){
                
                salida.println("La división es: " + Division);
                        
                        }*/

            //Reenviamos a la máquina cliente el mensaje recibido
            
  
            System.out.println("CLIENTE DICE: " + linea_recibida);
            
           StringTokenizer st = new StringTokenizer(linea_recibida);
            
           String a = st.nextToken();
             
           while (st.hasMoreTokens()) {
               
             String b = st.nextToken().toUpperCase();
             String c = st.nextToken();
           
             salida.writeBytes(" " + b);
             
                 }
            
            //Cerramos conexion
            salida.close();
            entrada.close();
            socket_conectado.close();
            
            
        } catch (IOException excepcion) {
            System.out.println(excepcion);
        }
        
    }
    
}
