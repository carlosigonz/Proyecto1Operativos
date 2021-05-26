package proyectooperativos1gonzalezmicale;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carlo
 */
public class Hilos {
    
    public static volatile int r = 0;
    
    public static void main(String[] args) {
        
        Semaphore mutex = new Semaphore(1);
        Semaphore semCons = new Semaphore(0);
        Semaphore semProd = new Semaphore(6);
        
        Productor p = new Productor(semCons, semProd, mutex,"Pérez");
        Ensamblador g = new Ensamblador(semCons, semProd, mutex,"García");
        Productor b = new Productor(semCons, semProd, mutex, "Baladi");
        
        p.start();
        g.start();
        b.start();
        
    }
}
