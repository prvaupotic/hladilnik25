/**
 * Razred za prikaz modela hladilnika s tremi lastnostmi: model, kapaciteta in vklop hladilnika.
 *
 * @author Primož Vaupotič
 * @version Vaja 34 - Razred hladilnik v Javi
 */
 
 import java.util.Random;
 
public class Hladilnik {

    // Lastnosti hladilnika
    protected String znamka;
    protected int kapaciteta;
	private int temperatura;
	private boolean vklopljen;
    private boolean povezanNaInternet;

    /**
     * Konstruktor za ustvarjanje novega hladilnika
     * @param model Hladilnika
     * @param kapaciteta Hladilnika v litrih
     */
    public Hladilnik(String znamka, int kapaciteta) {
        this.znamka = znamka;
		this.kapaciteta = kapaciteta;
		this.temperatura = 5; // Privzeta temperatura je 5 stopinj Celzija
		this.vklopljen = false; // Hladilnik je ob začetku izklopljen
		this.povezanNaInternet = false;  
    }

	public String pridobiZnamka() {
        return znamka;
    }

    public int pridobiKapaciteta() {
        return kapaciteta;
    }

    public int pridobiTemperatura() {
        return temperatura;
    }

    public boolean jeVklopljen() {
        return vklopljen;
    }

    public boolean jePovezanNaInternet() {
        return povezanNaInternet;
    }

    public void vkljuci() {
        vklopljen = true;
        temperatura = 5; // Ob vklopu nastavi na privzeto temperaturo
    }

    public void izkljuci() {
        vklopljen = false;
        temperatura = 0; // Ob izklopu nastavi na 0
    }

    public void poveziNaInternet() {
        // Simulacija naključnega uspeha pri povezovanju
        Random nakljucno = new Random();
        this.povezanNaInternet = nakljucno.nextBoolean();
    }
}
