/**
 * Razred za prikaz modela hladilnika s tremi lastnostmi: model, kapaciteta in vklop hladilnika.
 *
 * @author Primož Vaupotič
 * @version Vaja 27 - Razred hladilnik v Javi
 */
public class Hladilnik {

    // Lastnosti hladilnika
    private String znamka;
    private int kapaciteta;
    private boolean vklopljen;
    private int temperatura; // Trenutna temperatura hladilnika

    /**
     * Konstruktor za ustvarjanje novega hladilnika
     * @param model Hladilnika
     * @param kapaciteta Hladilnika v litrih
     */
    public Hladilnik(String znamka, int kapaciteta) {
        this.znamka = znamka;
        this.kapaciteta = kapaciteta;
        this.vklopljen = false; // Hladilnik je ob začetku izklopljen
        this.temperatura = 5; // Privzeta temperatura je 5 stopinj Celzija
    }

    /**
     * Vključi hladilnik.
     * Če je hladilnik že vključen, izpiše ustrezno sporočilo.
     */
    public void vkljuci() {
        if (!vklopljen) {
            vklopljen = true;
            System.out.println("Hladilnik " + znamka + " je bil vključen.");
        } else {
            System.out.println("Hladilnik " + znamka + " je že vključen.");
        }
    }

    /**
     * Izključi hladilnik.
     * Če je hladilnik že izključen, izpiše ustrezno sporočilo.
     */
    public void izkljuci() {
        if (vklopljen) {
            vklopljen = false;
            System.out.println("Hladilnik " + znamka + " je bil izključen.");
        } else {
            System.out.println("Hladilnik " + znamka + " je že izključen.");
        }
    }

    /**
     * Poveča temperaturo v hladilniku za podano število stopinj.
     * @param stopinje Število stopinj za povečanje temperature.
     */
    public void povecajTemperaturo(int stopinje) {
        if (vklopljen) {
            temperatura += stopinje;
            System.out.println("Temperatura v hladilniku " + znamka + " se je povečala na " + temperatura + " stopinj.");
        } else {
            System.out.println("Hladilnik " + znamka + " mora biti vključen, da lahko spremenite temperaturo.");
        }
    }

    /**
     * Zmanjša temperaturo v hladilniku za podano število stopinj.
     * Če je temperatura manjša od 0, jo nastavi na 0.
     * @param stopinje Število stopinj za zmanjšanje temperature.
     */
    public void zmanjsajTemperaturo(int stopinje) {
        if (vklopljen) {
            temperatura -= stopinje;
            if (temperatura < 0) {
                temperatura = 0;
            }
            System.out.println("Temperatura v hladilniku " + znamka + " se je zmanjšala na " + temperatura + " stopinj.");
        } else {
            System.out.println("Hladilnik " + znamka + " mora biti vključen, da lahko spremenite temperaturo.");
        }
    }

    /**
     * Metoda za pridobitev trenutne temperature v hladilniku.
     * @return Trenutna temperatura v hladilniku.
     */
    public int getTemperatura() {
        return temperatura;
    }

    /**
     * Metoda za pridobitev znamke hladilnika.
     * @return znamka Hladilnika.
     */
    public String getZnamka() {
        return znamka;
    }

    /**
     * Metoda za pridobitev kapacitete hladilnika.
     * @return kapaciteta Kapaciteta hladilnika v litrih.
     */
    public int getKapaciteta() {
        return kapaciteta;
    }

    /**
     * Metoda za preverjanje, ali je hladilnik vključen.
     * @return vklopljen True, če je hladilnik vključen, sicer false.
     */
    public boolean jeVklopljen() {
        return vklopljen;
    }
}
