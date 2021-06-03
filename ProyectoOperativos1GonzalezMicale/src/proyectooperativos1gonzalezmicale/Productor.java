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
    Semaphore semEnsa;
    Semaphore semProd;
    String name;
    int especialidad;

    public Productor(Semaphore semEnsa, Semaphore semProd, Semaphore mutex,int especialidad  ,String name) {
        this.mutex = mutex;
        this.semEnsa = semEnsa;
        this.semProd = semProd;
        this.name = name;
        this.especialidad = especialidad;
    }

    
    public void run(){
        while(true){
        
            try {
                this.semProd.acquire();
                    this.mutex.acquire();
                        especialidad++;
                        System.out.println("La variable subió a " + especialidad + " el hilo " + this.name );
                        Thread.sleep(2000);
                    this.mutex.release();
                this.semEnsa.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
