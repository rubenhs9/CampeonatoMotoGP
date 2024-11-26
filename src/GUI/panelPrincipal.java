
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class panelPrincipal extends javax.swing.JPanel {

    private  Vpal vpal;
    private String nombreApp = "PRUEBA";
    private Color colorPrimario = new Color(95, 171, 221); //Color principal de la app, se puede cambiar si no gusta
    
    public panelPrincipal(Vpal vpal) {
        this.vpal = vpal; 
        this.setLayout(new BorderLayout());
        minitComponents();
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
        //Creo el Jpanel superior que estara en todo momento enseñando el nombre del insituto
        JPanel panelTituloApp = new JPanel();
        panelTituloApp.setLayout(new FlowLayout());
        panelTituloApp.setBackground(colorPrimario);
        JLabel titulo = new JLabel();
        titulo.setForeground(Color.WHITE);
        titulo.setText("| " + nombreApp + " |");
        titulo.setFont(new Font("Arial",Font.BOLD,70));
        
        panelTituloApp.add(titulo);
        this.add(panelTituloApp, BorderLayout.NORTH);
        
        //CREAMOS EL PANEL DE OPCIONES
//        panelTextArea panelTextArea = new panelTextArea("HOLA",this, colorPrimario);
//        panelTextArea.cambiarTamñoLetra(20);
//        this.add(panelTextArea,BorderLayout.CENTER);

        panelOpciones panelOpciones = new panelOpciones(vpal, this, colorPrimario);
        this.add(panelOpciones);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
