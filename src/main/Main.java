package main;

import controlador.GestionPedidos;
import vista.VentanaRegistroPedido;
import vista.VentanaListaPedidos;
import vista.VentanaAsignarEntrega;
import dao.ConexionDB;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Main{
    public static void main(String[]args){
        try (Connection testCon = ConexionDB.conectar()) {
            System.out.println("Conexión a MySQL exitosa. Iniciando interfaz...");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + e.getMessage());
            System.exit(1);
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception ignored){}

        GestionPedidos controlador = new GestionPedidos();
        JFrame framePrincipal = new JFrame("Sistema de Gestion SpeedFast - DB Edition ");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(450, 400);
        framePrincipal.setLayout(new GridLayout(4, 1, 10, 10));
        framePrincipal.setLocationRelativeTo(null);

        // Creación de botones para la interfaz principal
        JButton btnAbrirRegistro = new JButton("Registrar Nuevo Pedido (MySQL)");
        JButton btnVerPedidos = new JButton("Ver listado de Pedidos");
        JButton btnAsignarEntrega = new JButton("Asignar Pedido a Repartidor");
        JButton btnSalir = new JButton("Cerrar Aplicación");

        btnAbrirRegistro.addActionListener(e ->{
            VentanaRegistroPedido vRegistro = new VentanaRegistroPedido(controlador);
            vRegistro.setVisible(true);
        });

        btnVerPedidos.addActionListener(e ->{
            VentanaListaPedidos vLista = new VentanaListaPedidos(controlador);
            vLista.setVisible(true);
        });

        btnAsignarEntrega.addActionListener(e ->{
            VentanaAsignarEntrega vAsignar = new VentanaAsignarEntrega();
            vAsignar.setVisible(true);
        });

        btnSalir.addActionListener(e->{
            System.out.println("Cerrando sistema...");
            System.exit(0);
        });

        framePrincipal.add(btnAbrirRegistro);
        framePrincipal.add(btnVerPedidos);
        framePrincipal.add(btnAsignarEntrega);
        framePrincipal.add(btnSalir);

        SwingUtilities.invokeLater(() ->{
            framePrincipal.setVisible(true);
        });

        System.out.println("Sistema SpeedFast iniciado correctamente con soporte JDBC.");

    }
}