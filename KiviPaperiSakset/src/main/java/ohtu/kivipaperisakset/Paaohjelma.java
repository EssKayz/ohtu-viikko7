package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean pelataan = true;
        while (pelataan) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            PeliInterface peli = null;
            String vastaus = scanner.nextLine();

            switch (vastaus) {
                case "a": {
                    peli = new KPSPeli(null, scanner);
                    break;
                }
                case "b": {
                    peli = new KPSPeli(new TekoalyParannettu(20), scanner);
                    break;
                }
                case "c": {
                    peli = new KPSPeli(new Tekoaly(), scanner);
                    break;
                }
                default:
                    pelataan = false;
                    continue;
            }
            if (peli != null) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                peli.pelaa();
            }

        }

    }
}
