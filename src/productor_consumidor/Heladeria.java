package productor_consumidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Heladeria extends JPanel{

    int x = 220, y = 200;
    int numHelados = 0;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //MAQUINA
        g.setColor(Color.ORANGE);
        g.fillOval(50,50,200,100);
        g.setColor(Color.BLUE);
        g.fillRect(50,95,200,200);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(60,100,180,150);
        g.setColor(Color.BLACK);
        g.fillRect(60,100,180,20);
        g.setColor(Color.YELLOW);
        g.fillRect(100,75,100,20);
        
        
        g.setColor(Color.GRAY);
        g.fillRect(95,110,20,80);
        g.setColor(Color.BLACK);
        g.fillOval(95,180,20,20);
        g.setColor(Color.GRAY);
        g.fillRect(125,110,20,80);
        g.setColor(Color.BLACK);
        g.fillOval(125,180,20,20);
        g.setColor(Color.GRAY);
        g.fillRect(155,110,20,80);
        g.setColor(Color.BLACK);
        g.fillOval(155,180,20,20);
        g.setColor(Color.GRAY);
        g.fillRect(185,110,20,80);
        g.setColor(Color.BLACK);
        g.fillOval(185,180,20,20);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(80,260,140,30);
        
        //VIA
        g.setColor(Color.WHITE);
        g.fillRect(250,210,355,85);
        g.setColor(Color.BLACK);
        g.fillRect(250,215,355,75);
        g.setColor(Color.WHITE);
        g.fillRect(250,225,355,1);
        g.setColor(Color.WHITE);
        g.fillRect(250,252,355,1);
        g.setColor(Color.WHITE);
        g.fillRect(250,280,355,1);
        
        
        //CLIENTE
        
        g.setColor(Color.RED);
        g.fillRect(605,190,80,115);
        g.setColor(Color.ORANGE);
        g.fillOval(595,110,100,100);
        g.setColor(Color.BLACK);
        g.fillOval(625,160,40,30);
        g.setColor(Color.ORANGE);
        g.fillRect(625,138,40,40);
        g.setColor(Color.BLACK);
        g.fillOval(620,150,12,12);
        g.setColor(Color.BLACK);
        g.fillOval(650,150,12,12);
        g.setColor(Color.BLACK);
        g.fillRect(590,120,105,10);
        g.setColor(Color.BLACK);
        g.fillRect(605,110,73,20);
        g.setColor(Color.ORANGE);
        g.fillRect(560,210,45,15);
        g.setColor(Color.ORANGE);
        g.fillRect(615,230,73,15);
        
        
        //CLIENTE
        g.setColor(Color.RED);
        g.fillRect(725,190,80,115);
        g.setColor(Color.ORANGE);
        g.fillOval(715,110,100,100);
        g.setColor(Color.BLACK);
        g.fillOval(745,160,40,30);
        g.setColor(Color.ORANGE);
        g.fillRect(745,138,40,40);
        g.setColor(Color.BLACK);
        g.fillOval(740,150,12,12);
        g.setColor(Color.BLACK);
        g.fillOval(770,150,12,12);
        g.setColor(Color.BLACK);
        g.fillRect(710,120,105,10);
        g.setColor(Color.BLACK);
        g.fillRect(725,110,73,20);
        g.setColor(Color.ORANGE);
        g.fillRect(721,215,15,55);
        g.setColor(Color.ORANGE);
        g.fillRect(773,215,15,55);

        pintarHelado(g2);

    }
    
    public int moverHelado(){   
        
        if ( x <540) this.x = x + 40; //lo mueve hacia adelante            
        
        if( x == 540 ){
            this.x = 220;  //lo regresa a la primer posicion
            numHelados++;
        }                  
        repaint();
        return numHelados;
    }
    
    public void pintarHelado( Graphics2D g2){
        ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/he2.png"));
        g2.drawImage(img.getImage(), x, y, 80, 80, this);
        
    }
    
}
