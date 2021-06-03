/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos1gonzalezmicale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class Gerente extends Thread {
    Semaphore mutex;
    Semaphore semActivo;
    Semaphore semDormido;
    int tiempo;
    int dias;
    
    public Gerente(Semaphore mutex, Semaphore semActivo, Semaphore semDormido, int tiempo, int dias) {
        this.mutex = mutex;
        this.semActivo = semActivo;
        this.semDormido = semDormido;
        this.tiempo = tiempo;
        this.dias = dias;
    }
    
    public void run() {
        while(true) {
            try {
                if(Interfaz.dias == 0) {
                    System.out.println("Gerente Despierto");
                    TimeUnit.SECONDS.sleep(tiempo/3);

                    System.out.println("Gerente dormido");
                    TimeUnit.SECONDS.sleep((2*tiempo)/3);
                    
                    Interfaz.dias = dias;
                    Interfaz.contPanasTotales += Interfaz.contPanas;
                    Interfaz.contPanas = 0;
                }
                
            } catch(InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
