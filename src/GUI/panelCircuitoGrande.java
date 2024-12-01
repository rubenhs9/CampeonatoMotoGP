
package GUI;

import data.Campeonato;
import data.Circuito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
    private Image backgroundImage;
    

    public panelCircuitoGrande(JPanel panelCircuitos, Color colorPrimario, JPanel panelPrincipal, Campeonato campeonato, Circuito circuito) {
        this.panelCircuitos = panelCircuitos;
        this.colorPrimario = colorPrimario;
        this.panelPrincipal = panelPrincipal;
        this.campeonato = campeonato;
        this.circuito = circuito;
        this.setLayout(new BorderLayout());
        this.setBackground(colorPrimario);
        
        ImageIcon imagen = new ImageIcon(campeonato.getBackground());
        backgroundImage = imagen.getImage();
        
        botonVolverAtras();
        mostrarCircuito();
        
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
    
    private void mostrarCircuito() {
        JPanel panelContenedor = new JPanel(new BorderLayout());
        panelContenedor.setOpaque(false);
        panelContenedor.setBackground(colorPrimario);

        // Crear el JLabel para la imagen
        JLabel labelImagen = new JLabel();
        labelImagen.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen
        labelImagen.setVerticalAlignment(JLabel.CENTER);

        labelImagen.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));

        // Definir dimensiones del JLabel
        int anchoLabel = 700; // Ancho máximo del JLabel
        int altoLabel = 500;  // Alto máximo del JLabel
        labelImagen.setPreferredSize(new Dimension(anchoLabel, altoLabel));

        // Cargar la imagen original
        ImageIcon icono = new ImageIcon(circuito.getImagen());
        Image imagenOriginal = icono.getImage();

        // Obtener las dimensiones originales de la imagen
        int anchoOriginal = icono.getIconWidth();
        int altoOriginal = icono.getIconHeight();

        // Calcular la escala para que la imagen se ajuste sin perder proporciones
        double escalaX = (double) anchoLabel / anchoOriginal;
        double escalaY = (double) altoLabel / altoOriginal;

        // Elegir la menor escala para mantener la proporción sin cortar la imagen
        double escalaFinal = Math.min(escalaX, escalaY);

        // Calcular el nuevo tamaño basado en la escala
        int anchoEscalado = (int) (anchoOriginal * escalaFinal);
        int altoEscalado = (int) (altoOriginal * escalaFinal);

        // Escalar la imagen al tamaño calculado
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoEscalado, altoEscalado, Image.SCALE_SMOOTH);
        labelImagen.setIcon(new ImageIcon(imagenEscalada));

        // Añadir el JLabel de la imagen al contenedor
        panelContenedor.add(labelImagen, BorderLayout.WEST);

        // Crear el panel derecho para la información
        JPanel panelInformacion = new JPanel();
        panelInformacion.setOpaque(false);
        panelInformacion.setLayout(new BorderLayout());
        panelInformacion.setBackground(colorPrimario);


        // LABEL NOMBRE
        JLabel labelNombre = new JLabel();
        labelNombre.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 32));
        labelNombre.setText(circuito.getNombre());
        labelNombre.setForeground(Color.BLACK);
        labelNombre.setHorizontalAlignment(JLabel.CENTER);

        // LABEL PAIS
        JLabel labelPais = new JLabel();
        labelPais.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 32));
        labelPais.setText(circuito.getPais());
        labelPais.setForeground(Color.BLACK);
        labelPais.setHorizontalAlignment(JLabel.CENTER);

        // LABEL LONGITUD
        JLabel labelLongitud = new JLabel();
        labelLongitud.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD, 32));
        labelLongitud.setText(circuito.getLongitud() + " km");
        labelLongitud.setForeground(Color.BLACK);
        labelLongitud.setHorizontalAlignment(JLabel.CENTER);

        // Crear un panel para contener los JLabels y organizar su disposición
        JPanel panelTexto = new JPanel();
        panelTexto.setOpaque(true);
        panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS)); // Establecer disposición vertical
        panelTexto.setBackground(colorPrimario);

        panelTexto.setBackground(new Color(255,255,255,150));

        panelTexto.add(Box.createVerticalStrut(150));

        panelTexto.add(labelNombre);
        panelTexto.add(labelPais);
        panelTexto.add(labelLongitud);



        // Añadir el panelTexto al centro del panelInformacion
        panelInformacion.add(panelTexto, BorderLayout.CENTER);
        panelInformacion.setBorder(new EmptyBorder(0,10,10,10));

        // Añadir el panel de información al lado derecho
        panelContenedor.add(panelInformacion, BorderLayout.CENTER);

        // Añadir el panel contenedor al panel principal
        this.add(panelContenedor, BorderLayout.CENTER);
    }

    
    private void botonVolverAtras() {
        JPanel panelIrHaciaAtras = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIrHaciaAtras.setOpaque(false);
        JLabel volverAtras = new JLabel("VOLVER");
        volverAtras.setBackground(colorPrimario);
        volverAtras.setOpaque(true);
        volverAtras.setForeground(Color.white);
        volverAtras.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        volverAtras.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,25));
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
