/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Vaja 29 - Podatki za ustvarjanje vseh objektov in klicanje vseh metod so brani iz ukazne konzole - razširitev Vaje 28
 */

// Uvozimo razred Scanner za branje vhoda iz konzole
import java.util.Scanner;

/**
 * Glavni program za prikaz objektno orientiranega programiranja s hladilniki.
 * Omogoča ustvarjanje različnih vrst hladilnikov in interakcijo z njimi preko
 * ukazne konzole.
 */



public class GlavniProgramHladilnik {

    public static void main(String[] args) throws Exception {
        // Ustvarimo objekt Scanner za branje vhoda
		Scanner scanner = new Scanner(System.in);

        // Zanka se bo izvajala neskončno, dokler uporabnik ne izbere izhoda
		while (true) {
            // Izpišemo meni za izbiro vrste hladilnika
			System.out.println("\nIzberite vrsto hladilnika:");
            System.out.println("1: Običajen hladilnik");
            System.out.println("2: Hladilnik z zamrzovalnikom");
            System.out.println("3: Pametni hladilnik");
            System.out.println("0: Izhod");

            // Preberemo uporabnikovo izbiro
			int izbira = scanner.nextInt();
            // Porabimo preostanek vrstice (pomembno po klicu nextInt())
			scanner.nextLine();

            // Če je uporabnik izbral izhod prekinemo zanko in zaključimo program
			if (izbira == 0) {
                break;
            }
			
			try {
			// Ustvarimo objekt hladilnika
			Hladilnik hladilnik = ustvariHladilnik(izbira, scanner);

            // Če je bil hladilnik uspešno ustvarjen (izbira veljavna)
			if (hladilnik != null) {
                
				// Začnemo interakcijo z izbranim hladilnikom
				interakcijaZHladilnikom(hladilnik, scanner);
            }
        } catch (Exception e) {
			//interakcijaZHladilnikom(hladilnik, scanner);
			System.out.println("Napaka pri ustvarjanju hladilnika: " + e);
		}
			
		}
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
    private static Hladilnik ustvariHladilnik(int izbira, Scanner scanner) throws Exception{
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
				throw new Exception("Neveljavna izbira!");
				//System.out.println("Neveljavna izbira!");
                //return null;
        }
    }

    /**
     * Omogoča interakcijo z izbranim hladilnikom preko ukazne konzole.
     * 
     * @param hladilnik Objekt hladilnika, s katerim interagiramo.
     * @param scanner Bralnik za vnos podatkov iz konzole.
     */
    private static void interakcijaZHladilnikom(Hladilnik hladilnik, Scanner scanner) throws Exception{
        
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
    private static void izvediDejanje(Hladilnik hladilnik, int dejanje, Scanner scanner) throws Exception{
        // Izvedemo ustrezno dejanje glede na izbiro
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
				 throw new Exception("Neveljavno dejanje!"); // Uporabili smo "throw
                // System.out.println("Neveljavno dejanje!");
        }
    }