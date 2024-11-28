
package GUI;

import data.Campeonato;
import data.Escuderia;
import data.Piloto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class panelClasificacionPilotos extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
    
    public panelClasificacionPilotos(JPanel panelPrincipal, JPanel panelOpciones, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpciones = panelOpciones;
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());

        botonVolverAtras();
        minitComponents();
    }

    private void botonVolverAtras(){
        //CREAMOS EL PANEL DE ARRIBA DONDE ESTARA EL BOTON DE VOLVER
        JPanel panelIrHaciaAtras = new JPanel();
        panelIrHaciaAtras.setLayout(new FlowLayout(FlowLayout.LEFT));
        //BOTON PARA VOLVER ATRAS
        JLabel volverAtras = new JLabel();
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(new EmptyBorder(0,10,0,10));
        volverAtras.setFont(new Font("Microsoft YaHei UI",Font.BOLD,25));
        volverAtras.setText("VOLVER");
        volverAtras.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelClasificacionPilotos.this);
                panelPrincipal.add(panelOpciones);
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                volverAtras.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                volverAtras.setBackground(colorPrimario);
            }
        });
        panelIrHaciaAtras.add(volverAtras);
        this.add(panelIrHaciaAtras, BorderLayout.NORTH);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void minitComponents() {
        // Crear un panel para la tabla de clasificación
        JPanel panelClasificacion = new JPanel();
        panelClasificacion.setLayout(new GridBagLayout());  // Usar GridBagLayout para un control más preciso
        GridBagConstraints gbc = new GridBagConstraints();

        //Configuración de las cabeceras (fila 0)
        String[] cabeceras = {"Posición", "País", "Nombre", "Escudería", "Moto", "Puntos"};
        for (int i = 0; i < cabeceras.length; i++) {
            JLabel label = new JLabel(cabeceras[i], JLabel.CENTER);
            label.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 30));
            label.setBackground(colorPrimario);
            label.setOpaque(true);
            label.setForeground(Color.white);

            //Establecer una altura específica para la cabecera
            label.setPreferredSize(new java.awt.Dimension(label.getPreferredSize().width, 40));  // 40 es el alto de la celda

            gbc.gridx = i;  //Establecer la columna para la cabecera
            gbc.gridy = 0;  //Fila 0 para la cabecera
            gbc.weightx = 1.0; // Hacer que las columnas se distribuyan uniformemente
            gbc.fill = GridBagConstraints.HORIZONTAL;  //Llenar la celda horizontalmente
            panelClasificacion.add(label, gbc);
        }

        //Crear una lista para almacenar todos los pilotos
        ArrayList<Piloto> pilotosList = new ArrayList<>();

        // ecoger todos los pilotos de las escuderías en la lista
        for (Escuderia escuderia : campeonato.getEscuderias()) {
            for (Piloto piloto : escuderia.getPilotos()) {
                pilotosList.add(piloto);
            }
        }

        //Ordenar la lista de pilotos por puntos (de mayor a menor)
        Collections.sort(pilotosList, new Comparator<Piloto>() {
            @Override
            public int compare(Piloto p1, Piloto p2) {
                return Integer.compare(p2.getPuntos(), p1.getPuntos());  // De mayor a menor
            }
        });

        //Llenar los datos de la clasificación con la lista ordenada
        int posicion = 1;
        int fila = 1;  //Iniciar desde la fila 1 para los datos
        for (Piloto piloto : pilotosList) {
            gbc.gridy = fila++;  // Incrementar la fila por cada piloto

            gbc.gridx = 0;  //Posición (columna 0)
            panelClasificacion.add(crearLabelPosicion(String.valueOf(posicion++)), gbc);  // Posición

            gbc.gridx = 1;  //País (columna 1)
            panelClasificacion.add(crearLabel(piloto.getPais()), gbc);

            gbc.gridx = 2;  //Nombre (columna 2)
            panelClasificacion.add(crearLabel(piloto.getNombre()), gbc);

            gbc.gridx = 3;  //Escudería (columna 3)
            panelClasificacion.add(crearLabel(piloto.getEscuderia()), gbc);

            gbc.gridx = 4;  //Moto (columna 4)
            panelClasificacion.add(crearLabel(piloto.getMoto().getMarca() + " " + piloto.getMoto().getModelo()), gbc);

            gbc.gridx = 5;  //Puntos (columna 5)
            panelClasificacion.add(crearLabel(String.valueOf(piloto.getPuntos())), gbc);
        }

        //Crear un JScrollPane que contenga el panelClasificacion
        JScrollPane scrollPane = new JScrollPane(panelClasificacion);

        //Configurar el JScrollPane para que tenga barras de desplazamiento cuando sea necesario
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //Añadir el JScrollPane al contenedor principal
        this.add(scrollPane, BorderLayout.CENTER);
    }

    //Método específico para la columna de "Posición", ajustando el tamaño
    private JLabel crearLabelPosicion(String texto) {
        JLabel label = new JLabel(texto, JLabel.CENTER);
        label.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 20));
        label.setBorder(new EmptyBorder(5, 10, 5, 10));
        label.setBackground(new Color(0, 0, 0, 50));  // Fondo semitransparente
        label.setOpaque(true);

        label.setPreferredSize(new java.awt.Dimension(20, label.getPreferredSize().height)); // 50 es el ancho adecuado

        return label;
    }
    
    //Método para crear un JLabel con el texto centrado y con fondo transparente
    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto, JLabel.CENTER);
        label.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,20));
        label.setBorder(new EmptyBorder(5, 10, 5, 10));
        label.setBackground(new Color(0, 0, 0, 50));  // Fondo semitransparente
        label.setOpaque(true);
        return label;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
