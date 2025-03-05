/**
 * Razred za prikaz uporabe dedovanja
 * razširja razred Steklenice
 *
 * @author Primož Vaupotič
 * @version Primer 16 - Dedovanje
 */
 public class PivskaSteklenica extends Steklenica implements AlkoholnaPijaca {
	
	// Vse lastnosti/atributi od nadrazreda se prenesejo
	// Deklariramo dodatne lastnosti, ki so skupne le pivskim steklenicam
	
	/*
	 *Znamke piva
	 */
	private String znamka;
	
	/**
	 * Temperatura piva v steklenici (v stopinjah celzija)
	 */
	 private double temperatura;
	 
	 /**
	 * Stopnja alkohola piva (v odstotkih in ne v deležu)
	 */
	 private double stopnjaAlkohola;
	 
	 /**
	  * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
	  * Inicializira vse lastnosti 
	  * @param k Kapaciteta steklenice (ml)
	  * @param z Znamka piva
	  * @param t Začetna temperatura steklenice (v stopinjah Celzija)
	  * @param s Stopnja alkohola (v odstotkih)
	  */
	  public PivskaSteklenica(int k, String z, double t, double s) {
		  
		  // Pokličemo konstruktor nadrazreda - Steklenica
		  // ki bo inicializirala lastnosti nadrazreda
		  super(k, "Pivo");
		  
		  // Inicializiramo dodatne lastnosti razreda
		  znamka = z;
		  temperatura = t;
		  stopnjaAlkohola = s;
		  System.out.println("Pivska steklenica je znamke " + z + " s stopnjo alkohola " + s + "%.");
	  }
		  
	/**
	  * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
	  * Inicializira vse lastnosti 
	  * @param k Kapaciteta steklenice (ml)
	  * @param z Znamka piva
	  * @param t Začetna temperatura steklenice (v stopinjah Celzija)
	  */
	public PivskaSteklenica(int k, String z, double t) {
		  
		  // Pokličemo drug konstruktor z privzeto vrednostjo
		  this(k, z, t, 4.50); 
		 		   
	  }
	  
	  /**
	  * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
	  * Inicializira vse lastnosti 
	  * @param k Kapaciteta steklenice (ml)
	  * @param z Znamka piva
	  */
	public PivskaSteklenica(int k, String z) {
		  
		  // Pokličemo drug konstruktor
		  this(k, z, 8.0); 
		 		   
	  }
	  
	  /**
	   * Metoda, predpisana z vmesnikom AlkoholnaPijaca
	   * vrne stopnjo alkohola v odstotkih
	   */
	   public double getStopnjaAlkohola() {
		   return stopnjaAlkohola;
	   }
	  
	  /**
	   * Metoda vrne znamko piva
	   * vrne stopnjo alkohola v odstotkih
	   */
	   public String getZnamka() {
		   return znamka;
	   }
	  	  
  }