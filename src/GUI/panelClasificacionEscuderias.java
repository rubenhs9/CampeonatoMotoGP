
package GUI;

import data.Campeonato;
import data.Escuderia;
import data.Pais;
import data.Piloto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class panelClasificacionEscuderias extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
    
    public panelClasificacionEscuderias(JPanel panelPrincipal, JPanel panelOpciones, Campeonato campeonato, Color colorPrimario) {
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
                panelPrincipal.remove(panelClasificacionEscuderias.this);
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
        panelClasificacion.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuración de las cabeceras (fila 0)
        String[] cabeceras = {"Posición", "País", "Nombre", "Moto", "Puntos"};
        for (int i = 0; i < cabeceras.length; i++) {
            JLabel label = new JLabel(cabeceras[i], JLabel.CENTER);
            label.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 30));
            label.setBackground(colorPrimario);
            label.setOpaque(true);
            label.setForeground(Color.white);

            // Establecer una altura específica para la cabecera
            label.setPreferredSize(new java.awt.Dimension(label.getPreferredSize().width, 40));

            gbc.gridx = i; // Columna
            gbc.gridy = 0; // Fila 0
            gbc.weightx = 1.0; // Distribuir columnas uniformemente
            gbc.fill = GridBagConstraints.HORIZONTAL; // Llenar horizontalmente
            panelClasificacion.add(label, gbc);
        }

        // Obtener y ordenar las escuderías por puntos (de mayor a menor)
        ArrayList<Escuderia> escuderiasList = new ArrayList<>(campeonato.getEscuderias());
        escuderiasList.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));

        // Llenar los datos de la clasificación
        int posicion = 1;
        int fila = 1; // Iniciar desde la fila 1 para los datos
        for (Escuderia escuderia : escuderiasList) {
            gbc.gridy = fila++; // Incrementar la fila

            // Posición
            gbc.gridx = 0;
            panelClasificacion.add(crearLabelPosicion(String.valueOf(posicion++)), gbc);

            // País
            gbc.gridx = 1;
            panelClasificacion.add(crearLabelPais(escuderia.getPais().name()), gbc);

            // Nombre
            gbc.gridx = 2;
            panelClasificacion.add(crearLabel(escuderia.getNombre()), gbc);

            // Moto (sacada del primer piloto)
            gbc.gridx = 3;
            if (!escuderia.getPilotos().isEmpty()) {
                Piloto primerPiloto = escuderia.getPilotos().get(0);
                String motoInfo = primerPiloto.getMoto().getMarca() + " " + primerPiloto.getMoto().getModelo();
                panelClasificacion.add(crearLabel(motoInfo), gbc);
            } else {
                panelClasificacion.add(crearLabel("N/A"), gbc);
            }

            // Puntos
            gbc.gridx = 4;
            panelClasificacion.add(crearLabel(String.valueOf(escuderia.getPuntos())), gbc);
        }

        // Crear un JScrollPane para contener el panel de clasificación
        JScrollPane scrollPane = new JScrollPane(panelClasificacion);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Añadir el JScrollPane al contenedor principal
        this.add(scrollPane, BorderLayout.CENTER);
    }

    //Método específico para la columna de "Posición", ajustando el tamaño
    private JLabel crearLabelPosicion(String texto) {
        JLabel label = new JLabel(texto, JLabel.CENTER);
        label.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 20));
         // Crear el borde superior e inferior con LineBorder
        LineBorder bordeSuperiorInferior = new LineBorder(Color.BLACK, 2, true);
        // Crear un borde vacío a los lados izquierdo y derecho (sin borde)
        EmptyBorder bordeIzquierdaDerecha = new EmptyBorder(5, 10, 5, 10);  // 10px en izquierda y derecha
        // Combinar el borde superior/inferior con el borde vacío de los lados
        CompoundBorder compoundBorder = new CompoundBorder(bordeIzquierdaDerecha, bordeSuperiorInferior);
        label.setBorder(compoundBorder);  // Establecer el borde combinado
//        label.setBackground(new Color(0, 0, 0, 50));  // Fondo semitransparente
        label.setOpaque(true);

        label.setPreferredSize(new java.awt.Dimension(20, label.getPreferredSize().height)); // 50 es el ancho adecuado

        return label;
    }
    
    //METODO PARA CREAR EL LABEL CON EL PAIS
    private JLabel crearLabelPais(String texto) {
        JLabel label = new JLabel();

        // Buscar la imagen según el país
        String rutaImagen = Pais.valueOf(texto).getRutaImagen();
        ImageIcon iconoPais = new ImageIcon(rutaImagen);

        // Escalar la imagen para que tenga un tamaño adecuado
        Image imagenEscalada = iconoPais.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(imagenEscalada)); // Establecer la imagen del país

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.BLACK);
        

        return label;
    }
    
    //Método para crear un JLabel con el texto centrado y con fondo transparente
    private JLabel crearLabel(String texto) {
        JLabel label = new JLabel(texto, JLabel.CENTER);
        label.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,20));
        // Crear el borde superior e inferior con LineBorder
        LineBorder bordeSuperiorInferior = new LineBorder(Color.BLACK, 2, true);
        // Crear un borde vacío a los lados izquierdo y derecho (sin borde)
        EmptyBorder bordeIzquierdaDerecha = new EmptyBorder(5, 10, 5, 10);  // 10px en izquierda y derecha
        // Combinar el borde superior/inferior con el borde vacío de los lados
        CompoundBorder compoundBorder = new CompoundBorder(bordeIzquierdaDerecha, bordeSuperiorInferior);
        label.setBorder(compoundBorder);  // Establecer el borde combinado
//        label.setBackground(new Color(0, 0, 0, 50));  // Fondo semitransparente
        label.setOpaque(true);
        return label;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
