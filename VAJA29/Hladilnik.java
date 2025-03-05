import java.util.Scanner;

/**
 * Razred za predstavitev hladilnika.
 * 
 * Ta razred vsebuje lastnosti in metode, ki so značilne za hladilnik, kot so model, kapaciteta,
 * ali je vključen in trenutna temperatura.
 */
public class Hladilnik {

    // Model hladilnika
	private String model; 
    // Kapaciteta hladilnika v litrih
	private int kapaciteta; 
    // Ali je hladilnik vklopljen ali ne
	private boolean vklopljen; 
    // Trenutna temperatura v hladilniku
	private int temperatura; 

    /**
     * Konstruktor za ustvarjanje novega hladilnika.
     * 
     * @param model Model hladilnika
     * @param kapaciteta Kapaciteta hladilnika v litrih
     */
    public Hladilnik(String model, int kapaciteta) {
        this.model = model;
        this.kapaciteta = kapaciteta;
        // Hladilnik je na začetku izklopljen
		this.vklopljen = false; 
        // Privzeta temperatura je 5 stopinj
		this.temperatura = 5; 
    }

    /**
     * Metoda za vklop hladilnika.
     * 
     * Če hladilnik še ni vključen, ga vključi in izpiše sporočilo.
     * Če je hladilnik že vključen, izpiše sporočilo, da je že vključen.
     */
    public void vkljuci() {
        if (!vklopljen) {
            vklopljen = true;
            System.out.println("Hladilnik " + model + " je bil vključen.");
        } else {
            System.out.println("Hladilnik " + model + " je že vključen.");
        }
    }

    /**
     * Metoda za izklop hladilnika.
     * 
     * Če je hladilnik vključen, ga izključi in izpiše sporočilo.
     * Če je hladilnik že izključen, izpiše sporočilo, da je že izključen.
     */
    public void izkljuci() {
        if (vklopljen) {
            vklopljen = false;
            System.out.println("Hladilnik " + model + " je bil izključen.");
        } else {
            System.out.println("Hladilnik " + model + " je že izključen.");
        }
    }

    /**
     * Metoda za preverjanje, ali je hladilnik vključen.
     * 
     * @return true, če je hladilnik vključen, false sicer
     */
    public boolean jeVklopljen() {
        return vklopljen;
    }

    /**
     * Metoda za povečanje temperature v hladilniku.
     * 
     * Če je hladilnik vključen, poveča temperaturo za podano število stopinj in izpiše novo temperaturo.
     * Če hladilnik ni vključen, izpiše sporočilo, da je treba hladilnik vključiti.
     * 
     * @param stopinje Število stopinj, za katere se poveča temperatura.
     */
    public void povecajTemperaturo(int stopinje) {
        if (vklopljen) {
            temperatura += stopinje;
            System.out.println("Temperatura v hladilniku " + model + " se je povečala na " + temperatura + " stopinj.");
        } else {
            System.out.println("Hladilnik " + model + " mora biti vključen, da lahko spremenite temperaturo.");
        }
    }

    /**
     * Metoda za zmanjšanje temperature v hladilniku.
     * 
     * Če je hladilnik vključen, zmanjša temperaturo za podano število stopinj in izpiše novo temperaturo.
     * Če je nova temperatura manjša od 0, jo nastavi na 0, saj temperatura ne more biti negativna.
     * Če hladilnik ni vključen, izpiše sporočilo, da je treba hladilnik vključiti.
     * 
     * @param stopinje Število stopinj, za katere se zmanjša temperatura.
     */
    public void zmanjsajTemperaturo(int stopinje) {
        if (vklopljen) {
            temperatura -= stopinje;
            if (temperatura < 0) {
                // Temperatura ne more biti negativna
				temperatura = 0; 
            }
            System.out.println("Temperatura v hladilniku " + model + " se je zmanjšala na " + temperatura + " stopinj.");
        } else {
            System.out.println("Hladilnik " + model + " mora biti vključen, da lahko spremenite temperaturo.");
        }
    }

    /**
     * Metoda za pridobitev modela hladilnika.
     * 
     * @return model Model hladilnika.
     */
    public String getModel() {
        return model;
    }

    /**
     * Metoda za pridobitev kapacitete hladilnika.
     * 
     * @return kapaciteta Kapaciteta hladilnika v litrih.
     */
    public int getKapaciteta() {
        return kapaciteta;
    }

    /**
     * Metoda za pridobitev trenutne temperature v hladilniku.
     * 
     * @return temperatura Trenutna temperatura v hladilniku v stopinjah Celzija.
     */
    public int getTemperatura() {
        return temperatura;
    }
}