
package GUI;

import data.Campeonato;
import data.Escuderia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class panelOpcionesClasificacion extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
    private GridBagConstraints gbc;
    private Image backgroundImage;
   
    public panelOpcionesClasificacion(JPanel panelPrincipal, panelOpciones panelOpciones, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpciones = panelOpciones;
        this.campeonato = campeonato;
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
        volverAtras.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelOpcionesClasificacion.this);
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
        JPanel panelOps = new JPanel();
        panelOps.setOpaque(false);
        panelOps.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); //Espacio entre los botones
        gbc.anchor = GridBagConstraints.CENTER;   
        
        //Crear botones para las opciones del menú
        int widthBoton = 270;
        int heightBoton = 65;
        
        //PRIMER BOTON
        JLabelConSaltos primerBoton = new JLabelConSaltos("CLASIFICACIÓN\nDE PILOTOS");
        primerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        primerBoton.setBackground(colorPrimario);
        primerBoton.setOpaque(true);
        primerBoton.setForeground(Color.WHITE);
        primerBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 25));
        primerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        primerBoton.setVerticalAlignment(SwingConstants.CENTER);
//        primerBoton.setText("<html><div style='text-align: center;'>CLASIFICACIÓN<br>DE PILOTOS</div></html>");
        primerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  panelClasificacionPilotos panelClasificacionPilotos = new panelClasificacionPilotos(panelPrincipal, panelOpcionesClasificacion.this, campeonato, colorPrimario);
                  panelPrincipal.remove(panelOpcionesClasificacion.this);
                  panelPrincipal.add(panelClasificacionPilotos, BorderLayout.CENTER);
                  panelPrincipal.revalidate();
                  panelPrincipal.repaint();
                  primerBoton.setBackground(colorPrimario);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                primerBoton.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                primerBoton.setBackground(colorPrimario);
            }
        });
        gbc.gridy = 0; //Ubicamos los botones en la misma fila
        gbc.gridx = 0; //Columna 1
        panelOps.add(primerBoton, gbc);
        
        
        //SEGUNDO BOTON
        JLabelConSaltos segundoBoton = new JLabelConSaltos("CLASIFICACIÓN\nDE ESCUDERIAS");
        segundoBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        segundoBoton.setBackground(colorPrimario);
        segundoBoton.setOpaque(true);
//        segundoBoton.setText("<html><div style='text-align: center;'>CLASIFICACIÓN DE ESCUDERIAS</div></html>");
        segundoBoton.setForeground(Color.WHITE);
        segundoBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        segundoBoton.setHorizontalAlignment(SwingConstants.CENTER);
        segundoBoton.setVerticalAlignment(SwingConstants.CENTER);
        segundoBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //COMPROBAMOS QUE LAS ESCUDERIAS ESTEN LLENAS ANTES DE PODER MOSTRARLAS
                boolean escuderiasLlenas = true;
                for (Escuderia escuderia : campeonato.getEscuderias()) {
                    if (escuderia.getPilotos().size() != 2) {
                        escuderiasLlenas = false;
                    }
                }
                
                if (escuderiasLlenas) {
                    panelClasificacionEscuderias panelClasificacionEscuderias = new panelClasificacionEscuderias(panelPrincipal, panelOpcionesClasificacion.this, campeonato, colorPrimario);
                    panelPrincipal.remove(panelOpcionesClasificacion.this);
                    panelPrincipal.add(panelClasificacionEscuderias, BorderLayout.CENTER);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();
                    segundoBoton.setBackground(colorPrimario);
                }else{
                    JOptionPane.showMessageDialog(panelOpciones, "ERROR, TODAS LAS ESCUDERIAS DEBEN ESTAR COMPLETAS", "ERROR", 0);
                }
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                segundoBoton.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                segundoBoton.setBackground(colorPrimario);
            }
        });
        gbc.gridx = 1;
        panelOps.add(segundoBoton, gbc);
        
        this.add(panelOps, BorderLayout.CENTER);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
