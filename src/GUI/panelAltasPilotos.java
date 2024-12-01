
package GUI;

import data.Campeonato;
import data.Escuderia;
import data.Piloto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class panelAltasPilotos extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelAnterior;
    private Campeonato campeonato;
    private Escuderia escuderiaSeleccionada;
    
    private int alturaImg = 125;
    private int anchoImg = 370;
    private Image backgroundImage;
    
    private List<Piloto> pilotosSeleccionados = new ArrayList<Piloto>();
    
    
    public panelAltasPilotos(JPanel panelPrincipal, JPanel panelAnterior, Campeonato campeonato, Escuderia escuderia,Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelAnterior = panelAnterior;
        this.campeonato = campeonato;
        this.escuderiaSeleccionada = escuderia;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
        ImageIcon imagen = new ImageIcon(campeonato.getBackground());
        backgroundImage = imagen.getImage();
        
        botonVolverAtras();
        minitComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Dibujo la imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, panelPrincipal.getWidth(), panelPrincipal.getHeight(), this);
        }else{
            System.out.println("No se encontro la imagen");
        }
    }
    
    private void botonVolverAtras(){
        //CREAMOS EL PANEL DE ARRIBA DONDE ESTARA EL BOTON DE VOLVER
        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.setOpaque(false);
        JPanel panelIrHaciaAtras = new JPanel();
        panelIrHaciaAtras.setOpaque(false);
        panelIrHaciaAtras.setLayout(new FlowLayout(FlowLayout.LEFT));
        //BOTON PARA VOLVER ATRAS
        JLabel volverAtras = new JLabel();
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(new EmptyBorder(0,10,0,10));
        volverAtras.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        volverAtras.setText("VOLVER");
        volverAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelAltasPilotos.this);
                panelPrincipal.add(panelAnterior);
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
        panelInfo.add(panelIrHaciaAtras, BorderLayout.WEST);
        
        //CREAMOS EL Label QUE INIDICARA QUE ESTAMOS HACIENDO
        JLabel labelInfo = new JLabel();
        labelInfo.setText("SELECCIONA LOS DOS PILOTOS DE ESTA ESCUDERIA                   ");
        labelInfo.setForeground(Color.WHITE);
        labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
        labelInfo.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        panelInfo.add(labelInfo,BorderLayout.CENTER);
        
        this.add(panelInfo, BorderLayout.NORTH);
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
        //Crear un panel con FlowLayout centrado
        JPanel panelContenido = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelContenido.setOpaque(false);

        //Agregar un JScrollPane que envuelve al panelContenido
        JScrollPane scrollPane = new JScrollPane(panelContenido);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); 
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //Agregar el JScrollPane al contenedor principal
        this.add(scrollPane, BorderLayout.CENTER);

        //Crear un JLabel para cada escudería
        for (Piloto piloto : campeonato.getPilotos()) {
            JLabel labelEscuderia = new JLabel();
            labelEscuderia.setPreferredSize(new Dimension(anchoImg, alturaImg));
            labelEscuderia.setHorizontalAlignment(SwingConstants.CENTER);
            labelEscuderia.setOpaque(true);
            ajustarImagenEnLabel(labelEscuderia, piloto.getRutaImagenPiloto());
            labelEscuderia.setBackground(new Color(255,255,255,150));
            labelEscuderia.setForeground(Color.WHITE);
            labelEscuderia.setBorder(new LineBorder(Color.BLACK,3,false));
            labelEscuderia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                    if (!pilotosSeleccionados.isEmpty()) {
                        //COMPROBAR QUE NO HAYAMOS SELECCIONADO EL MISMO PILOTO 2 VECES
                        if (pilotosSeleccionados.get(0).getNombre().compareTo(piloto.getNombre()) == 0) {
                            JOptionPane.showMessageDialog(panelAnterior, "ERROR, NO PUEDES AÑADIR EL MISMO PILOTO 2 VECES" 
                                    , "ERROR", 0);
                            
                        }else{
                            labelEscuderia.setBackground(Color.RED);
                            pilotosSeleccionados.add(piloto);
                            if (pilotosSeleccionados.size() == 2) {
                                //QUITAMOS LOS PILOTOS QUE HAYA EN ESA ESCUDERIA SI LOS HAY
                                escuderiaSeleccionada.getPilotos().clear();
                                for (Piloto pilotosSeleccionado : pilotosSeleccionados) {
                                    //COMPROBAMOS QUE EL PILOTO, NO ESTÉ ES UNA ESCUDERIA MÁS, SI LO ESTÁ, ELIMINAMOS LOS PILOTOS DE LA ESCUDERIA EN LA QUE ESTABA
                                    for (Escuderia escuderia : campeonato.getEscuderias()) {
                                        Iterator<Piloto> iterator = escuderia.getPilotos().iterator();
                                        while (iterator.hasNext()) {
                                            Piloto piloto1 = iterator.next();
                                            if (piloto1.getNombre().compareTo(pilotosSeleccionado.getNombre()) == 0) {
                                                iterator.remove();
                                            }
                                        }
                                    }
                                    //AÑADIMOS A LOS PILOTOS
                                    escuderiaSeleccionada.addPiloto(pilotosSeleccionado);
                                }
                                //MOSTRAMOS EL MENSAJE DE CONFIRMACIÓN
                                JOptionPane.showMessageDialog(panelAnterior, "PILOTOS AÑADIDOS CORRECTAMENTE A LA ESCUDERIA: " 
                                        + escuderiaSeleccionada.getNombre(), "CAMBIOS CONFIRMADOS", 1);

                                //VOLVEMOS ATRAS
                                panelPrincipal.remove(panelAltasPilotos.this);
                                panelPrincipal.add(panelAnterior);
                                panelPrincipal.repaint();
                                panelPrincipal.revalidate();
                            }
                    }
                    }else{
                        labelEscuderia.setBackground(Color.RED);
                        pilotosSeleccionados.add(piloto);
                    }
                    
                    
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    labelEscuderia.setBorder(new LineBorder(Color.RED,3,false));
                    panelPrincipal.repaint();
                    panelPrincipal.revalidate();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labelEscuderia.setBorder(new LineBorder(Color.BLACK,3,false));
                    panelPrincipal.repaint();
                    panelPrincipal.revalidate();
                }
            });

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
//
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
