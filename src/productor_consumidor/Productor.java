package productor_consumidor;

public class Productor extends Thread{
    Buffer bf;
    JVentana jv;
    
    public Productor(Buffer bf, JVentana jv){
        this.bf=bf;
        this.jv=jv;
    }
    public void run(){
        for(int i=0;i<JVentana.TOTAL_CADENAS;i++){
            synchronized(bf){
                //Pasa al estado de espera si
                //el buffer está lleno
                if(bf.isFull()){
                    try{
                        bf.wait();
                    }catch(InterruptedException e){}
                }
                //Transfiere al buffer el último elemento
                //de la lista.
                int seleccionado=
                        jv.dmexistentes.getSize()-1;
                bf.agregar(jv.dmexistentes.remove(seleccionado));
            }
            try{
                Thread.sleep(300);
            }
            catch(InterruptedException e){}
        }
    }
}