package datos;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import modelo.*;


public class ClienteDAO {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;

    public boolean registrarCliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTES (DNI, NOMBRE, TELEFONO, DIRECCION, RAZON_SOCIAL) VALUES (?,?,?,?,?)";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setLong(1, cliente.getDni());
            pst.setString(2, cliente.getNombre());
            pst.setLong(3, cliente.getTelefono());
            pst.setString(4, cliente.getDireccion());
            pst.setString(5, cliente.getRazonSocial());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cliente en ClienteDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }
    }

    public List listarClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTES";

        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("ID"));
                cliente.setDni(rs.getLong("DNI"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setTelefono(rs.getLong("TELEFONO"));
                cliente.setDireccion(rs.getString("DIRECCION"));
                cliente.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes en ClienteDAO " + e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ClienteDAO " + e.toString());
            }
        }
        return listaClientes;
    }

    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM CLIENTES WHERE ID = ?";

        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error el eliminar cliente en ClienteDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ClienteDAO " + e.toString());
            }
        }
    }

    public boolean modificarCliente(Cliente cliente) {
        String sql = "UPDATE CLIENTES SET DNI = ?, NOMBRE = ?, TELEFONO = ?, DIRECCION = ?, RAZON_SOCIAL = ? WHERE ID = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setLong(1, cliente.getDni());
            pst.setString(2, cliente.getNombre());
            pst.setLong(3, cliente.getTelefono());
            pst.setString(4, cliente.getDireccion());
            pst.setString(5, cliente.getRazonSocial());
            pst.setInt(6, cliente.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error el modificar cliente en ClienteDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ClienteDAO " + e.toString());
            }
        }
    }

    public Cliente buscarCliente(int dni) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM CLIENTES WHERE DNI = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, dni);
            rs = pst.executeQuery();
            if (rs.next()) {
                cliente.setDni(rs.getLong("DNI"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setTelefono(rs.getLong("TELEFONO"));
                cliente.setDireccion(rs.getString("DIRECCION"));
                cliente.setRazonSocial(rs.getString("RAZON_SOCIAL"));
            }
        } catch (SQLException e) {
            System.err.println("Error el consultar cliente en ClienteDAO " + e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ClienteDAO " + e.toString());
            }
        }
        return cliente;
    }
}
