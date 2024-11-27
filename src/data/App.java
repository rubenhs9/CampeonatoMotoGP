
package data;

import GUI.Vpal;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        Escuderia escuderia1 = new Escuderia("Ducati Lenovo Team", "Italia",".\\res\\imgEscuderias\\Ducati Lenovo Team.png");
        Moto moto1 = new Moto("1", "Ducati", "Desmosedici GP24");
        Moto moto2 = new Moto("23", "Ducati", "Desmosedici GP24");
        Piloto piloto1 = new Piloto("Francesco Bagnaia", "Italia", "Ducati Lenovo Team", 0, moto1);
        Piloto piloto2 = new Piloto("Enea Bastianini", "Italia", "Ducati Lenovo Team", 0, moto2);
        escuderia1.addPilotos(piloto1, piloto2);
        campeonato.addEscuderia(escuderia1);

        // Red Bull KTM Factory Racing
        Escuderia escuderia2 = new Escuderia("Red Bull KTM Factory Racing", "Austria",".\\res\\imgEscuderias\\Red Bull KTM Factory Racing.png");
        Moto moto3 = new Moto("33", "KTM", "RC16");
        Moto moto4 = new Moto("43", "KTM", "RC16");
        Piloto piloto3 = new Piloto("Brad Binder", "Sudáfrica", "Red Bull KTM Factory Racing", 0, moto3);
        Piloto piloto4 = new Piloto("Jack Miller", "Australia", "Red Bull KTM Factory Racing", 0, moto4);
        escuderia2.addPilotos(piloto3, piloto4);
        campeonato.addEscuderia(escuderia2);

        // Aprilia Racing
        Escuderia escuderia3 = new Escuderia("Aprilia Racing", "Italia",".\\res\\imgEscuderias\\Aprilia Racing.png");
        Moto moto5 = new Moto("41", "Aprilia", "RS-GP");
        Moto moto6 = new Moto("12", "Aprilia", "RS-GP");
        Piloto piloto5 = new Piloto("Aleix Espargaró", "España", "Aprilia Racing", 0, moto5);
        Piloto piloto6 = new Piloto("Maverick Viñales", "España", "Aprilia Racing", 0, moto6);
        escuderia3.addPilotos(piloto5, piloto6);
        campeonato.addEscuderia(escuderia3);

        // Prima Pramac Racing
        Escuderia escuderia4 = new Escuderia("Prima Pramac Racing", "Italia",".\\res\\imgEscuderias\\Prima Pramac Racing.png");
        Moto moto7 = new Moto("89", "Ducati", "Desmosedici GP24");
        Moto moto8 = new Moto("21", "Ducati", "Desmosedici GP24");
        Piloto piloto7 = new Piloto("Jorge Martín", "España", "Prima Pramac Racing", 0, moto7);
        Piloto piloto8 = new Piloto("Franco Morbidelli", "Italia", "Prima Pramac Racing", 0, moto8);
        escuderia4.addPilotos(piloto7, piloto8);
        campeonato.addEscuderia(escuderia4);

        // Monster Energy Yamaha MotoGP
        Escuderia escuderia5 = new Escuderia("Monster Energy Yamaha MotoGP", "Japón",".\\res\\imgEscuderias\\Monster Energy Yamaha MotoGP.png");
        Moto moto9 = new Moto("20", "Yamaha", "YZR-M1");
        Moto moto10 = new Moto("42", "Yamaha", "YZR-M1");
        Piloto piloto9 = new Piloto("Fabio Quartararo", "Francia", "Monster Energy Yamaha MotoGP", 0, moto9);
        Piloto piloto10 = new Piloto("Álex Rins", "España", "Monster Energy Yamaha MotoGP", 0, moto10);
        escuderia5.addPilotos(piloto9, piloto10);
        campeonato.addEscuderia(escuderia5);

        // Gresini Racing MotoGP
        Escuderia escuderia6 = new Escuderia("Gresini Racing MotoGP", "Italia",".\\res\\imgEscuderias\\Gresini Racing MotoGP.png");
        Moto moto11 = new Moto("93", "Ducati", "Desmosedici GP24");
        Moto moto12 = new Moto("73", "Ducati", "Desmosedici GP24");
        Piloto piloto11 = new Piloto("Marc Márquez", "Italia", "Gresini Racing MotoGP", 0, moto11);
        Piloto piloto12 = new Piloto("Álex Márquez", "España", "Gresini Racing MotoGP", 0, moto12);
        escuderia6.addPilotos(piloto11, piloto12);
        campeonato.addEscuderia(escuderia6);

        // Mooney VR46 Racing Team
        Escuderia escuderia7 = new Escuderia("Pertamina Enduro Racing Team", "Italia",".\\res\\imgEscuderias\\Pertamina Enduro Racing Team.png");
        Moto moto13 = new Moto("72", "Ducati", "Desmosedici GP24");
        Moto moto14 = new Moto("49", "Ducati", "Desmosedici GP24");
        Piloto piloto13 = new Piloto("Marco Bezzecchi", "Italia", "Mooney VR46 Racing Team", 0, moto13);
        Piloto piloto14 = new Piloto("Fabio Di Giannantonio", "Italia", "Mooney VR46 Racing Team", 0, moto14);
        escuderia7.addPilotos(piloto13, piloto14);
        campeonato.addEscuderia(escuderia7);

        // Repsol Honda Team
        Escuderia escuderia8 = new Escuderia("Repsol Honda Team", "Japón",".\\res\\imgEscuderias\\Repsol Honda Team.png");
        Moto moto15 = new Moto("10", "Honda", "RC213V");
        Moto moto16 = new Moto("36", "Honda", "RC213V");
        Piloto piloto15 = new Piloto("Luca Marini", "España", "Repsol Honda Team", 0, moto15);
        Piloto piloto16 = new Piloto("Joan Mir", "España", "Repsol Honda Team", 0, moto16);
        escuderia8.addPilotos(piloto15, piloto16);
        campeonato.addEscuderia(escuderia8);

        // LCR Honda
        Escuderia escuderia9 = new Escuderia("LCR Honda", "Japón",".\\res\\imgEscuderias\\LCR Honda.png");
        Moto moto17 = new Moto("5", "Honda", "RC213V");
        Moto moto18 = new Moto("73", "Honda", "RC213V");
        Piloto piloto17 = new Piloto("Takaaki Nakagami", "Japón", "LCR Honda", 0, moto17);
        Piloto piloto18 = new Piloto("Johann Zarco", "España", "LCR Honda", 0, moto18);
        escuderia9.addPilotos(piloto17, piloto18);
        campeonato.addEscuderia(escuderia9);

        // GasGas Factory Racing Tech3
        Escuderia escuderia10 = new Escuderia("GasGas Factory Racing Tech3", "España",".\\res\\imgEscuderias\\GASGAS Factory Racing Tech3.png");
        Moto moto19 = new Moto("31", "GasGas", "RC16");
        Moto moto20 = new Moto("37", "GasGas", "RC16");
        Piloto piloto19 = new Piloto("Augusto Fernández", "España", "GasGas Factory Racing Tech3", 0, moto19);
        Piloto piloto20 = new Piloto("Pedro Acosta", "España", "GasGas Factory Racing Tech3", 0, moto20);
        escuderia10.addPilotos(piloto19, piloto20);
        campeonato.addEscuderia(escuderia10);

        // RNF MotoGP Team
        Escuderia escuderia11 = new Escuderia("Trackhouse Racing", "Malasia",".\\res\\imgEscuderias\\Trackhouse Racing.png");
        Moto moto21 = new Moto("25", "Aprilia", "RS-GP");
        Moto moto22 = new Moto("88", "Aprilia", "RS-GP");
        Piloto piloto21 = new Piloto("Raúl Fernández", "España", "RNF MotoGP Team", 0, moto21);
        Piloto piloto22 = new Piloto("Miguel Oliveira", "Portugal", "RNF MotoGP Team", 0, moto22);
        escuderia11.addPilotos(piloto21, piloto22);
        campeonato.addEscuderia(escuderia11);
    }
    
    public void datosPruebaCircuito(Campeonato campeonato){
        
        campeonato.addCircutios(new Circuito("Lusail International Circuit", "Qatar", 5.38,".\\res\\imgCircuitos\\circuitoQatar.png"));
        campeonato.addCircutios(new Circuito("Autódromo Internacional do Algarve", "Portugal", 4.59,".\\res\\imgCircuitos\\circuitoPortugal.png"));
        campeonato.addCircutios(new Circuito("Circuit of the Americas", "Estados Unidos", 5.51,".\\res\\imgCircuitos\\circuitoAmerica.png"));
        campeonato.addCircutios(new Circuito("Circuito de Jerez – Ángel Nieto", "España", 4.42,".\\res\\imgCircuitos\\circuitoEspaña.png"));
        campeonato.addCircutios(new Circuito("Le Mans", "Francia", 4.18,".\\res\\imgCircuitos\\circuitoFrancia.png"));
        campeonato.addCircutios(new Circuito("Circuit de Barcelona-Catalunya", "España", 4.63,".\\res\\imgCircuitos\\circuitoCataluña.png"));
        campeonato.addCircutios(new Circuito("Autodromo Internazionale del Mugello", "Italia", 5.25,".\\res\\imgCircuitos\\circuitoItalia.png"));
        campeonato.addCircutios(new Circuito("TT Circuit Assen", "Países Bajos", 4.54,".\\res\\imgCircuitos\\circuitoHolanda.png"));
        campeonato.addCircutios(new Circuito("Sachsenring", "Alemania", 3.67,".\\res\\imgCircuitos\\circuitoAlemania.png"));
        campeonato.addCircutios(new Circuito("Silverstone Circuit", "Reino Unido", 5.89,".\\res\\imgCircuitos\\circuitoUK.png"));
        campeonato.addCircutios(new Circuito("Red Bull Ring – Spielberg", "Austria", 4.32,".\\res\\imgCircuitos\\circuitoAustria.png"));
        campeonato.addCircutios(new Circuito("MotorLand Aragón", "España", 5.08,".\\res\\imgCircuitos\\circuitoAragon.png"));
        campeonato.addCircutios(new Circuito("Pertamina Mandalika International Circuit", "Indonesia", 4.31,".\\res\\imgCircuitos\\circuitoIndonesia.png"));
        campeonato.addCircutios(new Circuito("Mobility Resort Motegi", "Japón", 4.80,".\\res\\imgCircuitos\\circuitoJapon.png"));
        campeonato.addCircutios(new Circuito("Phillip Island", "Australia", 4.45,".\\res\\imgCircuitos\\circuitoAustralia.png"));
        campeonato.addCircutios(new Circuito("Chang International Circuit", "Tailandia", 4.55,".\\res\\imgCircuitos\\circuitoTailandia.png"));
        campeonato.addCircutios(new Circuito("Sepang International Circuit", "Malasia", 5.54,".\\res\\imgCircuitos\\circuitoMalasia.png"));
        campeonato.addCircutios(new Circuito("Circuit Ricardo Tormo", "España", 4.00,".\\res\\imgCircuitos\\circuitoValencia.png"));
    }

    private void modoGrafico() {
        Vpal vpal = new Vpal(campeonato2024);
        vpal.setVisible(true);
    }
}
    

