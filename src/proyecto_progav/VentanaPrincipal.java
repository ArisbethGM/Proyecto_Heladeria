package proyecto_progav;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import productor_consumidor.JVentana;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    
    public JButton b1, b2, b3;
    public JLabel l1, l2, l3 ,l4,l5;
    public JPanel p1;
    FondoJpanel fondo = new  FondoJpanel();
    
    public VentanaPrincipal() {
        setTitle("HELADERIA");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        l1= new JLabel("HELADERIA");
        l2= new JLabel("UN HELADO LO ES TODO");
        l3= new JLabel("La vida es como un HELADO disfrutala antes de que se derrita");
        l4= new JLabel("Hecho por: Arisbeth y Pablo");
        l5= new JLabel("BIENVENIDOS");
        p1= new FondoJpanel();
        p1.setLayout(null);
        
        l1.setFont(new Font("sans-serif",0, 60)); 
        l3.setFont(new Font("monospace",0, 20)); 
        l2.setFont(new Font("cursive",0, 18)); 
        l5.setFont(new Font("fantasy",0, 25));
        l4.setFont(new Font("fantasy",0, 10));
        
        l1.setForeground(Color.BLACK);
        l3.setForeground(Color.BLACK);
        l2.setForeground(Color.BLACK);
        l5.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);
        
        
        b1 = new JButton("Entrar");
        b1.setFont(new Font("cooper black",0, 20));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.GRAY);
        b1.setBorder(BorderFactory.createLineBorder (Color.black));
        b2 = new JButton("Administrador");
        b2.setFont(new Font("cooper black",0, 20)); 
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.GRAY);
        b2.setBorder(BorderFactory.createLineBorder (Color.black));
//        b3 = new JButton();
//        b3.setFont(new Font("cooper black",0, 20)); 
//        b3.setForeground(Color.BLACK);
//        b3.setBackground(Color.RED);
//        b3.setBorder(BorderFactory.createLineBorder (Color.black));
       
        l1.setBounds(230, 8, 450,100);
        l3.setBounds(120, 60, 650,100);
        l2.setBounds(290, 90, 400,100);
        l4.setBounds(10, 400, 180,100);
        l5.setBounds(310, 200, 280,100);
        
        b1.setBounds(190, 300, 190, 50);
        b2.setBounds(410, 300, 190,50);
        //b3.setBounds(480, 290, 120, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
        //b3.addActionListener(this);
        
        
        p1.add(l3);
        p1.add(l2);
        p1.add(l1);
        p1.add(l4);
        p1.add(l5);
        p1.add(b1);
        p1.add(b2);
        //p1.add(b3);
        this.setContentPane(fondo);
        this.setContentPane(p1);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
                    this.setVisible(false);
                    new JVentana().setVisible(true);
		}
                if (e.getSource()==b2) {
//			new VentanaLogin().setVisible(true);
                    this.setVisible(false);
                    new VentanaLogin().setVisible(true);
		}
		
    }
    
}

class FondoJpanel extends JPanel{
    private Image imagen;
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/imagenes/helado.jpg")).getImage();
        
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);    
        
        setOpaque(false);
        
        super.paint(g);
    }
}