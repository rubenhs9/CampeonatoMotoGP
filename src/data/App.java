
package data;

import GUI.Vpal;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Rubén
 */
public class App {
    private String nombre;
    private Campeonato campeonato2024;

    public App(String nombre) {
        this.nombre = nombre;
        campeonato2024 = new Campeonato(nombre);
        datosPrueba(campeonato2024);
        datosPruebaCircuito(campeonato2024);
        campeonato2024.mostrarCircuitos();
        
        modoGrafico();
    }
    
    public void datosPrueba(Campeonato campeonato){
        
        
        // Ducati Lenovo Team
        Escuderia escuderia1 = new Escuderia("Ducati Lenovo Team", Pais.ITALIA,".\\res\\imgEscuderias\\Ducati Lenovo Team.png",new Color(183,1,5),new Color(53,1,3));
        Moto moto1 = new Moto("1", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\Ducati Team.png");
        Moto moto2 = new Moto("23", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\Ducati Team.png");
        Piloto piloto1 = new Piloto("Francesco Bagnaia", Pais.ITALIA, "Ducati Lenovo Team", generarPuntosAleatorios(), moto1, ".\\res\\imgPilotos\\Francesco Bagnaia.png");
        Piloto piloto2 = new Piloto("Enea Bastianini", Pais.ITALIA, "Ducati Lenovo Team", generarPuntosAleatorios(), moto2, ".\\res\\imgPilotos\\Enea Bastianini.png");
//        escuderia1.addPilotos(piloto1, piloto2);
        campeonato.addEscuderia(escuderia1);
        campeonato.addPilotos(piloto1, piloto2);

        // Red Bull KTM Factory Racing
        Escuderia escuderia2 = new Escuderia("Red Bull KTM Factory Racing", Pais.AUSTRIA,".\\res\\imgEscuderias\\Red Bull KTM Factory Racing.png",new Color(36,40,92),new Color(197, 139, 37));
        Moto moto3 = new Moto("33", "KTM", "RC16", ".\\res\\imgMotos\\Red Bull KTM Factory Racing.png");
        Moto moto4 = new Moto("43", "KTM", "RC16", ".\\res\\imgMotos\\Red Bull KTM Factory Racing.png");
        Piloto piloto3 = new Piloto("Brad Binder", Pais.SUDAFRICA, "Red Bull KTM Factory Racing", generarPuntosAleatorios(), moto3, ".\\res\\imgPilotos\\Brad Binder.png");
        Piloto piloto4 = new Piloto("Jack Miller", Pais.AUSTRALIA, "Red Bull KTM Factory Racing", generarPuntosAleatorios(), moto4, ".\\res\\imgPilotos\\Jack Miller.png");
//        escuderia2.addPilotos(piloto3, piloto4);
        campeonato.addEscuderia(escuderia2);
        campeonato.addPilotos(piloto3, piloto4);

        // Aprilia Racing
        Escuderia escuderia3 = new Escuderia("Aprilia Racing", Pais.ITALIA,".\\res\\imgEscuderias\\Aprilia Racing.png",new Color(36,40,92),new Color(142, 31, 31));
        Moto moto5 = new Moto("41", "Aprilia", "RS-GP", ".\\res\\imgMotos\\Aprilia-RS-GP-2024.png");
        Moto moto6 = new Moto("12", "Aprilia", "RS-GP", ".\\res\\imgMotos\\Aprilia-RS-GP-2024.png");
        Piloto piloto5 = new Piloto("Aleix Espargaró", Pais.ESPAÑA, "Aprilia Racing", generarPuntosAleatorios(), moto5, ".\\res\\imgPilotos\\Aleix Espargaró.png");
        Piloto piloto6 = new Piloto("Maverick Viñales", Pais.ESPAÑA, "Aprilia Racing", generarPuntosAleatorios(), moto6, ".\\res\\imgPilotos\\Maverick Viñales.png");
//        escuderia3.addPilotos(piloto5, piloto6);
        campeonato.addEscuderia(escuderia3);
        campeonato.addPilotos(piloto5, piloto6);

        // Prima Pramac Racing
        Escuderia escuderia4 = new Escuderia("Prima Pramac Racing", Pais.ITALIA,".\\res\\imgEscuderias\\Prima Pramac Racing.png",new Color(152, 57, 196),new Color(142, 31, 31));
        Moto moto7 = new Moto("89", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\Prima Pramac Racing.png");
        Moto moto8 = new Moto("21", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\Prima Pramac Racing.png");
        Piloto piloto7 = new Piloto("Jorge Martín", Pais.ESPAÑA, "Prima Pramac Racing", generarPuntosAleatorios(), moto7, ".\\res\\imgPilotos\\Jorge Martín.png");
        Piloto piloto8 = new Piloto("Franco Morbidelli", Pais.ITALIA, "Prima Pramac Racing", generarPuntosAleatorios(), moto8, ".\\res\\imgPilotos\\Franco Morbidelli.png");
//        escuderia4.addPilotos(piloto7, piloto8);
        campeonato.addEscuderia(escuderia4);
        campeonato.addPilotos(piloto7, piloto8);

        // Monster Energy Yamaha MotoGP
        Escuderia escuderia5 = new Escuderia("Monster Energy Yamaha MotoGP", Pais.JAPÓN,".\\res\\imgEscuderias\\Monster Energy Yamaha MotoGP.png",new Color(0,26,119),Color.BLACK);
        Moto moto9 = new Moto("20", "Yamaha", "YZR-M1", ".\\res\\imgMotos\\Yamaha Factory Racing.png");
        Moto moto10 = new Moto("42", "Yamaha", "YZR-M1", ".\\res\\imgMotos\\Yamaha Factory Racing.png");
        Piloto piloto9 = new Piloto("Fabio Quartararo", Pais.FRANCIA, "Monster Energy Yamaha MotoGP", generarPuntosAleatorios(), moto9, ".\\res\\imgPilotos\\Fabio Quartararo.png");
        Piloto piloto10 = new Piloto("Álex Rins", Pais.ESPAÑA, "Monster Energy Yamaha MotoGP", generarPuntosAleatorios(), moto10, ".\\res\\imgPilotos\\Álex Rins.png");
//        escuderia5.addPilotos(piloto9, piloto10);
        campeonato.addEscuderia(escuderia5);
        campeonato.addPilotos(piloto9, piloto10);

        // Gresini Racing MotoGP
        Escuderia escuderia6 = new Escuderia("Gresini Racing MotoGP", Pais.ITALIA,".\\res\\imgEscuderias\\Gresini Racing MotoGP.png",new Color(164,204,236),new Color(182,96,96));
        Moto moto11 = new Moto("93", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\Gresini Racing.png");
        Moto moto12 = new Moto("73", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\Gresini Racing.png");
        Piloto piloto11 = new Piloto("Marc Márquez", Pais.ESPAÑA, "Gresini Racing MotoGP", generarPuntosAleatorios(), moto11, ".\\res\\imgPilotos\\Marc Márquez.png");
        Piloto piloto12 = new Piloto("Álex Márquez", Pais.ESPAÑA, "Gresini Racing MotoGP", generarPuntosAleatorios(), moto12, ".\\res\\imgPilotos\\Álex Márquez.png");
//        escuderia6.addPilotos(piloto11, piloto12);
        campeonato.addEscuderia(escuderia6);
        campeonato.addPilotos(piloto11, piloto12);

        // Mooney VR46 Racing Team
        Escuderia escuderia7 = new Escuderia("Pertamina Enduro Racing Team", Pais.ITALIA,".\\res\\imgEscuderias\\Pertamina Enduro Racing Team.png",new Color(232,254,67),Color.WHITE);
        Moto moto13 = new Moto("72", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\VR46 Racing Team.png");
        Moto moto14 = new Moto("49", "Ducati", "Desmosedici GP24", ".\\res\\imgMotos\\VR46 Racing Team.png");
        Piloto piloto13 = new Piloto("Fabio Di Giannantonio", Pais.ITALIA, "Mooney VR46 Racing Team", generarPuntosAleatorios(), moto13, ".\\res\\imgPilotos\\Fabio Di Giannantonio.png");
        Piloto piloto14 = new Piloto("Marco Bezzecchi", Pais.ITALIA, "Mooney VR46 Racing Team", generarPuntosAleatorios(), moto14, ".\\res\\imgPilotos\\Marco Bezzecchi.png");
//        escuderia7.addPilotos(piloto13, piloto14);
        campeonato.addEscuderia(escuderia7);
        campeonato.addPilotos(piloto13, piloto14);

        // Repsol Honda Team
        Escuderia escuderia8 = new Escuderia("Repsol Honda Team", Pais.JAPÓN,".\\res\\imgEscuderias\\Repsol Honda Team.png",new Color(212,154,45),new Color(193,34,34));
        Moto moto15 = new Moto("10", "Honda", "RC213V", ".\\res\\imgMotos\\Repsol Honda Team.png");
        Moto moto16 = new Moto("36", "Honda", "RC213V", ".\\res\\imgMotos\\Repsol Honda Team.png");
        Piloto piloto15 = new Piloto("Luca Marini", Pais.ESPAÑA, "Repsol Honda Team", generarPuntosAleatorios(), moto15, ".\\res\\imgPilotos\\Luca Marini.png");
        Piloto piloto16 = new Piloto("Joan Mir", Pais.ESPAÑA, "Repsol Honda Team", generarPuntosAleatorios(), moto16, ".\\res\\imgPilotos\\Joan Mir.png");
//        escuderia8.addPilotos(piloto15, piloto16);
        campeonato.addEscuderia(escuderia8);
        campeonato.addPilotos(piloto15, piloto16);

        // LCR Honda
        Escuderia escuderia9 = new Escuderia("LCR Honda", Pais.JAPÓN,".\\res\\imgEscuderias\\LCR Honda.png",new Color(41,177,14),Color.WHITE);
        Moto moto17 = new Moto("5", "Honda", "RC213V", ".\\res\\imgMotos\\LCR Honda.png");
        Moto moto18 = new Moto("73", "Honda", "RC213V", ".\\res\\imgMotos\\LCR Honda.png");
        Piloto piloto17 = new Piloto("Takaaki Nakagami", Pais.JAPÓN, "LCR Honda", generarPuntosAleatorios(), moto17, ".\\res\\imgPilotos\\Takaaki Nakagami.png");
        Piloto piloto18 = new Piloto("Johann Zarco", Pais.ESPAÑA, "LCR Honda", generarPuntosAleatorios(), moto18, ".\\res\\imgPilotos\\Johann Zarco.png");
//        escuderia9.addPilotos(piloto17, piloto18);
        campeonato.addEscuderia(escuderia9);
        campeonato.addPilotos(piloto17, piloto18);

        // GasGas Factory Racing Tech3
        Escuderia escuderia10 = new Escuderia("GasGas Factory Racing Tech3", Pais.ESPAÑA,".\\res\\imgEscuderias\\GASGAS Factory Racing Tech3.png",new Color(227,75,75),new Color(237,45,113));
        Moto moto19 = new Moto("31", "GasGas", "RC16", ".\\res\\imgMotos\\Tech3 GasGas Factory Racing.png");
        Moto moto20 = new Moto("37", "GasGas", "RC16", ".\\res\\imgMotos\\Tech3 GasGas Factory Racing.png");
        Piloto piloto19 = new Piloto("Augusto Fernández", Pais.ESPAÑA, "GasGas Factory Racing Tech3", generarPuntosAleatorios(), moto19, ".\\res\\imgPilotos\\Augusto Fernández.png");
        Piloto piloto20 = new Piloto("Pedro Acosta", Pais.ESPAÑA, "GasGas Factory Racing Tech3", generarPuntosAleatorios(), moto20, ".\\res\\imgPilotos\\Pedro Acosta.png");
//        escuderia10.addPilotos(piloto19, piloto20);
        campeonato.addEscuderia(escuderia10);
        campeonato.addPilotos(piloto19, piloto20);

        // RNF MotoGP Team
        Escuderia escuderia11 = new Escuderia("Trackhouse Racing", Pais.USA,".\\res\\imgEscuderias\\Trackhouse Racing.png",Color.BLUE,Color.RED);
        Moto moto21 = new Moto("25", "Aprilia", "RS-GP", ".\\res\\imgMotos\\Trackhouse Racing.png");
        Moto moto22 = new Moto("88", "Aprilia", "RS-GP", ".\\res\\imgMotos\\Trackhouse Racing.png");
        Piloto piloto21 = new Piloto("Miguel Oliveira", Pais.ESPAÑA, "RNF MotoGP Team", generarPuntosAleatorios(), moto21, ".\\res\\imgPilotos\\Miguel Oliveira.png");
        Piloto piloto22 = new Piloto("Raúl Fernández", Pais.PORTUGAL, "RNF MotoGP Team", generarPuntosAleatorios(), moto22, ".\\res\\imgPilotos\\Raúl Fernández.png");
//        escuderia11.addPilotos(piloto21, piloto22);
        campeonato.addPilotos(piloto21, piloto22);
    }
    
    public int generarPuntosAleatorios() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(667);  //nextInt(667) genera un número entre 0 y 666
        return numeroAleatorio;
    }
    
    public void datosPruebaCircuito(Campeonato campeonato){
        
        campeonato.addCircuitos(new Circuito("Lusail International Circuit", "Qatar", 5.38,".\\res\\imgCircuito\\Lusail International Circuit.png"));
        campeonato.addCircuitos(new Circuito("Autódromo Internacional do Algarve", "Portugal", 4.59,".\\res\\imgCircuito\\Autódromo Internacional do Algarve.png"));
        campeonato.addCircuitos(new Circuito("Circuit of the Americas", "Estados Unidos", 5.51,".\\res\\imgCircuito\\Circuit of the Americas.png"));
        campeonato.addCircuitos(new Circuito("Circuito de Jerez – Ángel Nieto", "España", 4.42,".\\res\\imgCircuito\\Circuito de Jerez.png"));
        campeonato.addCircuitos(new Circuito("Le Mans", "Francia", 4.18,".\\res\\imgCircuito\\Le Mans.png"));//
        campeonato.addCircuitos(new Circuito("Circuit de Barcelona-Catalunya", "España", 4.63,".\\res\\imgCircuito\\Circuit de Barcelona Catalunya.png"));
        campeonato.addCircuitos(new Circuito("Autodromo Internazionale del Mugello", "Italia", 5.25,".\\res\\imgCircuito\\Autodromo del Mugello.png"));
        campeonato.addCircuitos(new Circuito("TT Circuit Assen", "Países Bajos", 4.54,".\\res\\imgCircuito\\TT Circuit Assen.png"));
        campeonato.addCircuitos(new Circuito("Sachsenring", "Alemania", 3.67,".\\res\\imgCircuito\\Sachsenring.png"));
        campeonato.addCircuitos(new Circuito("Silverstone Circuit", "Reino Unido", 5.89,".\\res\\imgCircuito\\Silverstone.png"));
        campeonato.addCircuitos(new Circuito("Red Bull Ring – Spielberg", "Austria", 4.32,".\\res\\imgCircuito\\Red Bull Ring.png"));
        campeonato.addCircuitos(new Circuito("MotorLand Aragón", "España", 5.08,".\\res\\imgCircuito\\MotorLand Aragon.png"));
        campeonato.addCircuitos(new Circuito("Pertamina Mandalika International Circuit", "Indonesia", 4.31,".\\res\\imgCircuito\\Pertamina Mandalika International Circuit.png"));
        campeonato.addCircuitos(new Circuito("Mobility Resort Motegi", "Japón", 4.80,".\\res\\imgCircuito\\Mobility Resort Motegi.png"));
        campeonato.addCircuitos(new Circuito("Phillip Island", "Australia", 4.45,".\\res\\imgCircuito\\Phillip Island.png"));
        campeonato.addCircuitos(new Circuito("Chang International Circuit", "Tailandia", 4.55,".\\res\\imgCircuito\\Chang International Circuit.png"));
        campeonato.addCircuitos(new Circuito("Sepang International Circuit", "Malasia", 5.54,".\\res\\imgCircuito\\Sepang International Circuit.png"));
        campeonato.addCircuitos(new Circuito("Circuit Ricardo Tormo", "España", 4.00,".\\res\\imgCircuito\\Circuit Ricardo Tormo.png"));
    }

    private void modoGrafico() {
        Vpal vpal = new Vpal(campeonato2024);
        vpal.setVisible(true);
    }
}
    

