/**
 * Razred za predstavitev hladilnika z zamrzovalnikom, ki deduje od razreda Hladilnik
 */
class HladilnikZZamrzovalnikom extends Hladilnik {

    // Temperatura v zamrzovalniku
	private int temperaturaZamrzovalnika; 

    /**
     * Konstruktor za ustvarjanje novega hladilnika z zamrzovalnikom
     * @param model Model hladilnika
     * @param kapaciteta Kapaciteta hladilnika v litrih
     */
    public HladilnikZZamrzovalnikom(String model, int kapaciteta) {
        // Klic konstruktorja nadrazreda
		super(model, kapaciteta); 
        // Privzeta temperatura v zamrzovalniku je -18 stopinj
		this.temperaturaZamrzovalnika = -18; 
    }

    /**
     * Metoda za spreminjanje temperature v zamrzovalniku
     * @param sprememba Števila stopinj za spremembo temperature
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