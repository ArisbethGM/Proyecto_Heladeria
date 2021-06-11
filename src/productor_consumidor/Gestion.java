package productor_consumidor;
//Clase para gestion del evento
//click sobre el botón "comenzar"
import java.awt.event.*;

public class Gestion implements ActionListener{
    JVentana jv;
    Heladeria ha;
    
    public Gestion(JVentana jv){
        this.jv=jv;
    }
    
    public Gestion(Heladeria xha){
        this.ha=xha;
    }
    
    public void actionPerformed(ActionEvent e){
        System.out.println("Entro al boton");
        //Crea el buffer u le asigna
        //tamaño maximo, por ejemplo 4
        Buffer bf=new Buffer(4);
        //Asocia el buffer al JList
        jv.jlistabuffer.setModel(bf);
       
        Thread t1=new Consumidor(bf,jv);
        Thread t2=new Productor(bf, jv);
        Thread t3 = new Helado(jv);
        
        
        t1.start();
        t2.start();
        t3.start();
        jv.jbotoncomenzar.setEnabled(false);
    }
}
