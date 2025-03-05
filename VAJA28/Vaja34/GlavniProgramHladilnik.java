import java.util.ArrayList;
import java.util.Scanner;

/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Vaja 28 - Razred hladilnik v Javi - razširitev Vaje 27, dodatna dva podrazreda
 */
public class GlavniProgramHladilnik {

    /**
     * Glavna metoda programa. Zažene se vedno ob zagonu.
     *
     * @param args Seznam argumentov iz ukazne vrstice
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Seznam za shranjevanje hladilnikov
        ArrayList<OsnovniHladilnik> hladilniki = new ArrayList<>();

        // Anonimni objekti hladilnikov
        hladilniki.add(new Hladilnik("Gorenje Retro", 250));
        hladilniki.add(new Hladilnik("Samsung NoFrost", 300));
        hladilniki.add(new Hladilnik("Bosch Serie 8", 200));

        // Zanka za dodajanje novih hladilnikov
        while (true) {
            // Vnos modela hladilnika
            System.out.println("Vnesite model hladilnika (ali vnesite 'konec' za zaključek):");
            String model = scanner.nextLine();
            if (model.equalsIgnoreCase("konec")) {
                break;  // Izhod iz zanke, ko uporabnik vpiše 'konec'
            }

            // Vnos kapacitete hladilnika
            System.out.println("Vnesite kapaciteto hladilnika (v litrih):");
            int kapaciteta = scanner.nextInt();
            scanner.nextLine(); // Porabi preostanek vrstice

            // Ustvarimo objekt hladilnika znotraj anonimnega objekta
            OsnovniHladilnik hladilnik = new Hladilnik(model, kapaciteta);
            hladilniki.add(hladilnik);  // Dodamo hladilnik v seznam

            // Vključimo hladilnik
            hladilnik.vkljuci();

            // Izbira povečanja ali zmanjšanja temperature
            System.out.println("Ali želite povečati (P) ali zmanjšati (Z) temperaturo?");
            String izbira = scanner.nextLine();

            if (izbira.equalsIgnoreCase("P")) {
                System.out.println("Vnesite število stopinj za povečanje temperature:");
                int stopinje = scanner.nextInt();
                hladilnik.povecajTemperaturo(stopinje);
            } else if (izbira.equalsIgnoreCase("Z")) {
                System.out.println("Vnesite število stopinj za zmanjšanje temperature:");
                int stopinje = scanner.nextInt();
                hladilnik.zmanjsajTemperaturo(stopinje);
            } else {
                System.out.println("Neveljavna izbira!");
            }

            // Izpis trenutne temperature
            System.out.println("Trenutna temperatura hladilnika: " + hladilnik.pridobiTemperaturo() + " stopinj");

            // Izključimo hladilnik
            hladilnik.izkljuci();

            scanner.nextLine();  // Porabi preostanek vrstice
        }

        // Izpis vseh hladilnikov
        System.out.println("\nSeznam vseh hladilnikov:");
        for (OsnovniHladilnik h : hladilniki) {
            System.out.println("Model: " + h.getModel() + ", Kapaciteta: " + h.getKapaciteta() + " litrov, Trenutna temperatura: " + h.pridobiTemperaturo() + " stopinj.");
        }

        scanner.close();
    }
}