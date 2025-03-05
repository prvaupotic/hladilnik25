/**
 * Razred za predstavitev pametnega hladilnika, ki deduje od razreda Hladilnik
 */
class PametniHladilnik extends Hladilnik {

    // Ali je hladilnik povezan na internet
	private boolean povezanNaInternet; 

    /**
     * Konstruktor za ustvarjanje novega pametnega hladilnika
     * @param model Model hladilnika
     * @param kapaciteta Kapaciteta hladilnika v litrih
     */
    public PametniHladilnik(String model, int kapaciteta) {
        // Klic konstruktorja nadrazreda
		super(model, kapaciteta); 
        // Hladilnik na začetku ni povezan na internet
		this.povezanNaInternet = false; 
    }

    /**
     * Metoda za povezavo hladilnika na internet
     */
    public void poveziNaInternet() {
        this.povezanNaInternet = true;
        // Izpišemo, da je hladilnik povezan na internet
		System.out.println("Hladilnik " + super.getModel() + " je bil povezan na internet."); 
    }

    /**
     * Metoda za odjavo hladilnika z interneta
     */
    public void odjaviZInterneta() {
        this.povezanNaInternet = false;
        // Izpišemo, da je hladilnik odjavljen z interneta
		System.out.println("Hladilnik " + super.getModel() + " je bil odjavljen z interneta."); 
    }

    /**
     * Metoda za preverjanje, ali je hladilnik povezan na internet
     * @return true, če je hladilnik povezan na internet, false sicer
     */
    public boolean jePovezanNaInternet() {
        return this.povezanNaInternet;
    }
}