package proyectooperativos1gonzalezmicale;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Gonzalez CI: 26.996.222, 
 * Ricardo Micale CI: 27.111.658
 */
public class Productor extends Thread {
    Semaphore mutex;
    Semaphore semEnsa;
    Semaphore semProd;
    String name;
    String produccion;
    Interfaz interfaz;

    /**
     * Se crea un hilo productor que añade elementos a los objetos seleccionados.
     * @param semEnsa
     * @param semProd
     * @param mutex
     * @param produccion
     * @param name
     */
    public Productor(Semaphore semEnsa, Semaphore semProd, Semaphore mutex,String produccion  ,String name) {
        this.mutex = mutex;
        this.semEnsa = semEnsa;
        this.semProd = semProd;
        this.name = name;
        this.produccion = produccion;
    }

    
    public void run(){
        while(true){
        
            try {
                switch(this.produccion){
                    case "botones":
                        this.semProd.acquire();
                        this.semEnsa.acquire();
                        this.mutex.acquire();
                        Interfaz.contBotones = Interfaz.contBotones + 1;
                        System.out.println("La variable subió a " + interfaz.contBotones + " el hilo " + this.name );
                        Thread.sleep(2000);
                        this.mutex.release();
                        this.semEnsa.release();
                        this.semProd.release();
                    case "brazos":
                        this.semProd.acquire();
                        this.semEnsa.acquire();
                        this.mutex.acquire();
                        Interfaz.contBrazos = Interfaz.contBrazos + 1;
                        System.out.println("La variable subió a " + interfaz.contBrazos + " el hilo " + this.name );
                        Thread.sleep(2000);
                        this.mutex.release();
                        this.semEnsa.release();
                        this.semProd.release();
                    case "piernas":
                        this.semProd.acquire();
                        this.semEnsa.acquire();
                        this.mutex.acquire();
                        Interfaz.contPiernas = Interfaz.contPiernas + 1;
                        System.out.println("La variable subió a " + interfaz.contPiernas + " el hilo " + this.name );
                        Thread.sleep(2000);
                        this.mutex.release();
                        this.semEnsa.release();
                        this.semProd.release();
                    case "cuerpos":
                        this.semProd.acquire();
                        this.semEnsa.acquire();
                        this.mutex.acquire();
                        Interfaz.contCuerpos = Interfaz.contCuerpos + 1;
                        System.out.println("La variable subió a " + interfaz.contCuerpos + " el hilo " + this.name );
                        Thread.sleep(2000);
                        this.mutex.release();
                        this.semEnsa.release();
                        this.semProd.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
