package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.GestionPedidos;

public class VentanaPrincipal extends JFrame {
    private GestionPedidos controlador;

    public VentanaPrincipal(GestionPedidos controlador) {
        this.controlador = controlador;

        // Configuracion basica de la ventana
        setTitle("SpeedFast - Gestion de Entregas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar el layout
        // 3 Filas (botones), 1 columna, 10px de espacio horizontal y vertical
        setLayout(new GridLayout(3, 1, 15, 15));

        // crear componentes
        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        // --- EVENTOS DE NAVEGACION ---

        // Abrir Ventana de Registro
        btnRegistrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaRegistroPedido vRegistro = new VentanaRegistroPedido(controlador);
                vRegistro.setVisible(true);
            }
        });

        // Abrir Ventana de Listado
        btnListar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaListaPedidos vLista = new VentanaListaPedidos(controlador);
                vLista.setVisible(true);
            }
        });

        // Logica de Asignacion Automatica
        btnAsignar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Llamamos al metodo que crearemos en el controlador
                String mensaje = controlador.asignarProximoPedido();
                JOptionPane.showMessageDialog(VentanaPrincipal.this, mensaje);
            }
        });

        // agregar botones a la ventana
        add(btnRegistrar);
        add(btnListar);
        add(btnAsignar);
    }

}
