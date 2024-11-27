package GUI;

import data.Campeonato;
import data.Circuito;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase para mostrar los circuitos como miniaturas.
 *
 * @author Rubén
 */
public class panelCircuitos extends JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpcionesListados;
    private ArrayList<String> listaImagenes;
    private Campeonato campeonato;
    private int alturaImg = 100;

    public panelCircuitos(JPanel panelPrincipal, panelOpcionesListados panelOpcionesListados, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpcionesListados = panelOpcionesListados;
        this.listaImagenes = new ArrayList<>();
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
        panelesCircuitos();
        botonVolverAtras();
        
        
    }
    
    private void panelesCircuitos(){
        JPanel panelCircuitos = new JPanel();
        panelCircuitos.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        panelCircuitos.setBackground(colorPrimario);
        this.add(panelCircuitos, BorderLayout.CENTER);
        
        for (Circuito circuitos : campeonato.getCircuitos()) {
            JLabel j = new JLabel();
            j.setHorizontalAlignment(SwingConstants.CENTER);
            j.setPreferredSize(new Dimension(300,alturaImg));
            j.setOpaque(true);
            
            ajustarImagenEnLabel(j, circuitos.getImagen());
            panelCircuitos.add(j);
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
        volverAtras.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
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
