import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Vaja 33 - Podatki za ustvarjanje vseh objektov in klicanje vseh metod so brani iz ukazne konzole - razširitev Vaje 28
 */

/**
 * Glavni program za prikaz objektno orientiranega programiranja s hladilniki.
 * Omogoča ustvarjanje različnih vrst hladilnikov in interakcijo z njimi preko
 * ukazne konzole. Vsi objekti se zapisujejo v dinamični seznam.
 */
public class GlavniProgramHladilnik {

    // Dinamični seznam za shranjevanje objektov hladilnikov
    private static List<Hladilnik> hladilniki = new ArrayList<>();
	
	// V seznam dodamo še nekaj anonimnih objekov-hladilnikov
    static {
        hladilniki.add(new Hladilnik("Gorenje", 550));
        hladilniki.add(new HladilnikZZamrzovalnikom("Bosch", 600));
        hladilniki.add(new PametniHladilnik("Samsung", 500));
    }
	
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
			
			

        // Zanka se bo izvajala neskončno, dokler uporabnik ne izbere izhoda
        while (true) {
            // Izpišemo meni za izbiro vrste hladilnika
            System.out.println("\nIzberite vrsto hladilnika:");
            System.out.println("1: Običajen hladilnik");
            System.out.println("2: Hladilnik z zamrzovalnikom");
            System.out.println("3: Pametni hladilnik");
            System.out.println("4: Izpiši vse hladilnike"); // Nova možnost
            System.out.println("0: Izhod");

            // Preberemo uporabnikovo izbiro
            int izbira = scanner.nextInt();

            // Porabimo preostanek vrstice (pomembno po klicu nextInt())
            scanner.nextLine();
			
			// Če je uporabnik izbral izhod prekinemo zanko in zaključimo program
            if (izbira == 0) {
                break;
            }

            if (izbira == 4) { // Če je uporabnik izbral izpis
                izpisiHladilnike(); // Klic metode za izpis
                continue; // Nadaljujemo z naslednjo iteracijo zanke
            }

            // Ustvarimo objekt hladilnika
            Hladilnik hladilnik = ustvariHladilnik(izbira, scanner);

            // Če je bil hladilnik uspešno ustvarjen (izbira veljavna)
            if (hladilnik != null) {
                // Dodamo hladilnik v seznam
                hladilniki.add(hladilnik);

                // Začnemo interakcijo z izbranim hladilnikom
                interakcijaZHladilnikom(hladilnik, scanner);
            }
			
			// Izpišemo število hladilnikov na seznamu
			System.out.println("V seznamu je " + hladilniki.size() + " hladilnikov.");
        }

        // Zapremo bralnik, da sprostimo vire
        scanner.close();
    }

    /**
     * Ustvari ustrezen objekt hladilnika glede na izbiro uporabnika.
     *
     * @param izbira Izbira vrste hladilnika (1, 2 ali 3).
     * @param scanner Bralnik za vnos podatkov iz konzole.
     * @return Objekt hladilnika ustrezne vrste ali null, če je izbira neveljavna.
     */
    private static Hladilnik ustvariHladilnik(int izbira, Scanner scanner) {
        System.out.println("Vnesite znamko hladilnika:");

        // Preberemo znamko hladilnika
        String znamka = scanner.nextLine();
        System.out.println("Vnesite kapaciteto hladilnika (v litrih):");

        // Preberemo kapaciteto hladilnika
        int kapaciteta = scanner.nextInt();

        // Porabimo preostanek vrstice
        scanner.nextLine();

        // Izberemo ustrezno vrsto hladilnika glede na izbiro
        switch (izbira) {
            case 1:
                // Ustvarimo običajen hladilnik
                return new Hladilnik(znamka, kapaciteta);
            case 2:
                // Ustvarimo hladilnik z zamrzovalnikom
                return new HladilnikZZamrzovalnikom(znamka, kapaciteta);
            case 3:
                // Ustvarimo pametni hladilnik
                return new PametniHladilnik(znamka, kapaciteta);
            default:
                // Izpišemo sporočilo o neveljavni izbiri
                System.out.println("Neveljavna izbira!");
                return null;
        }
    }

    /**
     * Omogoča interakcijo z izbranim hladilnikom preko ukazne konzole.
     *
     * @param hladilnik Objekt hladilnika, s katerim interagiramo.
     * @param scanner Bralnik za vnos podatkov iz konzole.
     */
    private static void interakcijaZHladilnikom(Hladilnik hladilnik, Scanner scanner) {

        // Zanka za interakcijo z izbranim hladilnikom
        while (true) {

            // Izpišemo meni z dejanji, kaj želimo, da se zgodi z našim izbranim hladilnikom
            System.out.println("\nIzberite dejanje:");
            System.out.println("1: Vključi hladilnik");
            System.out.println("2: Izključi hladilnik");
            System.out.println("3: Povečaj temperaturo");
            System.out.println("4: Zmanjšaj temperaturo");

            // Če gre za hladilnik z zamrzovalnikom
            if (hladilnik instanceof HladilnikZZamrzovalnikom) {
                System.out.println("5: Spremeni temperaturo zamrzovalnika");
            }

            // Če gre za pametni hladilnik
            if (hladilnik instanceof PametniHladilnik) {
                System.out.println("6: Poveži na internet");
                System.out.println("7: Odjavi z interneta");
            }

            // Možnost vrnitve na izbiro hladilnika
            System.out.println("0: Nazaj na izbiro hladilnika");

            // Preberemo uporabnikovo izbiro dejanja
            int dejanje = scanner.nextInt();

            // Porabimo preostanek vrstice
            scanner.nextLine();

            // Če je uporabnik izbral vrnitev na izbiro hladilnika
            if (dejanje == 0) {

                // Prekinemo zanko in se vrnemo na glavni meni
                break;
            }

            // Izvedemo izbrano dejanje
            izvediDejanje(hladilnik, dejanje, scanner);
        }
    }

    /**
     * Izvede izbrano dejanje na hladilniku.
     *
     * @param hladilnik Objekt hladilnika, na katerem izvajamo dejanje.
     * @param dejanje Izbira dejanja (1-7).
     * @param scanner Bralnik za vnos podatkov iz konzole.
     */
    private static void izvediDejanje(Hladilnik hladilnik, int dejanje, Scanner scanner) {
        // Izvedemo ustrezno dejanje glede na izbiro
       try {
		switch (dejanje) {
            case 1:
                // Vključimo hladilnik
                hladilnik.vkljuci();
                break;
            case 2:
                // Izključimo hladilnik
                hladilnik.izkljuci();
                break;
            case 3:
                System.out.println("Vnesite število stopinj za povečanje temperature:");

                // Preberemo število stopinj za povečanje temperature
                int stopinje = scanner.nextInt();
                // Porabimo preostanek vrstice
                scanner.nextLine();
                hladilnik.povecajTemperaturo(stopinje);
                break;
            case 4:
                System.out.println("Vnesite število stopinj za zmanjšanje temperature:");

                // Preberemo število stopinj za zmanjšanje
                stopinje = scanner.nextInt();
                // Porabimo preostanek vrstice
                scanner.nextLine();
                // Zmanjšamo temperaturo
                hladilnik.zmanjsajTemperaturo(stopinje);
                break;
				case 5:
                // Če gre za hladilnik z zamrzovalnikom
                if (hladilnik instanceof HladilnikZZamrzovalnikom) {
                    System.out.println("Vnesite število stopinj za spremembo temperature v zamrzovalniku:");
                    // Preberemo število stopinj za spremembo temperature v zamrzovalniku
                    stopinje = scanner.nextInt();
                    // Porabimo preostanek vrstice
                    scanner.nextLine();

                    // Spremenimo temperaturo v zamrzovalniku
                    ((HladilnikZZamrzovalnikom) hladilnik).spremeniTemperaturoZamrzovalnika(stopinje);
                }
                break;
            case 6:

                // Če gre za pametni hladilnik
                if (hladilnik instanceof PametniHladilnik) {

                    // Povežemo hladilnik na internet
                    ((PametniHladilnik) hladilnik).poveziNaInternet();
                }
                break;
            case 7:

                // Če gre za pametni hladilnik
                if (hladilnik instanceof PametniHladilnik) {

                    // Odjavim pametni hladilnik z interneta
                    ((PametniHladilnik) hladilnik).odjaviZInterneta();
                }

                // Preveri, ali je dejanje veljavno. V primeru neveljavnega dejanja izpiši ustrezno sporočilo
                break;
            default:
                System.out.println("Neveljavno dejanje!");
        }
	   } catch (Exception e) {
		  System.out.println("Napaka pri izvajanju dejanja: " + e); 
    }
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
                System.out.println((i + 1) + ". " + hladilnik.toString()); // Predpostavljamo, da ima Hladilnik metodo toString()
            }
        }
    }
}