package productor_consumidor;

import javax.swing.*;
//El buffer se implementa como
//un ListModel

public class Buffer extends DefaultListModel{
    private int limite;
    public Buffer(int l){
        limite=l;
    }
    public void agregar(Object o){
        if(!isFull())
            this.addElement(o);
    }
    public Object extraer(){
        return this.remove(0);
    }
    public boolean isFull(){
        if(this.getSize()>=limite)
            return true;
        else
            return false;
    }
}