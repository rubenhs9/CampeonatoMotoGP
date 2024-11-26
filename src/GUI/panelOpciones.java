
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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


public class panelOpciones extends javax.swing.JPanel {

    private JFrame vpal;
    private GridBagConstraints gbc;
    private Color colorPrimario;
    private JPanel panelPrincipal;
//    private Instituto instituto;
    private Image backgroundImage;
    
    public panelOpciones(JFrame vpal, JPanel panelPrincipal, Color colorPrimario1) {
        this.vpal = vpal;
        this.panelPrincipal = panelPrincipal;
//        this.instituto = instituto;
        this.colorPrimario = colorPrimario1;
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); //Espacio entre los botones
        gbc.anchor = GridBagConstraints.CENTER; 
//        ImageIcon imagen = new ImageIcon("res/escuela.png");
//        backgroundImage = imagen.getImage();
        minitComponents();
    }

/*
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
*/    

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
        //Crear botones para las opciones del menú
        int widthBoton = 280;
        int heightBoton = 65;
        
        //PRIMER BOTON
        JLabel primerBoton = new JLabel();
        primerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        primerBoton.setBackground(colorPrimario);
        primerBoton.setOpaque(true);
        primerBoton.setText("<html><div style='text-align: center;'>ALTAS</div></html>");
        primerBoton.setForeground(Color.WHITE);
        primerBoton.setFont(new Font("Arial",Font.BOLD,20));
        primerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        primerBoton.setVerticalAlignment(SwingConstants.CENTER);
        primerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                panelInfoAlumno panelInfoInstituto = new panelInfoAlumno(panelPrincipal,panelOpciones.this, instituto);
//                panelPrincipal.remove(panelOpciones.this);
//                panelPrincipal.add(panelInfoInstituto, BorderLayout.CENTER);
//                panelPrincipal.revalidate();
//                panelPrincipal.repaint();
//                primerBoton.setBackground(colorPrimario);
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
        this.add(primerBoton, gbc);
        
        
        //SEGUNDO BOTON
        JLabel segundoBoton = new JLabel();
        segundoBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        segundoBoton.setBackground(colorPrimario);
        segundoBoton.setOpaque(true);
        segundoBoton.setText("<html><div style='text-align: center;'>LISTADOS</div></html>");
        segundoBoton.setForeground(Color.WHITE);
        segundoBoton.setFont(new Font("Arial",Font.BOLD,20));
        segundoBoton.setHorizontalAlignment(SwingConstants.CENTER);
        segundoBoton.setVerticalAlignment(SwingConstants.CENTER);
        segundoBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                panelMatriculacion panelMatriculacion = new panelMatriculacion(panelPrincipal,panelOpciones.this, instituto);
//                panelPrincipal.remove(panelOpciones.this);
//                panelPrincipal.add(panelMatriculacion, BorderLayout.CENTER);
//                panelPrincipal.revalidate();
//                panelPrincipal.repaint();
//                segundoBoton.setBackground(colorPrimario);
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
        this.add(segundoBoton, gbc);
        
        
        
        
        //TERCER BOTON
        JLabel tercerBoton = new JLabel();
        tercerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        tercerBoton.setBackground(colorPrimario);
        tercerBoton.setOpaque(true);
        tercerBoton.setText("<html><div style='text-align: center;'>CLASIFICACIONES</div></html>");
        tercerBoton.setForeground(Color.WHITE);
        tercerBoton.setFont(new Font("Arial",Font.BOLD,20));
        tercerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        tercerBoton.setVerticalAlignment(SwingConstants.CENTER);
        tercerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                panelInfoAsignatura panelInfoAsignatura = new panelInfoAsignatura(vpal,panelPrincipal,panelOpciones.this, instituto);
//                panelPrincipal.remove(panelOpciones.this);
//                panelPrincipal.add(panelInfoAsignatura, BorderLayout.CENTER);
//                panelPrincipal.revalidate();
//                panelPrincipal.repaint();
//                tercerBoton.setBackground(colorPrimario);
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
        this.add(tercerBoton, gbc);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
