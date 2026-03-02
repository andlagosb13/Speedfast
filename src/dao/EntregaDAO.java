package dao;

import modelo.Pedido;
import modelo.Repartidor;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    public void guardarEntrega(int idPedido, int idRepartidor) {
        String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPedido);
            ps.setInt(2, idRepartidor);
            ps.setDate(3, Date.valueOf(LocalDate.now())); // Fecha actual
            ps.setTime(4, Time.valueOf(LocalTime.now())); // Hora actual

            ps.executeUpdate();
            System.out.println("Relacion de entrega registrada en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al registrar la entrega: " + e.getMessage());
        }

    }

    public List<Object[]> listarEntregas() throws SQLException {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT * e.id, p.direccion, r.nombre, e.fecha, e.hora " +
                "FROM entrega e JOIN pedido p ON e.id_pedido = p.id " +
                "JOIN repartidor r ON e.id_repartidor = r.id";
        try (Connection con = ConexionDB.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getTime(5)});

            }

            }catch (SQLException e){
            System.err.println("Error al listar entregas; " + e.getMessage());
        }
            return lista;
        }
    }

