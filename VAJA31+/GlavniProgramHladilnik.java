/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Vaja 31* - Podatki za ustvarjanje vseh objektov in klicanje vseh 
 *					   metode so brane iz ukazne konzole in dedovanje smiselno ustvarjene podrazrede razreda Exception - razširitev Vaje 30
 */
import java.util.Scanner;

/**
 * Glavni program za prikaz objektno orientiranega programiranja s hladilniki.
 * Omogoča ustvarjanje različnih vrst hladilnikov in interakcijo z njimi preko
 * ukazne konzole.
 */

public class GlavniProgramHladilnik {

    public static void main(String[] args) {
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
            int izbira = 0;
            
			while (true) {
                if (scanner.hasNextInt()) {
                    izbira = scanner.nextInt();
                    scanner.nextLine();  // porabi preostanek vrstice
                    if (izbira >= 0 && izbira <= 3) {
                        break;  // Prekinemo zanko, ko je vnos veljaven
                    } else {
                        System.out.println("Napaka: Vnesite veljavno številko (0-3)!");
                    }
                } else {
                    System.out.println("Napaka: Vnesite veljavno številko (0-3)!");
                    scanner.nextLine();  // Preberemo napačen vnos in nadaljujemo
                }
            }

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

                // Lovljenje izjem
            } catch (NeveljavnaIzbiraException | NeveljavnoDejanjeException e) {
                System.out.println("Napaka: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Napaka pri ustvarjanju hladilnika: " + e);
            }
        }

        // Zapremo bralnik, da sprostimo vire
        scanner.close();
    }

    /**
     * Ustvari ustrezen objekt hladilnika glede na izbiro uporabnika.
     *
     * @param izbira  Izbira vrste hladilnika (1, 2 ali 3).
     * @param scanner Bralnik za vnos podatkov iz konzole.
     * @return Objekt hladilnika ustrezne vrste ali null, če je izbira neveljavna.
     */
    private static Hladilnik ustvariHladilnik(int izbira, Scanner scanner) throws NeveljavnaIzbiraException, Exception {
        System.out.println("Vnesite znamko hladilnika:");

        // Preberemo znamko hladilnika
        String znamka = scanner.nextLine();
        System.out.println("Vnesite kapaciteto hladilnika (v litrih):");
        int kapaciteta = 0;

        // Preverimo, ali je uporabnik vnesel veljavno celo število za kapaciteto hladilnika
        while (true) {

            // Preverimo, ali je vnos številka
            if (scanner.hasNextInt()) {

                // Če je vnos številka, jo shranimo v spremenljivko 'kapaciteta'
                kapaciteta = scanner.nextInt();

                // Porabimo preostali del vrstice (če je prisotna dodatna vsebina po številki)
                scanner.nextLine();

                // Prekinemo zanko, ko je bil vnos veljaven
                break;

                // Če uporabnik ni vnesel veljavnega števila, izpišemo napako
            } else {
                // Preberemo napačen vnos in nadaljujemo z novim vprašanjem
                System.out.println("Napaka: Vnesite veljavno številko za kapaciteto!");
                scanner.nextLine();
            }
        }

        switch (izbira) {
            case 1:
                return new Hladilnik(znamka, kapaciteta);
            case 2:
                return new HladilnikZZamrzovalnikom(znamka, kapaciteta);
            case 3:
                return new PametniHladilnik(znamka, kapaciteta);
            default:
                throw new NeveljavnaIzbiraException("Neveljavna izbira hladilnika!");
        }
    }

    /**
     * Omogoča interakcijo z izbranim hladilnikom preko ukazne konzole.
     *
     * @param hladilnik Objekt hladilnika, s katerim interagiramo.
     * @param scanner   Bralnik za vnos podatkov iz konzole.
     */
    private static void interakcijaZHladilnikom(Hladilnik hladilnik, Scanner scanner) throws NeveljavnoDejanjeException, Exception {

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
            int dejanje = 0;
            while (true) {
                if (scanner.hasNextInt()) {
                    dejanje = scanner.nextInt();
                    scanner.nextLine();  // porabi preostanek vrstice
                    if (dejanje >= 0 && dejanje <= 7) {
                        break;  // Prekinemo zanko, ko je vnos veljaven
                    } else {
                        System.out.println("Napaka: Vnesite veljavno številko (0-7)!");
                    }
                } else {
                    System.out.println("Napaka: Vnesite veljavno številko (0-7)!");
                    scanner.nextLine();  // Preberemo napačen vnos in nadaljujemo
                }
            }

            // Če je uporabnik izbral vrnitev na izbiro hladilnika
            if (dejanje == 0) {

                // Prekinemo zanko in se vrnemo na glavni meni
                break;
            }

            try {
                // Izvedemo izbrano dejanje
                izvediDejanje(hladilnik, dejanje, scanner);
            } catch (Exception e) {
                 System.out.println("Napaka pri izvajanju dejanja: " + e);
            }
        }
    }

    /**
     * Izvede izbrano dejanje na hladilniku.
     *
     * @param hladilnik Objekt hladilnika, na katerem izvajamo dejanje.
     * @param dejanje   Izbira dejanja (1-7).
     * @param scanner   Bralnik za vnos podatkov iz konzole.
     */
    private static void izvediDejanje(Hladilnik hladilnik, int dejanje, Scanner scanner) throws NeveljavnoDejanjeException, Exception {
        // Izvedemo ustrezno dejanje glede na izbiro
        switch (dejanje) {
            case 1:
                // Vključimo hladilnik - prva možnost
                hladilnik.vkljuci();
                break;
            case 2:
                // Izključimo hladilnik - druga možnost
                hladilnik.izkljuci();
                break;
            case 3:
                // Poveačnje temperature
                System.out.println("Vnesite število stopinj za povečanje temperature (največ 10 stopinj):");
                // Preberemo število stopinj za povečanje temperature
                int stopinje = 0;
                while (true) {
                    if (scanner.hasNextInt()) {
                        stopinje = scanner.nextInt();
                        // Porabi preostanek vrstice
                        scanner.nextLine();

                        // Vnešena tempetaru ne sme presegati 10 stopinj
                        if (stopinje >= 1 && stopinje <= 10) {
                            // Prekinemo zanko, ko je vnos veljaven
                            break;
                        } else {
                            // Napaka, če je število zunaj dovoljenega obsega
                            System.out.println("Napaka: Vnesite število stopinj med 1 in 10!");
                        }

                    } else {
                        // Izpis napaka pri napačnem vnosu
                        System.out.println("Napaka: Vnesite veljavno število stopinj!");
                        // Preberemo napačen vnos in nadaljujemo
                        scanner.nextLine();
                    }
                }
                // Povečamo temperaturo
                hladilnik.povecajTemperaturo(stopinje);
                break;
            case 4:
                System.out.println("Vnesite število stopinj za zmanjšanje temperature:");
                // Preberemo število stopinj za zmanjšanje
                stopinje = 0;
                while (true) {
                    if (scanner.hasNextInt()) {
                        stopinje = scanner.nextInt();
                        // Porabi preostanek vrstice
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Napaka: Vnesite veljavno število stopinj!");
                        // Preberemo napačen vnos in nadaljujemo
                        scanner.nextLine();
                    }
                }

                // Zmanjšamo temperaturo
                hladilnik.zmanjsajTemperaturo(stopinje);
                break;
            case 5:
                // Če gre za hladilnik z zamrzovalnikom
                if (hladilnik instanceof HladilnikZZamrzovalnikom) {
                    System.out.println("Vnesite število stopinj za spremembo temperature v zamrzovalniku:");

                    // Preberemo število stopinj za spremembo temperature v zamrzovalniku
                    stopinje = 0;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            stopinje = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Napaka: Vnesite veljavno število stopinj!");
                            // Preberemo napačen vnos in nadaljujemo
                            scanner.nextLine();
                        }
                    }
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
                throw new NeveljavnoDejanjeException("Neveljavno dejanje!");
        }
    }
}

// Definicije podrazredov izjem
class NeveljavnaIzbiraException extends Exception {
    public NeveljavnaIzbiraException(String sporocilo) {
        super(sporocilo);
    }
}

class NeveljavnoDejanjeException extends Exception {
    public NeveljavnoDejanjeException(String sporocilo) {
        super(sporocilo);
    }
}