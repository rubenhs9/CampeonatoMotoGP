package GUI;

import data.Campeonato;
import data.Circuito;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Clase para mostrar los circuitos como miniaturas.
 *
 * @author Rubén
 */
public class panelCircuitos extends JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpcionesListados;
    private Campeonato campeonato;
    
    private Circuito circuito;
    private int alturaImg = 100;

    public panelCircuitos(JPanel panelPrincipal, panelOpcionesListados panelOpcionesListados, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpcionesListados = panelOpcionesListados;
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
        panelesCircuitos();
        botonVolverAtras();
        
        
    }
    
    private void panelesCircuitos(){
        JPanel panelC = new JPanel();
        panelC.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
//        panelC.setBackground(colorPrimario);
        this.add(panelC, BorderLayout.CENTER);
        
        if (campeonato.getCircuitos() == null || campeonato.getCircuitos().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay circuitos para cargar");
        return;
    }
        
        for (Circuito circuitos : campeonato.getCircuitosAdd()) {
            JLabel pCircuitos = new JLabel();
            pCircuitos.setHorizontalAlignment(SwingConstants.CENTER);
            pCircuitos.setPreferredSize(new Dimension(300,alturaImg));
            pCircuitos.setOpaque(true);
            pCircuitos.setBorder(new LineBorder(Color.BLACK,3,false));
            
            ajustarImagenEnLabel(pCircuitos, circuitos.getImagen());
            
            pCircuitos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelCircuitoGrande panelCircuitoGrande = new panelCircuitoGrande
                (panelCircuitos.this, 
                colorPrimario, 
                panelPrincipal, 
                campeonato, 
                circuitos);
                
                panelPrincipal.remove(panelCircuitos.this);
                panelPrincipal.add(panelCircuitoGrande, BorderLayout.CENTER);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                pCircuitos.setBorder(new LineBorder(Color.BLACK,3,false));
            }

            
            public void mouseEntered(MouseEvent e) {
              pCircuitos.setBorder(new LineBorder(Color.RED,3,false));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pCircuitos.setBorder(new LineBorder(Color.BLACK,3,false));
            }
        });

            panelC.add(pCircuitos);
        }
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

    private void botonVolverAtras() {
        JPanel panelIrHaciaAtras = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel volverAtras = new JLabel("VOLVER");
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        volverAtras.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        volverAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelCircuitos.this);
                panelPrincipal.add(panelOpcionesListados);
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
