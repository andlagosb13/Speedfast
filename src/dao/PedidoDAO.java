package dao;

import modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {


    public void guardar(Pedido pedido){
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";

        // Try-with-resources para cerrar la conexion automaticamente
        try (Connection con = ConexionDB.conectar();
        PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, pedido.getDireccionEntrega());
            // Obtenemos el tipo (comida, Encomienda, etc.) de la clase
            ps.setString(2, pedido.getClass().getSimpleName().replace("Pedido", "").toUpperCase());
            ps.setString(3, pedido.getEstado().toString());

            ps.executeUpdate();
            System.out.println("Pedido guardado en la base de datos.");

        } catch (SQLException e){
            System.err.println("Error al guardar pedido: " + e.getMessage());
        }
    }

    public List<Object[]> listarParaTabla(){
        List<Object[]>lista = new ArrayList<>();
        String sql = "SELECT id, direccion, tipo, estado FROM pedido";

        try (Connection con = ConexionDB.conectar();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Object[]fila ={
                        rs.getInt("id"),
                        rs.getString("direccion"),
                        rs.getString("tipo"),
                        rs.getString("estado")
                };
                lista.add(fila);
            }
        }catch (SQLException e){
            System.err.println("Error al listar pedidos; " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(int id, String direccion, String estado){
        String sql = "UPDATE pedidos SET direccion = ?, estado = ? WHERE id = ?";
        try (Connection con = ConexionDB.conectar();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, direccion);
            ps.setString(2, estado);
            ps.setInt(3, id);
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al actualizar pedido: " + e.getMessage());
        }
    }
    // DELETE: Eliminar pedido
    public void eliminar(int id){
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (Connection con = ConexionDB.conectar();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            System.err.println("Error al eliminar pedido: " + e.getMessage());
        }
    }
}
