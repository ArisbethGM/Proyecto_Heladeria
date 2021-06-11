package Helad_CRUD.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Helad_CRUD.modelo.HeladeroDAO;
import Helad_CRUD.modelo.Heladero;
import Helad_CRUD.vista.CRUDH;

public class Controlador implements ActionListener{
    
    HeladeroDAO dao = new HeladeroDAO();
    Heladero h = new Heladero();
    CRUDH vista = new CRUDH();
    DefaultTableModel modelo=new DefaultTableModel();
    
    public Controlador(CRUDH c){
        this.vista=c;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        listar(vista.TablaDatos);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListar){
            limpiarTabla();
            listar(vista.TablaDatos);
        }
        if(e.getSource()==vista.btnGuardar){
            agregar();
            limpiarTabla();
            listar(vista.TablaDatos);
        }
        if(e.getSource()==vista.btnEditar){
            editar();
            limpiarTabla();
            listar(vista.TablaDatos);
        }
        if(e.getSource()==vista.btnActualizar){
            Actualizar();
            limpiarTabla();
            listar(vista.TablaDatos);
        }
        if(e.getSource()==vista.btnEliminar){
            delete();
            limpiarTabla();
            listar(vista.TablaDatos);
        }
    }
    
    public void agregar(){
        String nom=vista.txtNom.getText();
        String ed=vista.txtEd.getText();
        String trn=vista.txtTrn.getText();
        h.setNom(nom);
        h.setEd(ed);
        h.setTrn(trn);
        int r=dao.Agregar(h);
        if(r==1){
            JOptionPane.showMessageDialog(vista, "Heladero agregado con exito!!");
        }else{
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }
    
    public void listar(JTable TablaDatos){
        modelo=(DefaultTableModel)TablaDatos.getModel();
        List<Heladero>lista=dao.listar();
        Object[]object=new Object[4];
        for(int i=0;i<lista.size();i++){
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getNom();
            object[2]=lista.get(i).getEd();
            object[3]=lista.get(i).getTrn();
            modelo.addRow(object);
        }
        vista.TablaDatos.setModel(modelo);
    }
    
    public void editar(){
         int fila=vista.TablaDatos.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista,"Debe seleccionar una fila.");
            }else{
                int id=Integer.parseInt((String)vista.TablaDatos.getValueAt(fila,0).toString());
                String nom=(String)vista.TablaDatos.getValueAt(fila, 1);
                String ed=(String)vista.TablaDatos.getValueAt(fila, 2);
                String trn=(String)vista.TablaDatos.getValueAt(fila, 3);
                vista.txtIDh.setText(""+id);
                vista.txtNom.setText(nom);
                vista.txtEd.setText(ed);
                vista.txtTrn.setText(trn);
            }  
    }
    
    public void Actualizar(){
        int id=Integer.parseInt(vista.txtIDh.getText());
        String nom=vista.txtNom.getText();
        String ed=vista.txtEd.getText();
        String trn=vista.txtTrn.getText();
        h.setId(id);
        h.setNom(nom);
        h.setEd(ed);
        h.setTrn(trn);
        int r=dao.Actualizar(h);
        if(r==1){
            JOptionPane.showMessageDialog(vista, "Heladero actualizado con exito!!");
        }else{
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }
    
    public void delete(){
         int fila=vista.TablaDatos.getSelectedRow();
         int id=Integer.parseInt((String)vista.TablaDatos.getValueAt(fila,0).toString());
         if(fila==-1){
             JOptionPane.showMessageDialog(vista,"Debe seleccionar un heladero.");
         }else{
             dao.delete(id);
             JOptionPane.showMessageDialog(vista,"Heladero eliminado.");
         }
    }
    
    void limpiarTabla(){
        for(int i=0;i<vista.TablaDatos.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
}