/**
 * Razred za predstavitev hladilnika z zamrzovalnikom, ki deduje od razreda Hladilnik
 */
class HladilnikZZamrzovalnikom extends Hladilnik {

    private int temperaturaZamrzovalnika; // Temperatura v zamrzovalniku

    /**
     * Konstruktor za ustvarjanje novega hladilnika z zamrzovalnikom
     * @param model Model hladilnika
     * @param kapaciteta Kapaciteta hladilnika v litrih
     */
    public HladilnikZZamrzovalnikom(String model, int kapaciteta) {
        super(model, kapaciteta); // Klic konstruktorja nadrazreda
        this.temperaturaZamrzovalnika = -18; // Privzeta temperatura v zamrzovalniku je -18 stopinj
    }

    /**
     * Metoda za spreminjanje temperature v zamrzovalniku
     * @param sprememba Število stopinj za spremembo temperature
     */
    public void spremeniTemperaturoZamrzovalnika(int sprememba) {
        this.temperaturaZamrzovalnika += sprememba;
    }

    /**
     * Metoda za pridobitev temperature v zamrzovalniku
     * @return Temperatura v zamrzovalniku
     */
    public int getTemperaturaZamrzovalnika() {
        return temperaturaZamrzovalnika;
    }
}