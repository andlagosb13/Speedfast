package dao;

import modelo.Repartidor;
import modelo.ZonaDeCarga;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public void registrar(String nombre){
        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.executeUpdate();
            System.out.println("Repartidor registrado en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al registrar repartidor: " + e.getMessage());
        }
    }


    public List<Repartidor> listarTodos() {
        List<Repartidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM repartidor";

        try (Connection con = ConexionDB.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                Repartidor r = new Repartidor(nombre, new ZonaDeCarga());
                lista.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar repartidores; " + e.getMessage());
        }
        return lista;
    }

    public void eliminar(int id){
        String sql = "DELETE FROM repartidor WHERE id = ?";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Repartidor eliminado de la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al eliminar repartidor: " + e.getMessage());
        }
    }

    public List<Object[]> listarPAraCombo(){
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM repartidor";

        try (Connection con = ConexionDB.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = {rs.getInt("id"), rs.getString("nombre")};
                lista.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar repartidores para combo; " + e.getMessage());
        }
        return lista;
    }
}