/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Vaja 27 - Razred hladilnik v Javi
 */
 
 public class HladilnikDelovanje {

    public static void main(String[] args) {

        // Ustvarimo tri objekte razreda Hladilnik
        Hladilnik hladilnik1 = new Hladilnik("Gorenje Retro", 250);
        Hladilnik hladilnik2 = new Hladilnik("Samsung NoFrost", 300);
        Hladilnik hladilnik3 = new Hladilnik("Bosch Serie 8", 200);

        // Prikaz uporabe metod na prvem objektu
        hladilnik1.vkljuci();
        hladilnik1.povecajTemperaturo(5);
        hladilnik1.izkljuci();

        // Prikaz uporabe metod na drugem objektu
        hladilnik2.vkljuci();
        hladilnik2.povecajTemperaturo(2);

        // Prikaz uporabe metod na tretjem objektu
        hladilnik3.vkljuci();
        hladilnik3.zmanjsajTemperaturo(1); // Zmanjšamo temperaturo za 1 stopinjo
        hladilnik3.izkljuci();

        // Izpis lastnosti objektov (primer)
        System.out.println("Model hladilnika 1: " + hladilnik1.getModel());
        System.out.println("Kapaciteta hladilnika 2: " + hladilnik2.getKapaciteta() + " litrov");
        System.out.println("Hladilnik 3 je vklopljen: " + hladilnik3.jeVklopljen());
        System.out.println("Temperatura hladilnika 3: " + hladilnik3.getTemperatura() + " stopinj");
    }
}