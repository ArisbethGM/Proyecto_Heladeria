package proyecto_progav;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Clien_CRUD.vista.CliCRUD;
import Helad_CRUD.vista.CRUDH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import Helad_CRUD.controlador.Controlador;
import Clien_CRUD.controlador.Segundo_Controlador;

public class VentanaLogin extends JFrame implements ActionListener{
    
    public JButton b1,b2, b3;
    public JLabel l1, l2, l3,imagen;
    public JTextField t1,t2;
    public JPanel p1;
    public ImageIcon logo;
    FondoJpanelLogin fondo = new  FondoJpanelLogin();
    public String campo1,campo2;
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
    
    public VentanaLogin(){
        setTitle("LOGIN");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        p1= new FondoJpanelLogin();
        p1.setLayout(null);
        
        l1= new JLabel("HELADERIA");
        l2= new JLabel("ADMINISTRADOR");
        l3= new JLabel("CONTRASEÑA");
        
        imagen = new JLabel();
        imagen.setBounds(90,100,250,250);
        imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/dh.png")));
        
        t1= new JTextField();
        t2= new JTextField();	
        
        
        b1 = new JButton("Administrar cliente");
        b2 = new JButton("Regresar");
        b3 = new JButton("Administrar heladero");

        
        l1.setFont(new Font("sans-serif",0, 60)); 
        l3.setFont(new Font("Serif",0, 25)); 
        l2.setFont(new Font("Serif",0, 25)); 
        b1.setFont(new Font("Serif",0, 15));
        b3.setFont(new Font("Serif",0, 15));
        b2.setFont(new Font("Serif",0, 15));

        
        l1.setForeground(Color.BLACK);
        l3.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.GRAY);
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.GRAY);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.GRAY);
        
        b2.setBorder(BorderFactory.createLineBorder (Color.black));
        
        l1.setBounds(230, 8, 450,100);
        l2.setBounds(420, 90, 230,100);
        l3.setBounds(420, 190, 200,100); 
        
        t1.setBounds(420, 170, 220,30);
        t2.setBounds(420, 270, 220,30);
        
        b1.setBorder(BorderFactory.createLineBorder (Color.black));
        b1.setBounds(530, 330, 130, 40);  
        b3.setBorder(BorderFactory.createLineBorder (Color.black));
        b3.setBounds(390, 330, 130, 40);  
        b2.setBorder(BorderFactory.createLineBorder (Color.black));
        b2.setBounds(90, 370, 120, 30);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b3.addActionListener(this);
  
        p1.add(l3);
        p1.add(l2);
        p1.add(l1);
        p1.add(b1);
        p1.add(b3);
        p1.add(b2);
        p1.add(t1);
        p1.add(t2);
        p1.add(imagen);
        
        
        this.setContentPane(fondo);
        this.setContentPane(p1);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        
	if (e.getSource()==b1) {
            validarUsuario2();
	}
        if (e.getSource()==b3) {
            validarUsuario();
	}
        if (e.getSource()==b2) {
            this.setVisible(false);
            new VentanaPrincipal().setVisible(true);
	}
                
		
    }
    
    public void validarUsuario(){
        
        int resultado= 0;
        String usuario=t1.getText();
        String contraseña=t2.getText();
        String SQL="select * from heladero where IDheladero='"+contraseña+"' and Nombre='"+usuario+"'";
        
        try{
            
            con=conectar.getConnection();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            
            if (rs.next()) {
                resultado=1;
                
                if(resultado==1){
                    CRUDH ch=new CRUDH();
                    Controlador co=new Controlador(ch);
                    ch.setVisible(true);
                    ch.setLocationRelativeTo(ch);
                }
            }else{
                JOptionPane.showMessageDialog(null,"ACCESO DENEGADO");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error de conexion " + e.getMessage());
        }
    }
    
    public void validarUsuario2(){
        
        int resultado= 0;
        String usuario=t1.getText();
        String contraseña=t2.getText();
        String SQL="select * from heladero where IDheladero='"+contraseña+"' and Nombre='"+usuario+"'";
        
        try{
            
            con=conectar.getConnection();
            ps=con.prepareStatement(SQL);
            rs=ps.executeQuery();
            
            if (rs.next()) {
                resultado=1;
                
                if(resultado==1){
                    CliCRUD cc=new CliCRUD();
                    Segundo_Controlador sco=new Segundo_Controlador(cc);
                    cc.setVisible(true);
                    cc.setLocationRelativeTo(cc);
                }
            }else{
                JOptionPane.showMessageDialog(null,"ACCESO DENEGADO");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error de conexion " + e.getMessage());
        }
    }
    
   
}

class FondoJpanelLogin extends JPanel{
    private Image imagen;
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/imagenes/helado.jpg")).getImage();
        
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);    
        
        setOpaque(false);
        
        super.paint(g);
    }
}