
package GUI;

import GUI_XML.panelOpcionesModoAvanzado;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class panelOpciones extends javax.swing.JPanel {

    private JFrame vpal;
    private GridBagConstraints gbc;
    private Color colorPrimario;
    private JPanel panelPrincipal;
    private Campeonato campeonato;
    private Image backgroundImage;
    
    public panelOpciones(JFrame vpal, JPanel panelPrincipal, Color colorPrimario1, Campeonato campeonato) {
        this.vpal = vpal;
        this.panelPrincipal = panelPrincipal;
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario1;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        ImageIcon imagen = new ImageIcon(campeonato.getBackground());
        backgroundImage = imagen.getImage();

        botonModoAvanzado();
        minitComponents();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Dibujo la imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, vpal.getWidth(), vpal.getHeight(), this);
            vpal.repaint();
            vpal.revalidate();
        }else{
            System.out.println("No se encontro la imagen");
        }
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

    private void botonModoAvanzado(){
        //CREAMOS EL PANEL DE ARRIBA DONDE ESTARA EL BOTON DE VOLVER
        JPanel panelModoAvanzado = new JPanel();
        panelModoAvanzado.setOpaque(false);
        panelModoAvanzado.setLayout(new FlowLayout(FlowLayout.RIGHT));
        //BOTON PARA VOLVER ATRAS
        JLabel modoAvanzado = new JLabel();
        modoAvanzado.setBackground(colorPrimario);
        modoAvanzado.setOpaque(true);
        modoAvanzado.setForeground(Color.white);
        modoAvanzado.setBorder(new EmptyBorder(0,10,0,10));
        modoAvanzado.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
//        modoAvanzado.setFont(new Font("Microsoft YaHei UI",Font.BOLD,25));
        modoAvanzado.setText("MODO AVANZADO");
        modoAvanzado.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                panelOpcionesModoAvanzado panelOpcionesModoAvanzado = new panelOpcionesModoAvanzado(panelPrincipal,panelOpciones.this, campeonato, colorPrimario);
                panelPrincipal.remove(panelOpciones.this);
                panelPrincipal.add(panelOpcionesModoAvanzado);
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
                modoAvanzado.setBackground(colorPrimario);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                modoAvanzado.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                modoAvanzado.setBackground(colorPrimario);
            }
        });
        panelModoAvanzado.add(modoAvanzado);
        this.add(panelModoAvanzado, BorderLayout.NORTH);
    }
    
    private void minitComponents() {
        JPanel panelOps = new JPanel();
        panelOps.setOpaque(false);
        panelOps.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); //Espacio entre los botones
        gbc.anchor = GridBagConstraints.CENTER; 
        //Crear botones para las opciones del menú
        int widthBoton = 280;
        int heightBoton = 65;
        
        //PRIMER BOTON
        JLabel primerBoton = new JLabel("ALTAS");
        primerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        primerBoton.setBackground(colorPrimario);
        primerBoton.setOpaque(true);
        primerBoton.setForeground(Color.WHITE);
        primerBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        primerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        primerBoton.setVerticalAlignment(SwingConstants.CENTER);
        primerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelOpcionesAltas panelOpcionesAltas = new panelOpcionesAltas(panelPrincipal,panelOpciones.this, campeonato, colorPrimario);
                panelPrincipal.remove(panelOpciones.this);
                panelPrincipal.add(panelOpcionesAltas, BorderLayout.CENTER);
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
        JLabel segundoBoton = new JLabel("LISTADOS");
        segundoBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        segundoBoton.setBackground(colorPrimario);
        segundoBoton.setOpaque(true);
        segundoBoton.setForeground(Color.WHITE);
        segundoBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        segundoBoton.setHorizontalAlignment(SwingConstants.CENTER);
        segundoBoton.setVerticalAlignment(SwingConstants.CENTER);
        segundoBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelOpcionesListados panelOpcionesListados = new panelOpcionesListados(panelPrincipal, panelOpciones.this, campeonato, colorPrimario);
                panelPrincipal.remove(panelOpciones.this);
                panelPrincipal.add(panelOpcionesListados, BorderLayout.CENTER);
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
        
        
        
        
        //TERCER BOTON
        JLabel tercerBoton = new JLabel("CLASIFICACIONES");
        tercerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        tercerBoton.setBackground(colorPrimario);
        tercerBoton.setOpaque(true);
        tercerBoton.setForeground(Color.WHITE);
        tercerBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        tercerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        tercerBoton.setVerticalAlignment(SwingConstants.CENTER);
        tercerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelOpcionesClasificacion panelOpcionesClasificacion = new panelOpcionesClasificacion(panelPrincipal, panelOpciones.this, campeonato, colorPrimario);
                panelPrincipal.remove(panelOpciones.this);
                panelPrincipal.add(panelOpcionesClasificacion, BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                tercerBoton.setBackground(colorPrimario);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                tercerBoton.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tercerBoton.setBackground(colorPrimario);
            }
        });
        gbc.gridx = 3; 
        panelOps.add(tercerBoton, gbc);
        
        this.add(panelOps, BorderLayout.CENTER);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
