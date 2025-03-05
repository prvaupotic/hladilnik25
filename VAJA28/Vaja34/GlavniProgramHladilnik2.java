/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Vaja 34 - Implementacija vmesnika - razširitev Vaje 27, dodatna dva podrazreda
 */
public class GlavniProgramHladilnik {

    /**
     * Glavna metoda programa. Zažene se vedno ob zagonu.
     *
     * @param args Sezanm argumentov iz ukazne vrstice
     */
    public static void main(String[] args) {

        // Ustvarimo tri objekte razreda Hladilnik
        // Ustvarimo nov objekt hladilnik1 z modelom "Gorenje Retro" in kapaciteto 250 litrov
        Hladilnik hladilnik1 = new Hladilnik("Gorenje Retro", 250);
        // Ustvarimo nov objekt hladilnik2 z modelom "Samsung NoFrost" in kapaciteto 300 litrov
        HladilnikZZamrzovalnikom hladilnik2 = new HladilnikZZamrzovalnikom("Samsung NoFrost", 300);

        // Ustvarimo nov objekt hladilnik3 z modelom "Bosch Serie 8" in kapaciteto 200 litrov
        PametniHladilnik hladilnik3 = new PametniHladilnik("Bosch Serie 8", 200);

        // Metod na prvem objektu
        // Vključimo hladilnik1
        hladilnik1.vkljuci();
        // Povečamo temperaturo v hladilniku1 za 3 stopinje
        hladilnik1.povecajTemperaturo(3);
        // Izključimo hladilnik1
        hladilnik1.izkljuci();

        // Metod na drugem objektu (HladilnikZZamrzovalnikom)
        // Vključimo hladilnik2
        hladilnik2.vkljuci();
        // Povečamo temperaturo v hladilniku2 za 1 stopinjo
        hladilnik2.povecajTemperaturo(1);
        hladilnik2.spremeniTemperaturoZamrzovalnika(2);

        // Metod na tretjem objektu (PametniHladilnik)
        // Vključimo hladilnik3
        hladilnik3.vkljuci();
        hladilnik3.poveziNaInternet();

        // Preverimo ali je bil vklop uspešen
        // Preverimo, ali je hladilnik3 vklopljen
        if (hladilnik3.jeVklopljen()) {
            // Izpišemo, da je bil vklop uspešen
            System.out.println("Hladilnik 3 je bil uspešno vklopljen.");
        } else {
            // Izpišemo, da vklop ni bil uspešen
            System.out.println("Vklop hladnilnika 3 ni bil uspešen.");

        }

        // Izpis lastnosti objektov (hladilnikov)
        // Izpišemo model hladilnika1
        System.out.println("Model hladilnika 1: " + hladilnik1.getModel());
        // Izpišemo kapaciteto hladilnika2
        System.out.println("Kapaciteta hladilnika 2: " + hladilnik2.getKapaciteta() + " litrov");
        // Izpišemo, ali je hladilnik3 vklopljen
        System.out.println("Hladilnik 3 je vklopljen: " + hladilnik3.jeVklopljen());
        System.out.println("Temperatura v zamrzovalniku hladilnika 2: " + hladilnik2.getTemperaturaZamrzovalnika() + " stopinj");
        System.out.println("Hladilnik 3 je povezan na internet: " + hladilnik3.jePovezanNaInternet());

        // Dodana koda za prikaz uporabe vmesnika in abstraktnega razreda
        hladilnik1.povecajTemperaturo(4);
        System.out.println("Nastavljena temperatura hladilnika 1: " + hladilnik1.povecajTemperaturo() + " stopinj");

        // Izključimo hladilnik3
        hladilnik3.izkljuci();

        // Izpis lastnosti PONOVNO, ko je bil hladilnik izklopljen
        //System.out.println("Hladilnik 3 je vklopljen: " + hladilnik3.jeVklopljen());
    }
}