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
public class Jefe extends Thread {
    Semaphore mutex;
    Semaphore semActivo;
    Semaphore semDormido;
    int tiempo;
    
    public Jefe(Semaphore mutex, Semaphore semActivo, Semaphore semDormido, int tiempo) {
        this.mutex = mutex;
        this.semActivo = semActivo;
        this.semDormido = semDormido;
        this.tiempo = tiempo;
    }
    
    public void run() {
        while(true) {
            try {
                Interfaz.dias--;
                System.out.println("Jefe Despierto");
                TimeUnit.SECONDS.sleep(tiempo/3);
                
                System.out.println("Jefe dormido");
                TimeUnit.SECONDS.sleep((2*tiempo)/3);
                
            } catch(InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
