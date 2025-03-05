/**
 * Razred, ki predstavlja osnovni hladilnik.
 * Ta razred omogoča osnovno upravljanje s temperaturo in vklop/izklop hladilnika.
 */
class OsnovniHladilnik {

    // Lastnosti hladilnika (model, kapaciteta in temperatura)
    private String model;
    private int kapaciteta;
    private int temperatura;

    // Konstruktor za inicializacijo hladilnika z modelom in kapaciteto
    public OsnovniHladilnik(String model, int kapaciteta) {
        this.model = model;  // Nastavimo model hladilnika
        this.kapaciteta = kapaciteta;  // Nastavimo kapaciteto hladilnika
        this.temperatura = 4;  // Privzeta temperatura je 4 stopinje
    }

    // Metoda za vklop hladilnika
    public void vkljuci() {
        System.out.println("Hladilnik " + model + " je vključen.");  // Izpišemo, da je hladilnik vključen
    }

    // Metoda za izklop hladilnika
    public void izkljuci() {
        System.out.println("Hladilnik " + model + " je izključen.");  // Izpišemo, da je hladilnik izključen
    }

    // Metoda za povečanje temperature hladilnika
    public void povecajTemperaturo(int stopinje) {
        temperatura += stopinje;  // Povečamo trenutno temperaturo za določeno število stopinj
        System.out.println("Temperatura hladilnika " + model + " je povečana na " + temperatura + " stopinj.");
    }

    // Metoda za zmanjšanje temperature hladilnika
    public void zmanjsajTemperaturo(int stopinje) {
        temperatura -= stopinje;  // Zmanjšamo trenutno temperaturo za določeno število stopinj
        System.out.println("Temperatura hladilnika " + model + " je zmanjšana na " + temperatura + " stopinj.");
    }

    // Metoda za pridobitev trenutne temperature hladilnika
    public int pridobiTemperaturo() {
        return temperatura;  // Vrne trenutno temperaturo hladilnika
    }

    // Getter za model hladilnika
    public String getModel() {
        return model;
    }

    // Getter za kapaciteto hladilnika
    public int getKapaciteta() {
        return kapaciteta;
    }
}
