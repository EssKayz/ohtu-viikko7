/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author ColdFish
 */
public class KPSPeli implements PeliInterface {

    private TekoalyIntf tekoaly;
    private Scanner scanner;

    public KPSPeli(TekoalyIntf tekoaly, Scanner scan) {
        this.tekoaly = tekoaly;
        scanner = scan;
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto;

        tokanSiirto = annaToisenPelaajanSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = annaToisenPelaajanSiirto();
            if (tekoaly != null) {
                tekoaly.asetaSiirto(ekanSiirto);
            }

            System.out.println();
            System.out.println("Kiitos!");
            System.out.println(tuomari);
        }
    }

    private String annaToisenPelaajanSiirto() {
        String tokanSiirto;
        if (tekoaly != null) {
            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
        } else {
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }
        return tokanSiirto;
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
