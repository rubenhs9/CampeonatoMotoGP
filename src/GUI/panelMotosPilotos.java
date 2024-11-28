
package GUI;

import data.Campeonato;
import data.Escuderia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class panelMotosPilotos extends javax.swing.JPanel {

    private Color colorPrimario;
    private JPanel panelPrincipal;
    private JPanel panelEscuderias;
    private Campeonato campeonato;
    private Escuderia escuderia;
    
    private int tamFuente = 34;
    private int imagenAlto = 200; 
    
    public panelMotosPilotos(JPanel panelPrincipal, JPanel panelEscuderias, Campeonato campeonato, Escuderia escuderia, Color colorPrimario) {
        this.panelPrincipal = panelPrincipal;
        this.panelEscuderias = panelEscuderias;
        this.campeonato = campeonato;
        this.escuderia = escuderia;
        this.colorPrimario = colorPrimario;
        this.setLayout(new BorderLayout());
        
        botonVolverAtras();
        minitComponents();
    }
    
    private void dibujarFondo(Graphics g) {
        super.paintComponent(g);  // Asegúrate de llamar a esto primero

        // Crear un objeto Graphics2D para trabajar con gráficos avanzados
        Graphics2D g2d = (Graphics2D) g;

        // Definir los colores del gradiente
        Color color1 = escuderia.getColorPrimario();
        Color color2 = escuderia.getColorSecundario();

        // Crear el gradiente de arriba a abajo
        GradientPaint gradiente = new GradientPaint(0, 0, color1, 0, getHeight(), color2);

        // Establecer el gradiente como pintura
        g2d.setPaint(gradiente);

        // Dibujar el rectángulo de fondo con el gradiente
        g2d.fillRect(0, 0, getWidth(), getHeight());

        if (escuderia.getImagen() != null) {
            ImageIcon icon = new ImageIcon(escuderia.getImagen());
            Image img = icon.getImage();

            // Obtener el ancho y alto original de la imagen
            int imgAnchoOriginal = img.getWidth(this);
            int imgAltoOriginal = img.getHeight(this);

            // Calcular el ancho en función del alto deseado, manteniendo la relación de aspecto
            int nuevoAlto = imagenAlto;  // Alto que deseas que tenga la imagen
            int nuevoAncho = (int) ((double) imgAnchoOriginal * nuevoAlto / imgAltoOriginal);

            // Calcular las coordenadas para centrar la imagen
            int x = (getWidth() - nuevoAncho) / 2;
            int y = (getHeight() - nuevoAlto) / 2;

            // Dibuja la imagen centrada con el nuevo tamaño calculado
            g.drawImage(img, x, y, nuevoAncho, nuevoAlto, this);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Llama al método original de paintComponent
        dibujarFondo(g);  // Dibuja el fondo
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
        panelContenido.setOpaque(false);
        //PILITO Y MOTO DE LA IZQUIERDA
        JPanel panelContenedorIzq = new JPanel();
        panelContenedorIzq.setLayout(new BorderLayout());
        panelContenedorIzq.setBackground(colorPrimario);
        panelContenedorIzq.setOpaque(false);
        
        //PANEL DONDE ESTARÁ EL PILITO Y LA MOTO
        JPanel panelMotoPilotoIzq = new JPanel(new BorderLayout());
        panelMotoPilotoIzq.setOpaque(true); 
        Color colorTransparente = new Color(0, 0, 0, 128);  //Color negro con 50% de transparencia
        panelMotoPilotoIzq.setBackground(colorTransparente);
        //Label piloto
        JLabel labelPilotoIzq = new JLabel();
        labelPilotoIzq.setOpaque(false);
        labelPilotoIzq.setPreferredSize(new Dimension(200, 300));
        labelPilotoIzq.setHorizontalAlignment(SwingConstants.CENTER);
        String rutaImagenPiloto = escuderia.getPilotos().get(0).getRutaImagenPiloto();
        ajustarImagenEnLabel(labelPilotoIzq,rutaImagenPiloto,300,false);
        labelPilotoIzq.setBackground(Color.red);
        //label moto
        JLabel labelMotoIzq = new JLabel();
        labelMotoIzq.setOpaque(false);
        labelMotoIzq.setPreferredSize(new Dimension(400, 300));
        labelMotoIzq.setHorizontalAlignment(SwingConstants.CENTER);
        String rutaImagenMoto = escuderia.getPilotos().get(0).getMoto().getRutaimagenMoto();
        ajustarImagenEnLabel(labelMotoIzq,rutaImagenMoto,300,false);
        labelMotoIzq.setBackground(Color.YELLOW);
        panelMotoPilotoIzq.add(labelPilotoIzq, BorderLayout.WEST);
        panelMotoPilotoIzq.add(labelMotoIzq, BorderLayout.EAST);
        
        panelContenedorIzq.add(panelMotoPilotoIzq, BorderLayout.CENTER);
        
        
        //PANEL DONDE ESTARA LA INFO DEL PILOTO
        JPanel panelInfoPilotoIzq = new JPanel(new BorderLayout());
        panelInfoPilotoIzq.setPreferredSize(new Dimension(400, 100));
        panelInfoPilotoIzq.setBackground(Color.WHITE);
        //Jlabel bandera
        JLabel paisPilotoIzq = new JLabel();
        String rutaPais = escuderia.getPilotos().get(0).getPais().getRutaImagen();
        ajustarImagenEnLabel(paisPilotoIzq,rutaPais,100,false);
        panelInfoPilotoIzq.add(paisPilotoIzq,BorderLayout.WEST);
        //Jlabel nombre Piloto
        JLabel nombrePilotoIzq = new JLabel();
        nombrePilotoIzq.setText(escuderia.getPilotos().get(0).getNombre());
        nombrePilotoIzq.setHorizontalAlignment(SwingConstants.CENTER);
        nombrePilotoIzq.setVerticalAlignment(SwingConstants.CENTER);
        nombrePilotoIzq.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,tamFuente));
        panelInfoPilotoIzq.add(nombrePilotoIzq,BorderLayout.CENTER);
        //Jlabel Puntos piloto
        JLabel puntosPilotoIzq = new JLabel();
        puntosPilotoIzq.setText("PTS: " + String.valueOf(escuderia.getPilotos().get(0).getPuntos()) + " ");
        puntosPilotoIzq.setHorizontalAlignment(SwingConstants.CENTER);
        puntosPilotoIzq.setVerticalAlignment(SwingConstants.CENTER);
        puntosPilotoIzq.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,tamFuente));
        panelInfoPilotoIzq.add(puntosPilotoIzq,BorderLayout.EAST);
        
        panelContenedorIzq.add(panelInfoPilotoIzq, BorderLayout.SOUTH);
        
        panelContenido.add(panelContenedorIzq, BorderLayout.WEST);
        
        
        
        
        //PILITO Y MOTO DE LA DERECHA
        JPanel panelContenedorDerch = new JPanel();
        panelContenedorDerch.setLayout(new BorderLayout());
        panelContenedorDerch.setBackground(colorPrimario);
        panelContenedorDerch.setOpaque(false);
        
        //PANEL DONDE ESTARÁ EL PILITO Y LA MOTO
        JPanel panelMotoPilotoDerch = new JPanel(new BorderLayout());
        panelMotoPilotoDerch.setOpaque(true); 
        panelMotoPilotoDerch.setBackground(colorTransparente);
        //Label piloto
        JLabel labelPilotoDerch = new JLabel();
        labelPilotoDerch.setOpaque(false);
        labelPilotoDerch.setPreferredSize(new Dimension(200, 300));
        labelPilotoDerch.setHorizontalAlignment(SwingConstants.CENTER);
        String rutaImagenPilotoDerch = escuderia.getPilotos().get(1).getRutaImagenPiloto();
        ajustarImagenEnLabel(labelPilotoDerch,rutaImagenPilotoDerch,300,false);
        labelPilotoDerch.setBackground(Color.red);
        
        //label moto
        JLabel labelMotoDerch = new JLabel();
        labelMotoDerch.setOpaque(false);
        labelMotoDerch.setPreferredSize(new Dimension(400, 300));
        labelMotoDerch.setHorizontalAlignment(SwingConstants.CENTER);
        String rutaImagenMotoDerch = escuderia.getPilotos().get(1).getMoto().getRutaimagenMoto();
        ajustarImagenEnLabel(labelMotoDerch,rutaImagenMotoDerch,300,true);
        labelMotoDerch.setBackground(Color.YELLOW);
        panelMotoPilotoDerch.add(labelPilotoDerch, BorderLayout.EAST);
        panelMotoPilotoDerch.add(labelMotoDerch, BorderLayout.WEST);
        
        
        panelContenedorDerch.add(panelMotoPilotoDerch, BorderLayout.CENTER);
        
        
        //PANEL DONDE ESTARA LA INFO DEL PILOTO
        JPanel panelInfoPilotoDerch = new JPanel(new BorderLayout());
        panelInfoPilotoDerch.setPreferredSize(new Dimension(400, 100));
        panelInfoPilotoDerch.setBackground(Color.WHITE);
        //Jlabel bandera
        JLabel paisPilotoDerch = new JLabel();
        String rutaPaisDerch = escuderia.getPilotos().get(1).getPais().getRutaImagen();
        ajustarImagenEnLabel(paisPilotoDerch,rutaPaisDerch,100,false);
        panelInfoPilotoDerch.add(paisPilotoDerch,BorderLayout.EAST);
        //Jlabel nombre Piloto
        JLabel nombrePilotoDerch = new JLabel();
        nombrePilotoDerch.setText(escuderia.getPilotos().get(1).getNombre());
        nombrePilotoDerch.setHorizontalAlignment(SwingConstants.CENTER);
        nombrePilotoDerch.setVerticalAlignment(SwingConstants.CENTER);
        nombrePilotoDerch.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,tamFuente));
        panelInfoPilotoDerch.add(nombrePilotoDerch,BorderLayout.CENTER);
        //Jlabel Puntos piloto
        JLabel puntosPilotoDerch = new JLabel();
        puntosPilotoDerch.setText(" PTS: " + String.valueOf(escuderia.getPilotos().get(1).getPuntos()));
        puntosPilotoDerch.setHorizontalAlignment(SwingConstants.CENTER);
        puntosPilotoDerch.setVerticalAlignment(SwingConstants.CENTER);
        puntosPilotoDerch.setFont(campeonato.getFuenteMotoGP().deriveFont(Font.BOLD,tamFuente));
        panelInfoPilotoDerch.add(puntosPilotoDerch,BorderLayout.WEST);
        
        panelContenedorDerch.add(panelInfoPilotoDerch, BorderLayout.SOUTH);
        
        panelContenido.add(panelContenedorIzq, BorderLayout.WEST);

        
        panelContenido.add(panelContenedorDerch, BorderLayout.EAST);
        
        this.add(panelContenido, BorderLayout.CENTER);
    }

    private void ajustarImagenEnLabel(JLabel label, String rutaImagen, int alturaImg, boolean voltear) {
    try {
        // Cargar la imagen desde la ruta
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
        Image imagenOriginal = iconoOriginal.getImage();

        // Dimensiones deseadas
        int alturaLabel = alturaImg; // Altura fija
        int anchoEscalado = (int) (imagenOriginal.getWidth(null) * ((double) alturaLabel / imagenOriginal.getHeight(null)));

        // Crear un BufferedImage escalado
        BufferedImage bufferedImage = new BufferedImage(anchoEscalado, alturaLabel, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // Suavizado para una mejor calidad de imagen
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        if (voltear) {
            // Configurar el AffineTransform para voltear y escalar
            AffineTransform transform = new AffineTransform();
            transform.scale(-1, 1); // Voltear horizontalmente
            transform.translate(-anchoEscalado, 0); // Ajustar la posición para mantener el tamaño
            g2d.setTransform(transform); // Aplicar la transformación al contexto gráfico
        }
        
        // Dibujar la imagen (normal o transformada)
        g2d.drawImage(imagenOriginal, 0, 0, anchoEscalado, alturaLabel, null);

        g2d.dispose();

        // Establecer la imagen resultante en el JLabel
        label.setIcon(new ImageIcon(bufferedImage));
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al cargar la imagen: " + rutaImagen);
    }
}




    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
