package Clien_CRUD.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Clien_CRUD.modelo.ClienteDAO;
import Clien_CRUD.modelo.Cliente;
import Clien_CRUD.vista.CliCRUD;

public class Segundo_Controlador implements ActionListener{
    
    ClienteDAO dao2 = new ClienteDAO();
    Cliente c = new Cliente();
    CliCRUD vista2 = new CliCRUD();
    DefaultTableModel modelo2=new DefaultTableModel();
    
    public Segundo_Controlador(CliCRUD c){
        this.vista2=c;
        this.vista2.btnList.addActionListener(this);
        this.vista2.btnGrdar.addActionListener(this);
        this.vista2.btnEdit.addActionListener(this);
        this.vista2.btnActu.addActionListener(this);
        this.vista2.btnElim.addActionListener(this);
        listarCli(vista2.TablaDatos2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vista2.btnList){
            limpiarTabla();
            listarCli(vista2.TablaDatos2);
        }
        if(e.getSource()==vista2.btnGrdar){
            agregar();
            limpiarTabla();
            listarCli(vista2.TablaDatos2);
        }
        if(e.getSource()==vista2.btnEdit){
            editar();
            limpiarTabla();
            listarCli(vista2.TablaDatos2);
        }
        if(e.getSource()==vista2.btnActu){
            Actualizar();
            limpiarTabla();
            listarCli(vista2.TablaDatos2);
        }
        if(e.getSource()==vista2.btnElim){
            delete();
            limpiarTabla();
            listarCli(vista2.TablaDatos2);
        }
    }
    
    public void agregar(){
        String nbr=vista2.txtNbr.getText();
        String ead=vista2.txtEad.getText();
        String sf=vista2.txtSF.getText();
        c.setNbr(nbr);
        c.setEad(ead);
        c.setSf(sf);
        int r=dao2.Agregar(c);
        if(r==1){
            JOptionPane.showMessageDialog(vista2, "Cliente agregado con exito!!");
        }else{
            JOptionPane.showMessageDialog(vista2, "Error");
        }
    }
    
    public void listarCli(JTable TablaDatos2){
        modelo2=(DefaultTableModel)TablaDatos2.getModel();
        List<Cliente>lista=dao2.listar();
        Object[]object=new Object[4];
        for(int i=0;i<lista.size();i++){
            object[0]=lista.get(i).getIdc();
            object[1]=lista.get(i).getNbr();
            object[2]=lista.get(i).getEad();
            object[3]=lista.get(i).getSf();
            modelo2.addRow(object);
        }
        vista2.TablaDatos2.setModel(modelo2);
    }

    public void editar(){        
        int fila=vista2.TablaDatos2.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(vista2,"Debe seleccionar una fila.");
        }else{            
            int cid=Integer.parseInt((String)vista2.TablaDatos2.getValueAt(fila,0).toString());
            String nbr=(String)vista2.TablaDatos2.getValueAt(fila, 1);
            String ead=(String)vista2.TablaDatos2.getValueAt(fila, 2);
            String sf=(String)vista2.TablaDatos2.getValueAt(fila, 3);
            vista2.txtIDc.setText(""+cid);
            vista2.txtNbr.setText(nbr);
            vista2.txtEad.setText(ead);
            vista2.txtSF.setText(sf);
            }  
    }
    
    public void Actualizar(){
        int cid=Integer.parseInt(vista2.txtIDc.getText());
        String nbr=vista2.txtNbr.getText();
        String ead=vista2.txtEad.getText();
        String sf=vista2.txtSF.getText();
        c.setIdc(cid);
        c.setNbr(nbr);
        c.setEad(ead);
        c.setSf(sf);
        int r=dao2.Actualizar(c);
        if(r==1){
            JOptionPane.showMessageDialog(vista2, "Cliente actualizado con exito!!");
        }else{
            JOptionPane.showMessageDialog(vista2, "Error");
        }
    }
    
    public void delete(){
         int fila=vista2.TablaDatos2.getSelectedRow();
         int cid=Integer.parseInt((String)vista2.TablaDatos2.getValueAt(fila,0).toString());
         if(fila==-1){
             JOptionPane.showMessageDialog(vista2,"Debe seleccionar un cliente.");
         }else{
             dao2.delete(cid);
             JOptionPane.showMessageDialog(vista2,"Cliente eliminado.");
         }
    }
    
    void limpiarTabla(){
        for(int i=0;i<vista2.TablaDatos2.getRowCount();i++){
            modelo2.removeRow(i);
            i=i-1;
        }
    }
}