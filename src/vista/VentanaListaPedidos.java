package vista;

import dao.PedidoDAO;
import controlador.GestionPedidos;
import modelo.Pedido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame{
    private GestionPedidos controlador;
    private JTable tablaPedidos;
    private DefaultTableModel modeloTabla;
    private PedidoDAO pedidoDAO;

    public VentanaListaPedidos(GestionPedidos controlador){
        this.controlador = controlador;
        this.pedidoDAO = new PedidoDAO();

        setTitle("Listado de Pedidos - SpeedFast");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Configuracion de la tabla
        String[] columnas = {"ID", "Direccion", "Tipo", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPedidos = new JTable(modeloTabla);

        // Cargar datos iniciales
        cargarDatos();  // Ahora cargara desde MySQL

        // Agregar la tabla a un panel con scroll
        add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);

        // Boton para refrescar
        JButton btnRefrescar = new JButton("Actualizar desde MySQL");
        btnRefrescar.addActionListener(e -> cargarDatos());
        add(btnRefrescar, BorderLayout.SOUTH);
    }

    private void cargarDatos(){
        // Limpiar tabla antes de recargar
        modeloTabla.setRowCount(0);

        List<Object[]> pedidosDB = pedidoDAO.listarParaTabla();

        for (Object[] fila : pedidosDB){
            modeloTabla.addRow(fila);
        }
    }
}
