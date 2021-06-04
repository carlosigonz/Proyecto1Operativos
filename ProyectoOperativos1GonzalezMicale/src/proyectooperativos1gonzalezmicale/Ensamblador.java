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
    Semaphore semEnsaBtn = new Semaphore(8);
    Semaphore semEnsaBrazos = new Semaphore(2);
    Semaphore semEnsaPiernas = new Semaphore(2);
    Semaphore semEnsaCuerpos = new Semaphore(1);
    boolean vivo = true;

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
        while(vivo){
            try {
                this.semEnsa.acquire();
                this.mutex.acquire();
                if(Interfaz.contBotones >= 8 && Interfaz.contBrazos >= 2 && Interfaz.contPiernas >= 2 && Interfaz.contCuerpos >= 1){
                    
                    Interfaz.contBotones = Interfaz.contBotones - 8;
                    Interfaz.contBrazos = Interfaz.contBrazos - 2;
                    Interfaz.contPiernas = Interfaz.contPiernas - 2;
                    Interfaz.contCuerpos = Interfaz.contCuerpos - 1;
                    Interfaz.contPanas++;
//                    System.out.println("La variable pana subio a "+ Interfaz.contPanas + " el hilo " + this.name );
                }
                Thread.sleep(Interfaz.tiempo);
                
                this.mutex.release();
                this.semProd.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
    }
}
