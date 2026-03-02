package vista;

import dao.PedidoDAO;
import controlador.GestionPedidos;
import modelo.*; // importa pedido y subclases
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroPedido extends JFrame {
    private GestionPedidos controlador;
    private JTextField txtId, txtDireccion, txtExtra;
    private JComboBox<String> cbTipo;
    private PedidoDAO pedidoDAO;

    public VentanaRegistroPedido(GestionPedidos controlador) {
        this.controlador = controlador;
        this.pedidoDAO = new PedidoDAO();  // inicializamos el dao

        setTitle("Registrar Nuevo Pedido - SpeedFast");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 10, 10));
        setLocationRelativeTo(null);

        // componente del formulario
        add(new JLabel("ID Pedido (Opcional):"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Direccion:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Dato Extra (Numero):"));
        txtExtra = new JTextField();
        add(txtExtra);

        add(new JLabel("Tipo de Pedido:"));
        cbTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "express"});
        add(cbTipo);

        JButton btnGuardar = new JButton("Guardar en BD");
        add(btnGuardar);

        // Logica del boton Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPedido();
            }
        });
    }

    private void guardarPedido() {
        // Validar campos
        if (txtId.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtExtra.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        try {
            int id = txtId.getText().isEmpty() ? 0 : Integer.parseInt(txtId.getText());
            String direccion = txtDireccion.getText();
            double valorExtra = Double.parseDouble(txtExtra.getText());
            String tipoSeleccionado = (String) cbTipo.getSelectedItem();

            Pedido nuevoPedido = null;

            // Crear el pedido segun el tipo seleccionado
            switch (tipoSeleccionado) {
                case "Comida":
                    nuevoPedido = new PedidoComida(id, direccion, valorExtra);
                    break;
                case "Encomienda":
                    nuevoPedido = new PedidoEncomienda(id, direccion, valorExtra);
                    break;
                case "express":
                    nuevoPedido = new PedidoExpress(id, direccion, valorExtra);
                    break;
            }

            // agregar al controlador
            if (nuevoPedido != null) {

                pedidoDAO.guardar(nuevoPedido);

                controlador.registrarPedido(nuevoPedido);
                // Confirmacion
                JOptionPane.showMessageDialog(this, "Pedido registrado exitosamente en la BAse de Datos.");
                dispose(); // cerrar la ventana despues de guardar
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser un numero entero.");
        }
    }
}
