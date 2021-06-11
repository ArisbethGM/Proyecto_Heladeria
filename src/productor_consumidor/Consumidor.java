package productor_consumidor;

public class Consumidor extends Thread{
    Buffer bf;
    JVentana jv;
    public Consumidor(Buffer bf,JVentana jv){
        this.bf=bf;
        this.jv=jv;
    }
    public void run(){
        //Recupera cadenas mientras nose hayan
        //obtenido todas
        while(jv.dmconsumidas.size()<=JVentana.TOTAL_CADENAS){
            synchronized(bf){
                //Extrae cadenas del buffer
                //si no esta vacio
                if(!bf.isEmpty())
                    jv.dmconsumidas.addElement(bf.extraer());
                //Notifica al proceso en espera
                //que ya puede utilizar el buffer
                bf.notify();
            }
            try{
                //se pone a dormir mas tiempo
                //que el productor para simulador
                //una velocidad de procesamiento
                //inferior a este
                Thread.sleep(800);
            }
            catch(InterruptedException e){}
        }
    }
}