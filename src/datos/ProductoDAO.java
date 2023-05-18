package datos;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import modelo.*;


public class ProductoDAO {

    Connection cn;
    PreparedStatement pst;
    ResultSet rs;

    public boolean registrarProducto(Producto producto) {
        String sql = "INSERT INTO PRODUCTO (CODIGO, DESCRIPCION, PROVEEDOR, STOCK, PRECIO) VALUES (?,?,?,?,?)";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setString(1, producto.getCodigo());
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getProveedor());
            pst.setInt(4, producto.getStock());
            pst.setDouble(5, producto.getPrecio());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerras los objetos en ProductoDAO " + e.toString());
            }
        }
    }

    public void consultarProveedor(JComboBox proveedor) {
        String sql = "SELECT NOMBRE FROM PROVEEDOR";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                proveedor.addItem(rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar proveedores en ProductoDAO " + e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerras los objetos en ProductoDAO " + e.toString());
            }
        }
    }

    public List listarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTO";

        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("ID"));
                producto.setCodigo(rs.getString("CODIGO"));
                producto.setNombre(rs.getString("DESCRIPCION"));
                producto.setProveedor(rs.getString("PROVEEDOR"));
                producto.setStock(rs.getInt("STOCK"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                listaProductos.add(producto);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar los productos en ProductoDAO " + e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ProveedorDAO " + e.toString());
            }
        }

        return listaProductos;
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM PRODUCTO WHERE ID = ?";

        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error el eliminar producto en productoDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en productoDAO " + e.toString());
            }
        }
    }

    public boolean modificarProducto(Producto producto) {
        String sql = "UPDATE PRODUCTO SET CODIGO = ?, DESCRIPCION = ?, PROVEEDOR = ?, STOCK = ?, PRECIO = ? WHERE ID = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setString(1, producto.getCodigo());
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getProveedor());
            pst.setInt(4, producto.getStock());
            pst.setDouble(5, producto.getPrecio());
            pst.setInt(6, producto.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error el modificar producto en productoDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ProductoDAO " + e.toString());
            }
        }
    }

    public Producto buscarProducto(String codigoProducto) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM PRODUCTO WHERE CODIGO = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            rs = pst.executeQuery();
            if (rs.next()) {
                producto.setNombre(rs.getString("DESCRIPCION"));
                producto.setPrecio(rs.getDouble("PRECIO"));
                producto.setStock(rs.getInt("STOCK"));
            }
        } catch (SQLException e) {
            System.err.println("Error el buscar producto en productoDAO " + e.toString());
        } finally {
            try {
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en ProductoDAO " + e.toString());
            }
        }
        return producto;
    }

    public boolean actualizarStock(int cantidad, String codigoProducto) {
        String sql = "UPDATE PRODUCTO SET STOCK = ? WHERE CODIGO = ?";
        try {
            cn = Conexion.conectar();
            pst = cn.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setString(2, codigoProducto);
            pst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar Stock en VentaDAO " + e.toString());
            return false;
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los objetos en VentaDAO " + e.toString());
            }
        }
    }

}
