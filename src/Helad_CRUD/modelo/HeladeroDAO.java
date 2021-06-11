package Helad_CRUD.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HeladeroDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Heladero>datos=new ArrayList<>();
        String sql="select * from heladero";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Heladero h=new Heladero();
                h.setId(rs.getInt(1));
                h.setNom(rs.getString(2));
                h.setEd(rs.getString(3));
                h.setTrn(rs.getString(4));
                datos.add(h);
            }
        }catch (Exception e){
        }
        return datos;
    }
    
    public int Agregar(Heladero h){
        String sql="insert into heladero(Nombre,Edad,Turno) values(?,?,?)";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, h.getNom());
            ps.setString(2, h.getEd());
            ps.setString(3, h.getTrn());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return 1;
    }
    
    public int Actualizar(Heladero h){
        int r=0;
        String sql="update heladero set Nombre=?, Edad=?, Turno=? where IDheladero=?";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,h.getNom());
            ps.setString(2,h.getEd());
            ps.setString(3,h.getTrn());
            ps.setInt(4, h.getId());
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from heladero where IDheladero="+id;
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
        }
    }
}