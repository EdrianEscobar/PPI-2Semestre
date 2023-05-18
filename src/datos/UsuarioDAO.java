package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Usuario;

public class UsuarioDAO {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;

    
    public List listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setCorreo(rs.getString("CORREO"));
                usuario.setRol(rs.getString("ROL"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios en UsuarioDAO " + e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en UsuarioDAO " + e.toString());
            }
        }
        return listaUsuarios;
    }

    public boolean modificarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIO SET NOMBRE = ?, CORREO = ?, password = ? WHERE ID = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getCorreo());
            pst.setString(3, usuario.getPassword());
            pst.setInt(4, usuario.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error el modificar usuario en UsuarioDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en UsuarioDAO " + e.toString());
            }
        }
    }
    
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM USUARIO WHERE ID = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error el eliminar usuario en UsuarioDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en UsuarioDAO " + e.toString());
            }
        }
    }
}
