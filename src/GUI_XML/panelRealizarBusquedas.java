

package GUI_XML;

import data.Campeonato;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class panelRealizarBusquedas extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelAnterior;
    private XPathQueries xp;
    private JPanel panelResultados;
    private JScrollPane scrollPane;
     private Image backgroundImage;

    private Campeonato campeonato;
    
    public panelRealizarBusquedas(JPanel panelPrincipal, JPanel panelAnterior, Campeonato campeonato, Color colorPrimario,  XPathQueries xp) {
        this.panelPrincipal = panelPrincipal;
        this.panelAnterior = panelAnterior;
        this.campeonato = campeonato;
        this.colorPrimario = colorPrimario;
        this.xp = xp;
        this.setLayout(new BorderLayout());
        
        ImageIcon imagen = new ImageIcon(campeonato.getBackground());
        backgroundImage = imagen.getImage();
        
        panelResultados = new JPanel();
        panelResultados.setOpaque(false);
        panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));
        panelResultados.setBorder(new EmptyBorder(0,10,0,10)); //AÑADIMOS UN BORDE PARA QUE NO QUEDE TAN PEGADO A LA VENTANA
        
        botonVolverAtras();
        pintarBusquedas();
        
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
    
    private void pintarBusquedas() {
    try {
        if (xp != null) {
            xp.ejecutarConsultas();  // Ejecutar las consultas XPath
        } else {
            System.out.println("El objeto xp no está inicializado.");
        }

        List<String> resultados = xp.getResultados();  // Obtener los resultados de las consultas

        // Limpiar el panel de resultados antes de añadir nuevos
        panelResultados.removeAll();

        // Crear y agregar el título para la primera consulta
        JLabel tituloConsulta1 = new JLabel("Nombre de los cinco primeros pilotos clasificados en el mundial:");
        tituloConsulta1.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 35));
        tituloConsulta1.setForeground(Color.RED);  // Color rojo para el título
        panelResultados.add(tituloConsulta1);

        // Añadir los resultados de la primera consulta
        for (int i = 0; i < 5; i++) { // Mostramos solo los primeros 5 resultados
            JLabel lblResultado = new JLabel(resultados.get(i));
            lblResultado.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.PLAIN, 25)); 
            lblResultado.setForeground(Color.BLACK);
            panelResultados.add(lblResultado);
        }

        // Crear y agregar el título para la segunda consulta
        JLabel tituloConsulta2 = new JLabel("Pilotos con Yamaha:");
        tituloConsulta2.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 35));
        tituloConsulta2.setForeground(Color.RED);  // Color rojo para el título
        panelResultados.add(tituloConsulta2);

        // Añadir los resultados de la segunda consulta
        for (int i = 5; i < 10; i++) { // Suposición de que los resultados de Yamaha van después de los primeros
            JLabel lblResultado = new JLabel(resultados.get(i));
            lblResultado.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.PLAIN, 25)); 
            lblResultado.setForeground(Color.BLACK);
            panelResultados.add(lblResultado);
        }

        // Crear y agregar el título para la tercera consulta
        JLabel tituloConsulta3 = new JLabel("Pilotos españoles:");
        tituloConsulta3.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 35));
        tituloConsulta3.setForeground(Color.RED);  // Color rojo para el título
        panelResultados.add(tituloConsulta3);

        // Añadir los resultados de la tercera consulta
        for (int i = 10; i < resultados.size(); i++) { // Los resultados de los pilotos españoles
            JLabel lblResultado = new JLabel(resultados.get(i));
            lblResultado.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.PLAIN, 25)); 
            lblResultado.setForeground(Color.BLACK);
            panelResultados.add(lblResultado);
        }

        // Crear el JScrollPane con el panel que contiene los resultados
        scrollPane = new JScrollPane(panelResultados);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));  
        scrollPane.setOpaque(true);
        scrollPane.setBackground(new Color(255,255,255));
        scrollPane.getViewport().setOpaque(false); 
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //Asegurarse de no borrar el botón, solo actualizar el contenido
        this.remove(scrollPane);  // Eliminar solo el contenido anterior

        //Añadir el nuevo JScrollPane con los resultados
        this.add(scrollPane, BorderLayout.CENTER);

        // Redibujar la interfaz
        this.revalidate();
        this.repaint();

    } catch (Exception e) {
        e.printStackTrace();  // Para depurar si ocurre algún error
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
                panelPrincipal.remove(panelRealizarBusquedas.this);
                panelPrincipal.add(panelAnterior);
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
