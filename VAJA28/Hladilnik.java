/**
 * Razred za prikaz modela hladilnik s tremi lastnostmi model, kapaciteto in vklopom hladilnika.
 *
 * @author Primož Vaupotič
 * @version Vaja 27 - Razred hladilnik v Javi
 */
 
 public class Hladilnik {

    // Lastnosti hladilnika
    // Model hladilnika
	private String model;
    // Kapaciteta hladilnika v litrih
	private int kapaciteta;
    // Ali je hladilnik vklopljen ali ne
	private boolean vklopljen;
	// Dodana lastnost za temperaturo
	private int temperatura; // Dodana lastnost za temperaturo

    /**
     * Konstruktor za ustvarjanje novega hladilnika
     * @param model hladilnika
     * @param kapaciteta hladilnika v litrih
     */
    public Hladilnik(String model, int kapaciteta) {
        this.model = model;
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
            // Preverimo, ali je hladilnik že vključen
			vklopljen = true;
            // Izpišemo sporočilo o vklopu
			System.out.println("Hladilnik " + model + " je bil vključen.");
        } else {
            // Izpišemo sporočilo, da je hladilnik že vključen
			System.out.println("Hladilnik " + model + " je že vključen.");
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
            // Izklopimo hladilnik
			vklopljen = false;
            // Izpišemo sporočilo o izklopu
			System.out.println("Hladilnik " + model + " je bil izključen.");
        } else {
            // Izpišemo sporočilo, da je hladilnik že izključen
			System.out.println("Hladilnik " + model + " je že izključen.");
        }
    }

	/**
	 * Poveča temperaturo v hladilniku.
	 * Če je hladilnik vključen, poveča temperaturo za podano število stopinj in izpiše novo temperaturo.
	 * Če hladilnik ni vključen, izpiše sporočilo, da je treba hladilnik vključiti.
	 * @param stopinje Število stopinj, za katere se poveča temperatura.
	 */
    public void povecajTemperaturo(int stopinje) {
        // Preverimo, ali je hladilnik vključen
		if (vklopljen) {
            // Povečamo temperaturo
			temperatura += stopinje;
            // Izpišemo novo temperaturo
			System.out.println("Temperatura v hladilniku " + model + " se je povečala na " + temperatura + " stopinj.");
        } else {
            // Izpišemo sporočilo, da je treba vključiti hladilnik
			System.out.println("Hladilnik " + model + " mora biti vključen, da lahko spremenite temperaturo.");
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
        // Preverimo, ali je hladilnik vključen
		if (vklopljen) {
            // Zmanjšamo temperaturo
			temperatura -= stopinje;
            // Preverimo, ali je nova temperatura manjša od 0
			if (temperatura < 0) {
                // Nastavimo temperaturo na 0
				temperatura = 0;
            }
            // Izpišemo novo temperaturo
			System.out.println("Temperatura v hladilniku " + model + " se je zmanjšala na " + temperatura + " stopinj.");
        } else {
            // Izpišemo sporočilo, da je treba vključiti hladilnik
			System.out.println("Hladilnik " + model + " mora biti vključen, da lahko spremenite temperaturo.");
        }
    }

    // Getterji (za dostop do lastnosti izven razreda)
	/**
     * Metoda za pridobitev modela hladilnika.
     * @return model Model hladilnika.
     */
		public String getModel() {
        // Vrne model hladilnika
		return model;
    }
	
	/**
     * Metoda za pridobitev kapacitete hladilnika.
     * @return kapaciteta Kapaciteta hladilnika v litrih.
     */
    public int getKapaciteta() {
        // Vrne kapaciteto hladilnika.
		return kapaciteta;
    }

	/**
     * Metoda za preverjanje, ali je hladilnik vključen.
     * @return vklopljen True, če je hladilnik vključen, sicer false.
     */
    public boolean jeVklopljen() {
        // Vrne true, če je hladilnik vključen, sicer false.
		return vklopljen;
    }

	/**
     * Metoda za pridobitev trenutne temperature v hladilniku.
     * @return temperatura Trenutna temperatura v hladilniku v stopinjah Celzija.
     */
    public int getTemperatura() {
        // Vrne trenutno temperaturo v hladilniku.
		return temperatura;
    }
}