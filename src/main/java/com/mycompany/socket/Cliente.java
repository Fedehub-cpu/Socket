package com.mycompany.socket;
import java.io.*;
import java.net.*;
public class Cliente 
{
public static void main(String args[])
{
Socket cliente = null;
BufferedReader entrada=null;
DataOutputStream salida = null;
String ipServidor ="127.0.0.1"; 
//nos conectamos al localhost a traves de esta dirección IP
try
{
cliente = new Socket(ipServidor, 2517); 
//asignamos este numero de puerto
entrada = new BufferedReader(new
InputStreamReader(cliente.getInputStream()));
// será lo que enviaremos al servidor
salida = new
DataOutputStream(cliente.getOutputStream());
// será lo que nos devuelva el servidor
}
catch (UnknownHostException excepcion)
{
System.err.println("El servidor no está levantado");
}
catch (Exception e)
{
System.err.println("Error: " + e );
}
try
{
    System.out.println("Puerto local: " + cliente.getLocalPort() + " "
                       + "\n IP local: " + cliente.getLocalAddress() + " "
                       + "\n Puerto remoto: " + cliente.getPort());
    
    
    
    
String linea_recibida;
salida.writeBytes("soy el docente de dam\n");
linea_recibida = entrada.readLine();
System.out.println("SERVIDOR DICE " +
linea_recibida);
salida.close();
entrada.close();
cliente.close();
}
catch (UnknownHostException excepcion)
{
System.err.println("No encuentro el servidor en la dirección" + ipServidor);
}
catch (IOException excepcion)
{
System.err.println("Error de entrada/salida");
}
catch (Exception e)
{
System.err.println("Error: " + e );
}
}
}
