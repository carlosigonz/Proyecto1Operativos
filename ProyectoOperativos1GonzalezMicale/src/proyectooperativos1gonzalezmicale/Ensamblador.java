package proyectooperativos1gonzalezmicale;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carlo
 */
public class Ensamblador extends Thread {
    Semaphore mutex;
    Semaphore semCons;
    Semaphore semProd;
    String name;

    public Ensamblador( Semaphore semCons, Semaphore semProd,Semaphore mutex, String name) {
        this.mutex = mutex;
        this.semCons = semCons;
        this.semProd = semProd;
        this.name = name;
    }
    
    public void run(){
        while(true){
            try {
                this.semCons.acquire();
                    this.mutex.acquire();
                        Main.botones--;
                        System.out.println("La variable bajó a " + Main.botones + " el hilo " + this.name );
                    this.mutex.release();
                this.semProd.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
    }
}
