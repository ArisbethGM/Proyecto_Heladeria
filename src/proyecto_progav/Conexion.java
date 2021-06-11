package proyecto_progav;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    public Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/heladeria";
        String user="root";
        String pass="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
        }
        return con;
    }
}

/*import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion{
    Connection conectar=null;
    
    public Connection conexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/heladeria","root","");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error de conexion " +e.getMessage());
        }
        return conectar;
    }
} */