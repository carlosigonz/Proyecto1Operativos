package proyectooperativos1gonzalezmicale;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Gonzalez
 * Ricardo Micale
 */
public class Productor extends Thread {
    Semaphore mutex;
    Semaphore semCons;
    Semaphore semProd;
    String name;

    public Productor(Semaphore semCons, Semaphore semProd, Semaphore mutex,  String name) {
        this.mutex = mutex;
        this.semCons = semCons;
        this.semProd = semProd;
        this.name = name;
    }

    
    public void run(){
        while(true){
        
            try {
                this.semProd.acquire();
                    this.mutex.acquire();
                        Hilos.r++;
                        System.out.println("La variable subió a " + Hilos.r + " el hilo " + this.name );
                    this.mutex.release();
                this.semCons.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
