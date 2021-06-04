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
    public static volatile boolean status;
    
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
                this.semDormido.acquire();
                this.mutex.acquire();
                
                this.status = true;
                System.out.println("Gerente Despierto");
                
                if(!Jefe.status) {
                    
                    if(Interfaz.dias == 0) {
                        Interfaz.dias = dias;
                        Interfaz.contPanasTotales += Interfaz.contPanas;
                        Interfaz.contPanas = 0;
                    }
                    
                } else {
                    Thread.sleep(tiempo/3);
                }
                
                this.status = false;
                    
                System.out.println("Gerente dormido");
                Thread.sleep((2*tiempo)/3);
                
                this.mutex.release();
                this.semActivo.release();
                
            } catch(InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
