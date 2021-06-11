package productor_consumidor;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Helado extends Thread{
    volatile boolean ejecutar = true;
    Heladeria h = new Heladeria();
    JVentana jv;
    int numHelados = 0;
    
    public Helado(JVentana jv){
        this.jv=jv;
    }
    
    public Helado(Heladeria hx){
        this.h=hx;
    }
    
    public void run(){
        
        while(ejecutar){
  
            numHelados = jv.p2.moverHelado();
            if(numHelados == 5){
                detener();
            }            
            try{
               
                Thread.sleep(200);
            }
            catch(InterruptedException e){}
        }
    }
    
    public void detener() {
        ejecutar = false;
    }
    
}