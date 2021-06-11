package productor_consumidor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyecto_progav.VentanaPrincipal;

public class JVentana extends JFrame implements ActionListener{
    
    
    JList jlistaexistentes;
    JList jlistabuffer;
    JList jlistaconsumidas;
    DefaultListModel dmexistentes;
    DefaultListModel dmconsumidas;
    
    
    JPanel p1, p3;
    Heladeria p2;
    JButton jbotonregresar,jbotoncomenzar;

    public static final int TOTAL_CADENAS=10;
    
    
    public JVentana() {
        super("HELADERIA");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);
        this.setLayout(new BorderLayout());
 
        
        p1= new JPanel();
//        p1.setLayout(null);
//        p3= new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.GRAY);
        
        //lOS COMPONENTES
        p2 = new Heladeria();
        p2.setBackground(Color.LIGHT_GRAY);
//        p2.setLayout(null);

        
        dmexistentes=new DefaultListModel();
        dmconsumidas=new DefaultListModel();
        
        //Genera las cadenas y las almacena en la lista fuente
        for(int i=1;i<=JVentana.TOTAL_CADENAS;i++){
            dmexistentes.addElement(" "+"Helado "+" '"+i+"' ");
        }
        //Creacion de las listas a partir de las
        //coleccions ListModel
        jlistaexistentes=new JList(dmexistentes);
        jlistabuffer=new JList();
        jlistaconsumidas=new JList(dmconsumidas);
        
        //creacion del boton de comienzo
        jbotoncomenzar = new JButton("Comenzar");
        jbotoncomenzar.addActionListener(new Gestion(this));
        
        //creacion del boton de regresar
        jbotonregresar = new JButton("Regresar");
        jbotonregresar.addActionListener(this);
        
        //Agrega las listas a paneles de desplazamiento.
        JScrollPane j1= new JScrollPane(jlistaexistentes);
        JScrollPane j2= new JScrollPane(jlistabuffer);
        JScrollPane j3= new JScrollPane(jlistaconsumidas);
        JLabel jl1= new JLabel("Máquina de Helados"+"                                                                  ");
        JLabel jl3= new JLabel("Clientes");
        jl1.setFont(new Font("fantasy",0, 20));
        jl3.setFont(new Font("fantasy",0, 20));
        
        jl1.setForeground(Color.BLACK);
        jl3.setForeground(Color.BLACK);
        
        //Posiciona los controles y los
        //añade al contenedor
        jl1.setBounds(5,50,170,20);
        jl3.setBounds(10,50,180,20);
        
        jbotoncomenzar.setFont(new Font("fantasy",0, 15));
        jbotoncomenzar.setForeground(Color.BLACK);
        jbotoncomenzar.setBackground(Color.WHITE);
        jbotoncomenzar.setBorder(BorderFactory.createLineBorder (Color.black));
        
        jbotonregresar.setFont(new Font("fantasy",0, 15));
        jbotonregresar.setForeground(Color.BLACK);
        jbotonregresar.setBackground(Color.WHITE);
        jbotonregresar.setBorder(BorderFactory.createLineBorder (Color.black));
        
        
        p2.add(jl1);
        p2.add(jl3);
        p1.add(j1);
        p1.add(j2);
        p1.add(j3);
        p1.add(jbotoncomenzar);
        p1.add(jbotonregresar);


        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jbotonregresar) {
            this.setVisible(false);  
            new VentanaPrincipal().setVisible(true);        
	}
    }
}