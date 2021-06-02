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

    public Productor(Semaphore semEnsa, Semaphore semProd, Semaphore mutex,  String name) {
        this.mutex = mutex;
        this.semEnsa = semEnsa;
        this.semProd = semProd;
        this.name = name;
    }

    
    public void run(){
        while(true){
        
            try {
                this.semProd.acquire();
                    this.mutex.acquire();
                        Main.botones++;
                        System.out.println("La variable subió a " + Main.botones + " el hilo " + this.name );
                    this.mutex.release();
                this.semEnsa.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
