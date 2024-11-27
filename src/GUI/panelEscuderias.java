
package GUI;

import data.Campeonato;
import data.Escuderia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class panelEscuderias extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
    private int alturaImg = 125;
    private int anchoImg = 370;
    
    public panelEscuderias(JPanel panelPrincipal, JPanel panelOpciones, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpciones = panelOpciones;
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
        
        botonVolverAtras();
        minitComponents();
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
                panelPrincipal.remove(panelEscuderias.this);
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
    
    private void minitComponents() {
    //Crear un panel con FlowLayout centrado
    JPanel panelContenido = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
//    panelContenido.setBackground(Color.WHITE);

    //Agregar un JScrollPane que envuelve al panelContenido
    JScrollPane scrollPane = new JScrollPane(panelContenido);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setBorder(null);

    //Agregar el JScrollPane al contenedor principal
    this.add(scrollPane, BorderLayout.CENTER);

    //Crear un JLabel para cada escudería
    for (Escuderia escuderia : campeonato.getEscuderias()) {
        JLabel labelEscuderia = new JLabel();
        labelEscuderia.setPreferredSize(new Dimension(anchoImg, alturaImg));
        labelEscuderia.setHorizontalAlignment(SwingConstants.CENTER);
        labelEscuderia.setOpaque(true);
        ajustarImagenEnLabel(labelEscuderia, escuderia.getImagen());
        labelEscuderia.setBackground(colorPrimario);
        labelEscuderia.setForeground(Color.WHITE);
        labelEscuderia.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        panelContenido.add(labelEscuderia);
    }
    
    //Ajustar el tamaño del panel después de que la ventana sea visible
    SwingUtilities.invokeLater(() -> ajustarTamañoPanel(panelContenido, scrollPane));
}

    private void ajustarTamañoPanel(JPanel panelContenido, JScrollPane scrollPane) {
    // Obtener el ancho real del viewport
    int anchoDisponible = scrollPane.getViewport().getWidth();

    if (anchoDisponible <= 0) {
        // Si el ancho no es válido aún, programar un ajuste posterior
        SwingUtilities.invokeLater(() -> ajustarTamañoPanel(panelContenido, scrollPane));
        return;
    }

    // Calcular cuántos elementos caben por fila
    int elementosPorFila = Math.max(1, (anchoDisponible + 10) / (anchoImg + 10));
    int filasNecesarias = (int) Math.ceil((double) panelContenido.getComponentCount() / elementosPorFila);

    // Calcular la altura total
    int alturaTotal = filasNecesarias * (alturaImg + 10);

    // Ajustar las dimensiones preferidas del panel
    panelContenido.setPreferredSize(new Dimension(anchoDisponible, alturaTotal));

    // Forzar el rediseño y repintado
    panelContenido.revalidate();
    panelContenido.repaint();
}

    
    private void ajustarImagenEnLabel(JLabel label, String rutaImagen) {
        try {
            //Cargar la imagen desde la ruta
            ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
            Image imagenOriginal = iconoOriginal.getImage();

            //Dimensiones fijas del JLabel
            int alturaLabel = alturaImg; //Altura fija
            int anchoEscalado = (int) (imagenOriginal.getWidth(null) * ((double) alturaLabel / imagenOriginal.getHeight(null)));

            //Escalamos la imagen al tamaño deseado
            Image imagenEscalada = imagenOriginal.getScaledInstance(anchoEscalado, alturaLabel, Image.SCALE_SMOOTH);

            label.setIcon(new ImageIcon(imagenEscalada));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la imagen: " + rutaImagen);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
