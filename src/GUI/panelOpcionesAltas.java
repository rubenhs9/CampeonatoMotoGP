
package GUI;

import data.Campeonato;
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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class panelOpcionesAltas extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
    private GridBagConstraints gbc;
    private Image backgroundImage;
    
    public panelOpcionesAltas(JPanel panelPrincipal, panelOpciones panelOpciones, Campeonato campeonato, Color colorPrimario) {
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
                panelPrincipal.remove(panelOpcionesAltas.this);
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
        JLabel primerBoton = new JLabel("ALTAS DE CIRCUITOS");
        primerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        primerBoton.setBackground(colorPrimario);
        primerBoton.setOpaque(true);
//        primerBoton.setText("<html><div style='text-align: center;'>ALTAS DE CIRCUITOS</div></html>");
        primerBoton.setForeground(Color.WHITE);
        primerBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        primerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        primerBoton.setVerticalAlignment(SwingConstants.CENTER);
        primerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    panelAltasCircuitos panelAltasCircuitos = new panelAltasCircuitos(panelPrincipal, panelOpcionesAltas.this, campeonato, colorPrimario);
                    panelPrincipal.remove(panelOpcionesAltas.this);
                    panelPrincipal.add(panelAltasCircuitos, BorderLayout.CENTER);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();
                    primerBoton.setBackground(colorPrimario);
                } catch (IOException ex) {
                    Logger.getLogger(panelOpcionesAltas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(panelOpcionesAltas.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        JLabel segundoBoton = new JLabel("ALTAS DE ESCUDERIAS");
        segundoBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        segundoBoton.setBackground(colorPrimario);
        segundoBoton.setOpaque(true);
//        segundoBoton.setText("<html><div style='text-align: center;'>ALTAS DE ESCUDERIAS</div></html>");
        segundoBoton.setForeground(Color.WHITE);
        segundoBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        segundoBoton.setHorizontalAlignment(SwingConstants.CENTER);
        segundoBoton.setVerticalAlignment(SwingConstants.CENTER);
        segundoBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 panelAltasEscuderias panelAltasEscuderias = new panelAltasEscuderias(panelPrincipal, panelOpcionesAltas.this, campeonato, colorPrimario);
                panelPrincipal.remove(panelOpcionesAltas.this);
                panelPrincipal.add(panelAltasEscuderias, BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                segundoBoton.setBackground(colorPrimario);
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
