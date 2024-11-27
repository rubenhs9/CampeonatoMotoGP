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
            j.setPreferredSize(new Dimension(300,100));
            j.setOpaque(true);
            j.setBackground(Color.RED);
            j.setText(circuitos.getNombre());
            panelCircuitos.add(j);
            
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
