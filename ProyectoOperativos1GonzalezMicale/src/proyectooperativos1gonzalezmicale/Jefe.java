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
    public static volatile boolean status;
    
    public Jefe(Semaphore mutex, Semaphore semActivo, Semaphore semDormido, int tiempo) {
        this.mutex = mutex;
        this.semActivo = semActivo;
        this.semDormido = semDormido;
        this.tiempo = tiempo;
    }
    
    public void run() {
        while(true) {
            try {
                this.semActivo.acquire();
                this.mutex.acquire();

                Interfaz.dias--;

                if(!Gerente.status) {
                    this.status = true;
                    Thread.sleep(tiempo/3);
                } 

                this.status = false;
                Thread.sleep((2*tiempo)/3);
                
                this.mutex.release();
                this.semDormido.release();
                
            } catch(InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
