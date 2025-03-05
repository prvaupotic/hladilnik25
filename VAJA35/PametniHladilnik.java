/**
 * Razred za predstavitev pametnega hladilnika, ki deduje od razreda Hladilnik
 */
class PametniHladilnik extends Hladilnik {

    private boolean povezanNaInternet; // Ali je hladilnik povezan na internet

    /**
     * Konstruktor za ustvarjanje novega pametnega hladilnika
     * @param model Model hladilnika
     * @param kapaciteta Kapaciteta hladilnika v litrih
     */
    public PametniHladilnik(String model, int kapaciteta) {
        super(model, kapaciteta); // Klic konstruktorja nadrazreda
        this.povezanNaInternet = false; // Hladilnik na začetku ni povezan na internet
    }

    /**
     * Metoda za povezavo hladilnika na internet
     */
    public void poveziNaInternet() {
        this.povezanNaInternet = true;
    }

    /**
     * Metoda za odjavo hladilnika z interneta
     */
    public void odjaviZInterneta() {
        this.povezanNaInternet = false;
    }

    /**
     * Metoda za preverjanje, ali je hladilnik povezan na internet
     * @return true, če je hladilnik povezan na internet, false sicer
     */
    public boolean jePovezanNaInternet() {
        return this.povezanNaInternet;
    }
}