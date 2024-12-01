
package GUI_XML;

import GUI.panelOpciones;
import GUI.panelOpcionesAltas;
import GUI.panelOpcionesClasificacion;
import GUI.panelOpcionesListados;
import data.Campeonato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.w3c.dom.Document;


public class panelOpcionesModoAvanzado extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelOpciones;
    private Campeonato campeonato;
    private GridBagConstraints gbc;
    
    public panelOpcionesModoAvanzado(JPanel panelPrincipal, JPanel panelOpciones, Campeonato campeonato, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelOpciones = panelOpciones;
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
        volverAtras.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        volverAtras.setText("VOLVER");
        volverAtras.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                panelPrincipal.remove(panelOpcionesModoAvanzado.this);
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
        panelOps.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); //Espacio entre los botones
        gbc.anchor = GridBagConstraints.CENTER; 
        //Crear botones para las opciones del menú
        int widthBoton = 280;
        int heightBoton = 65;
        
        //PRIMER BOTON
        JLabel primerBoton = new JLabel("REALIZAR BUSQUEDAS");
        primerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        primerBoton.setBackground(colorPrimario);
        primerBoton.setOpaque(true);
//        primerBoton.setText("<html><div style='text-align: center;'>REALIZAR BUSQUEDAS</div></html>");
        primerBoton.setForeground(Color.WHITE);
        primerBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        primerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        primerBoton.setVerticalAlignment(SwingConstants.CENTER);
        primerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelRealizarBusquedas panelRealizarBusquedas = new panelRealizarBusquedas(panelPrincipal,panelOpcionesModoAvanzado.this, campeonato, colorPrimario);
                panelPrincipal.remove(panelOpcionesModoAvanzado.this);
                panelPrincipal.add(panelRealizarBusquedas, BorderLayout.CENTER);
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
        JLabel segundoBoton = new JLabel("EXPORTAR A XML");
        segundoBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        segundoBoton.setBackground(colorPrimario);
        segundoBoton.setOpaque(true);
//        segundoBoton.setText("<html><div style='text-align: center;'>EXPORTAR A XML</div></html>");
        segundoBoton.setForeground(Color.WHITE);
        segundoBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        segundoBoton.setHorizontalAlignment(SwingConstants.CENTER);
        segundoBoton.setVerticalAlignment(SwingConstants.CENTER);
        segundoBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
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
        gbc.gridy = 1;
        panelOps.add(segundoBoton, gbc);
        
        
        
        
        //TERCER BOTON
        JLabel tercerBoton = new JLabel("IMPORTAR DE LOS XML");
        tercerBoton.setPreferredSize(new Dimension(widthBoton, heightBoton));
        tercerBoton.setBackground(colorPrimario);
        tercerBoton.setOpaque(true);
//        tercerBoton.setText("<html><div style='text-align: center;'>IMPORTAR DE LOS XML</div></html>");
        tercerBoton.setForeground(Color.WHITE);
        tercerBoton.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
        tercerBoton.setHorizontalAlignment(SwingConstants.CENTER);
        tercerBoton.setVerticalAlignment(SwingConstants.CENTER);
        tercerBoton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //Cargar el archivo XML
                    XmlParser parser = new XmlParser(".\\res\\storage\\___dalesEsteArch__ridersMotoGP.xml");
                    Document document = parser.getDocument();
                    campeonato.setDocumentoXML2012(document);
                    //Mostrar todo el XML
//                    System.out.println("" + parser.getXmlAsString());

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
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
        gbc.gridy = 3; 
        panelOps.add(tercerBoton, gbc);
        
        this.add(panelOps, BorderLayout.CENTER);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
