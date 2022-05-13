package pe.edu.upeu.ws001.daoImpl;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import pe.edu.upeu.ws001.config.Conexion;
import pe.edu.upeu.ws001.dao.RolDao;
import pe.edu.upeu.ws001.model.Rol;

/**
 *
 * @author CAMPOS
 */
public class RolDaoImpl implements RolDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Rol rol) {
        String SQL = "INSERT INTO rol(nombre) VALUES(?)";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int update(Rol rol) {
        String SQL = "UPDATE rol SET nombre=? WHERE idrol=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getIdrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
      String SQL = "DELETE FROM rol WHERE idrol=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;  
    }

    @Override
    public Rol read(int id) {
        String SQL = "SELECT *FROM rol WHERE idrol=?";
        Rol rol = new Rol();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, rol.getIdrol());
            rs = ps.executeQuery();
            while(rs.next()){
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return rol;
    }

    @Override
    public List<Rol> readAll() {
        String SQL = "SELECT *FROM rol";
        List<Rol> lista = new ArrayList<>();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol rol = new Rol();
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }
    
}