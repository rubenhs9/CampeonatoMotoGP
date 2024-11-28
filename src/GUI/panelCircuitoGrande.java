/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import data.Campeonato;
import data.Circuito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rubén
 */
public class panelCircuitoGrande extends JPanel{
    private JPanel panelCircuitos;
    private Color colorPrimario;
    private JPanel panelPrincipal;
    private Campeonato campeonato;
    private Circuito circuito;
    

    public panelCircuitoGrande(JPanel panelCircuitos, Color colorPrimario, JPanel panelPrincipal, Campeonato campeonato, Circuito circuito) {
        this.panelCircuitos = panelCircuitos;
        this.colorPrimario = colorPrimario;
        this.panelPrincipal = panelPrincipal;
        this.campeonato = campeonato;
        this.circuito = circuito;
        this.setLayout(new BorderLayout());
        this.setBackground(colorPrimario);
        
        mostrarCircuito();
        botonVolverAtras();
    }
    
    private void mostrarCircuito(){
        
        if (circuito == null) {
        System.err.println("El circuito es nulo. Revisa la inicialización.");
        return;
    }
        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.setBackground(colorPrimario);
        
        JLabel labelImagen = new JLabel();
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        
         // Cargar y ajustar la imagen
        ImageIcon icono = new ImageIcon(circuito.getImagen());
        Image imagen = icono.getImage().getScaledInstance(1000, 500, Image.SCALE_SMOOTH); // Ajustar tamaño
        labelImagen.setIcon(new ImageIcon(imagen));

        panelContenedor.add(labelImagen, BorderLayout.CENTER);

        this.add(panelContenedor, BorderLayout.CENTER);
    }
    
    private void botonVolverAtras() {
        JPanel panelIrHaciaAtras = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel volverAtras = new JLabel("VOLVER");
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        volverAtras.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
        volverAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelCircuitoGrande.this);
                panelPrincipal.add(panelCircuitos);
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
    
}
