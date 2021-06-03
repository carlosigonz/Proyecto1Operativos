package proyectooperativos1gonzalezmicale;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Carlos Gonzalez CI: 26.996.222, 
 * Ricardo Micale CI: 27.111.658
 */
public class Ensamblador extends Thread {
    Semaphore mutex;
    Semaphore semEnsa;
    Semaphore semProd;
    String name;
    int botones,brazos,piernas,cuerpos,panas;
    Semaphore semEnsaBtn = new Semaphore(8);
    Semaphore semEnsaBrazos = new Semaphore(2);
    Semaphore semEnsaPiernas = new Semaphore(2);
    Semaphore semEnsaCuerpos = new Semaphore(1);

    /**
     *Se crea un hilo ensamblador que remueve elementos a los objetos seleccionados.
     * 
     * @param semEnsa
     * @param semProd
     * @param mutex
     * @param name
     */
    public Ensamblador( Semaphore semEnsa, Semaphore semProd,Semaphore mutex, String name) {
        this.mutex = mutex;
        this.semEnsa = semEnsa;
        this.semProd = semProd;
        this.name = name;
    }
    
    public void run(){
        while(true){
            try {
                if(botones>=8&&brazos>=2&&piernas>=2&&cuerpos>=1){
                this.semEnsa.acquire();
                    this.mutex.acquire();
                       botones = botones - 8;
                       brazos = brazos - 2;
                       piernas = piernas - 2;
                       cuerpos = cuerpos - 1;
                        panas++;
                        System.out.println("La variable pana subio a "+ panas + " el hilo " + this.name );
                        Thread.sleep(1000);
                    this.mutex.release();
                this.semProd.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
    }
}
