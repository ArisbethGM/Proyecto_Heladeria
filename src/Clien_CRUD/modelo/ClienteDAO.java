package Clien_CRUD.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion conectar2 = new Conexion();
    Connection con2;
    PreparedStatement ps2;
    ResultSet rs2;
    
    public List listar(){
        List<Cliente>datos=new ArrayList<>();
        String sql="select * from cliente";
        try{
            con2=conectar2.getConnection();
            ps2=con2.prepareStatement(sql);
            rs2=ps2.executeQuery();
            while (rs2.next()) {
                Cliente c=new Cliente();
                c.setIdc(rs2.getInt(1));
                c.setNbr(rs2.getString(2));
                c.setEad(rs2.getString(3));
                c.setSf(rs2.getString(4));
                datos.add(c);
            }
        }catch (Exception e){
        }
        return datos;
    }
    
    public int Agregar(Cliente c){
        String sql="insert into cliente(Nombre,Edad,SaborFav) values(?,?,?)";
        try{
            con2=conectar2.getConnection();
            ps2=con2.prepareStatement(sql);
            ps2.setString(1, c.getNbr());
            ps2.setString(2, c.getEad());
            ps2.setString(3, c.getSf());
            ps2.executeUpdate();
        }catch (Exception e){
        }
        return 1;
    }
    
    public int Actualizar(Cliente c){
        int r=0;
        String sql="update cliente set Nombre=?, Edad=?, SaborFav=? where IDcliente=?";
        try{
            con2=conectar2.getConnection();
            ps2=con2.prepareStatement(sql);
            ps2.setString(1,c.getNbr());
            ps2.setString(2,c.getEad());
            ps2.setString(3,c.getSf());
            ps2.setInt(4, c.getIdc());
            r=ps2.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
        }
        return r;
    }
    
    public void delete(int cid){
        String sql="delete from cliente where IDcliente="+cid;
        try{
            con2=conectar2.getConnection();
            ps2=con2.prepareStatement(sql);
            ps2.executeUpdate();
        }catch (Exception e){
        }
    }
}