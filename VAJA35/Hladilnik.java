/**
 * Razred za prikaz modela hladilnik s tremi lastnostmi znamko, kapaciteto in vklopom hladilnika.
 *
 * @author Primož Vaupotič
 * @version Vaja 27 - Razred hladilnik v Javi
 */
 
 public class Hladilnik {

    // Lastnosti hladilnika
    // Znamka hladilnika
    private String znamka;
    // Kapaciteta hladilnika v litrih
    private int kapaciteta;
    // Ali je hladilnik vklopljen ali ne
    private boolean vklopljen;
    // Dodana lastnost za temperaturo
    private int temperatura; // Dodana lastnost za temperaturo

    /**
     * Konstruktor za ustvarjanje novega hladilnika
     * @param znamka hladilnika
     * @param kapaciteta hladilnika v litrih
     */
    public Hladilnik(String znamka, int kapaciteta) {
        this.znamka = znamka;
        this.kapaciteta = kapaciteta;
        // Hladilnik je ob začetku izklopljen
        this.vklopljen = false; 
        // Privzeta temperatura ob vklopu je 5 stopinj
        this.temperatura = 5;
    }

    /**
     * Vključi hladilnik.
     * Če hladilnik še ni vključen, ga vključi in izpiše sporočilo.
     * Če je hladilnik že vključen, izpiše sporočilo, da je že vključen.
     */
    public void vkljuci() {
        // Preverimo, ali je hladilnik že vključen
        if (!vklopljen) {
            vklopljen = true;
            System.out.println("Hladilnik " + znamka + " je bil vključen.");
        } else {
            System.out.println("Hladilnik " + znamka + " je že vključen.");
        }
    }

    /**
     * Izključi hladilnik.
     * Če je hladilnik vključen, ga izključi in izpiše sporočilo.
     * Če je hladilnik že izključen, izpiše sporočilo, da je že izključen.
     */
    public void izkljuci() {
        // Preverimo, ali je hladilnik vključen
        if (vklopljen) {
            vklopljen = false;
            System.out.println("Hladilnik " + znamka + " je bil izključen.");
        } else {
            System.out.println("Hladilnik " + znamka + " je že izključen.");
        }
    }

    /**
     * Poveča temperaturo v hladilniku.
     * Če je hladilnik vključen, poveča temperaturo za podano število stopinj in izpiše novo temperaturo.
     * Če hladilnik ni vključen, izpiše sporočilo, da je treba hladilnik vključiti.
     * @param stopinje Število stopinj, za katere se poveča temperatura.
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
     * Zmanjša temperaturo v hladilniku.
     * Če je hladilnik vključen, zmanjša temperaturo za podano število stopinj in izpiše novo temperaturo.
     * Če je nova temperatura manjša od 0, jo nastavi na 0, saj temperatura ne more biti negativna.
     * Če hladilnik ni vključen, izpiše sporočilo, da je treba hladilnik vključiti.
     * @param stopinje Število stopinj, za katere se zmanjša temperatura.
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

    // Getterji (za dostop do lastnosti izven razreda)

    /**
     * Metoda za pridobitev znamke hladilnika.
     * @return znamka Znamka hladilnika.
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

    /**
     * Metoda za pridobitev trenutne temperature v hladilniku.
     * @return temperatura Trenutna temperatura v hladilniku v stopinjah Celzija.
     */
    public int povecajTemperaturo() {
        return temperatura;
    }
}
