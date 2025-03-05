import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Glavni program za prikaz objektno orientiranega programiranja s hladilniki.
 * Omogoča ustvarjanje različnih vrst hladilnikov in interakcijo z njimi preko
 * ukazne konzole.
 */
public class GlavniProgramHladilnik {

    // Dinamični seznam za shranjevanje objektov hladilnikov
    private static List<Hladilnik> hladilniki = new ArrayList<>();

    public static void main(String[] args) {
        // Ustvarimo objekt Scanner za branje vhoda
        Scanner scanner = new Scanner(System.in);

        // Zanka za vnos hladilnikov, dokler uporabnik ne vnese prazne vrstice
        while (true) {
            System.out.println("\nVnesite znamko hladilnika (prazna vrstica za konec):");
            String znamka = scanner.nextLine();

            // Če je uporabnik vnesel prazno vrstico, prekinemo zanko
            if (znamka.isEmpty()) {
                break;
            }

            System.out.println("Vnesite kapaciteto hladilnika (v litrih):");
            int kapaciteta = scanner.nextInt();
            scanner.nextLine(); // Porabimo preostanek vrstice

            System.out.println("Izberite vrsto hladilnika (1: Običajen, 2: Z zamrzovalnikom, 3: Pametni):");
            int vrsta = scanner.nextInt();
            scanner.nextLine(); // Porabimo preostanek vrstice

            Hladilnik hladilnik = null;
            switch (vrsta) {
                case 1:
                    hladilnik = new Hladilnik(znamka, kapaciteta);
                    break;
                case 2:
                    hladilnik = new HladilnikZZamrzovalnikom(znamka, kapaciteta);
                    break;
                case 3:
                    hladilnik = new PametniHladilnik(znamka, kapaciteta);
                    break;
                default:
                    System.out.println("Neveljavna izbira vrste hladilnika.");
                    continue; // Nadaljujemo z naslednjo iteracijo zanke
            }

            // Dodamo hladilnik v seznam
            hladilniki.add(hladilnik);
            System.out.println("Hladilnik dodan v seznam.");
        }

        // Izpišemo vse hladilnike v seznamu
        izpisiHladilnike();

        // Zapremo bralnik, da sprostimo vire
        scanner.close();
    }

    /**
     * Izpiše vse hladilnike v seznamu.
     */
    private static void izpisiHladilnike() {
        if (hladilniki.isEmpty()) {
            System.out.println("Seznam hladilnikov je prazen.");
        } else {
            System.out.println("\nSeznam hladilnikov:");
            for (int i = 0; i < hladilniki.size(); i++) {
                Hladilnik hladilnik = hladilniki.get(i);
                System.out.println((i + 1) + ". " + hladilnik.toString());
            }
        }
    }
}