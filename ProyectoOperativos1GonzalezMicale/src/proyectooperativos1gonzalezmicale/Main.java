package proyectooperativos1gonzalezmicale;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Carlos Gonzalez CI: 26.996.222, 
 * Ricardo Micale CI: 27.111.658
 */
public class Main {
    
    public static volatile int botones = 0;
    public static volatile int brazos = 0;
    public static volatile int piernas = 0;
    public static volatile int cuerpos = 0;
    public static volatile int panas = 0;
    
    
    
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        try {
            interfaz.leerTxt();
        } catch(IOException e) {
            System.out.println("Hubo un error");
        }
        Semaphore mutex = new Semaphore(1);
        Semaphore semEnsa = new Semaphore(0);
        Semaphore semBotones = new Semaphore(interfaz.maxBtn);
        Semaphore semBrazos = new Semaphore(interfaz.maxBrazos);
        Semaphore semPiernas = new Semaphore(interfaz.maxPiernas);
        Semaphore semCuerpos = new Semaphore(interfaz.maxCuerpos);
        
        interfaz.setVisible(true);
        
        
//        Productor p = new Productor(semEnsa, semProd, mutex,"Pérez");
//        Ensamblador g = new Ensamblador(semEnsa, semProd, mutex,"García");
//        Productor b = new Productor(semEnsa, semProd, mutex, "Baladi");
//        
//        p.start();
//        g.start();
//        b.start();
    }
    
}
