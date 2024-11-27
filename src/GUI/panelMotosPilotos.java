
package GUI;

import data.Campeonato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class panelMotosPilotos extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelEscuderias;
    private Campeonato campeonato;
    
    public panelMotosPilotos(JPanel panelPrincipal, JPanel panelEscuderias, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelEscuderias = panelEscuderias;
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
                panelPrincipal.remove(panelMotosPilotos.this);
                panelPrincipal.add(panelEscuderias);
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
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        
        //PILITO Y MOTO DE LA IZQUIERDA
        JPanel panelContenedorIzq = new JPanel();
        panelContenedorIzq.setLayout(new BorderLayout());
        panelContenedorIzq.setPreferredSize(new Dimension(400,300));
        panelContenedorIzq.setBackground(colorPrimario);
        
//        //PANEL DONDE ESTARÁ EL PILITO Y LA MOTO
//        JPanel panelMotoPilotoIzq = new JPanel(new BorderLayout());
//        //Label piloto
//        JLabel labelPilotoIzq = new JLabel();
//        labelPilotoIzq.setBackground(Color.red);
//        //label moto
//        JLabel labelMotoIzq = new JLabel();
//        labelMotoIzq.setBackground(Color.YELLOW);
//        panelMotoPilotoIzq.add(labelPilotoIzq, BorderLayout.WEST);
//        panelMotoPilotoIzq.add(labelMotoIzq, BorderLayout.EAST);
//        
//        
//        panelContenedorIzq.add(panelMotoPilotoIzq, BorderLayout.CENTER);
//        //PANEL DONDE ESTARA LA INFO DEL PILOTO
        
        
        panelContenido.add(panelContenedorIzq, BorderLayout.WEST);
        
        //PILITO Y MOTO DE LA DERECHA
        JPanel panelContenedorDerch = new JPanel();
        panelContenedorDerch.setLayout(new BorderLayout());
        panelContenedorDerch.setBackground(colorPrimario);
        
        
        
        
        panelContenido.add(panelContenedorDerch, BorderLayout.EAST);
        
        this.add(panelContenido, BorderLayout.CENTER);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
