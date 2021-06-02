package proyectooperativos1gonzalezmicale;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Carlos Gonzalez CI: 26.996.222, 
 * Ricardo Micale CI: 27.111.658
 */
public class Main {
    
//    public static volatile int botones = 0;
//    public static volatile int brazos = 0;
//    public static volatile int piernas = 0;
//    public static volatile int cuerpos = 0;
//    public static volatile int panas = 0;
    
    
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        try {
            interfaz.leerTxt();
        } catch(IOException e) {
            System.out.println("Hubo un error");
        }
        interfaz.setVisible(true);
//        //Semaforo Mutex. Permite la entrada de un hilo a la vez
//        Semaphore mutex = new Semaphore(1);
//        //Semaforo Ensamblador. Evita que el hilo ensamblador progrese sin 
//        Semaphore semEnsa = new Semaphore(0);
//        Semaphore semBotones = new Semaphore(interfaz.maxBtn);
//        Semaphore semBrazos = new Semaphore(interfaz.maxBrazos);
//        Semaphore semPiernas = new Semaphore(interfaz.maxPiernas);
//        Semaphore semCuerpos = new Semaphore(interfaz.maxCuerpos);
//        
//        //cantidad productores de cada parte
//        Productor[] productoresBtn = new Productor[interfaz.maxProdBtn];
//        Productor[] productoresBrazos = new Productor[interfaz.maxProdBrazos];
//        Productor[] productoresPiernas = new Productor[interfaz.maxProdPiernas];
//        Productor[] productoresCuerpos = new Productor[interfaz.maxProdCuerpos];
//        //cantidad ensambladores
//        Ensamblador[] ensambladores = new Ensamblador[interfaz.maxEnsambladores];
//        
//        for (int i = 0; i < productoresBtn.length; i++) {
//                String nombre = "botones" + i;
//                Productor prodBtn = new Productor(semEnsa, semBotones, mutex,botones ,nombre);
//                this.productoresBtn[i] = prodBtn;
//            }
//            
//            for (int i = 0; i < productoresBrazos.length; i++) {
//                String nombre = "brazos" + i;
//                Productor prodBrazos = new Productor(semEnsa, semBrazos, mutex,brazos ,nombre);
//                this.productoresBrazos[i] = prodBrazos;
//            }
//            
//            for (int i = 0; i < productoresPiernas.length; i++) {
//                String nombre = "piernas" + i;
//                Productor prodPiernas = new Productor(semEnsa, semPiernas, mutex,piernas ,nombre);
//                this.productoresPiernas[i] = prodPiernas;
//            }
//            
//            for (int i = 0; i < productoresCuerpos.length; i++) {
//                String nombre = "cuerpos" + i;
//                Productor prodCuerpos = new Productor(semEnsa, semCuerpos, mutex,cuerpos ,nombre);
//                this.productoresCuerpos[i] = prodCuerpos;
//            }
        
        
//        Productor p = new Productor(semEnsa, semProd, mutex,"Pérez");
//        Ensamblador g = new Ensamblador(semEnsa, semProd, mutex,"García");
//        Productor b = new Productor(semEnsa, semProd, mutex, "Baladi");
//        
//        p.start();
//        g.start();
//        b.start();
    }
    
}
