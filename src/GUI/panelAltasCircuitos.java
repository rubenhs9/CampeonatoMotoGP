
package GUI;

import data.Campeonato;
import data.Circuito;
import data.FicheroCircuito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class panelAltasCircuitos extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
   
    
    private int alturaImg = 100;
    
    public panelAltasCircuitos(JPanel panelPrincipal, JPanel panelOpciones, Campeonato campeonato, Color colorPrimario) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.panelPrincipal = panelPrincipal;
        this.panelOpciones = panelOpciones;
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
         // Cargar los circuitos guardados desde el fichero
        Set<Circuito> circuitosGuardados = FicheroCircuito.cargarCircuitos();
        if (circuitosGuardados != null) {
            campeonato.getCircuitosAdd().addAll(circuitosGuardados);  // Añadir a circuitosAdd
        }

        
        System.out.println(campeonato.getCircuitos().size());
        botonVolverAtras();
        cargarCircuitos();
        
    }
    
    public void agregarCircuitoFichero(){
        
    }
    

    public void cargarCircuitos(){
    // Crear el panel para los circuitos
    JPanel panelC = new JPanel();
    panelC.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//    panelC.setBackground(colorPrimario);
    this.add(panelC, BorderLayout.CENTER);

    
    for (Circuito circuito : campeonato.getCircuitos()) {
        JLabel pCircuitos = new JLabel();
        pCircuitos.setHorizontalAlignment(SwingConstants.CENTER);
        pCircuitos.setPreferredSize(new Dimension(300, alturaImg));
        pCircuitos.setOpaque(true);
        pCircuitos.setBorder(new LineBorder(Color.BLACK, 3, false));
        ajustarImagenEnLabel(pCircuitos, circuito.getImagen());
        if (campeonato.getCircuitosAdd().contains(circuito)) {
            pCircuitos.setBackground(Color.RED);
        }

        pCircuitos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (!campeonato.getCircuitosAdd().contains(circuito)) {
                    campeonato.addCircuitosAdd(circuito);
                    JOptionPane.showMessageDialog(null, 
                        "Circuito añadido: " + circuito.getNombre(), 
                        "Información", 
                        JOptionPane.INFORMATION_MESSAGE);
                    pCircuitos.setBackground(Color.RED);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "El circuito ya está en la lista.", 
                        "Aviso", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pCircuitos.setBorder(new LineBorder(Color.RED, 3, false));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pCircuitos.setBorder(new LineBorder(Color.BLACK, 3, false));
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
        volverAtras.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        volverAtras.setText("VOLVER");
        volverAtras.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelAltasCircuitos.this);
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
