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
                        this.mutex.acquire();
                        
//                        System.out.println("La variable subió a " + interfaz.contBotones + " el hilo " + this.name );
                        Thread.sleep(Interfaz.tiempo/4);
                        Interfaz.contBotones = Interfaz.contBotones + 1;
                        this.mutex.release();
                        this.semEnsa.release();
                    case "brazos":
                        this.semProd.acquire();
                        this.mutex.acquire();
                        
//                        System.out.println("La variable subió a " + interfaz.contBrazos + " el hilo " + this.name );
                        Thread.sleep(Interfaz.tiempo);
                        Interfaz.contBrazos = Interfaz.contBrazos + 1;
                        this.mutex.release();
                        this.semEnsa.release();
                    case "piernas":
                        this.semProd.acquire();
                        this.mutex.acquire();
                        
//                        System.out.println("La variable subió a " + interfaz.contPiernas + " el hilo " + this.name );
                        Thread.sleep(Interfaz.tiempo*2);
                        Interfaz.contPiernas = Interfaz.contPiernas + 1;
                        this.mutex.release();
                        this.semEnsa.release();
                    case "cuerpos":
                        this.semProd.acquire();
                        this.mutex.acquire();
                        
//                        System.out.println("La variable subió a " + interfaz.contCuerpos + " el hilo " + this.name );
                        Thread.sleep(Interfaz.tiempo*3);
                        Interfaz.contCuerpos = Interfaz.contCuerpos + 1;
                        this.mutex.release();
                        this.semEnsa.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
