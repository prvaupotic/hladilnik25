/**
 * Razred za prikaz uporabe dedovanja
 * razširja razred Steklenice
 *
 * @author Primož Vaupotič
 * @version Primer 16 - Dedovanje
 */
 public class PivskaSteklenica extends Steklenica {
	
	// Vse lastnosti od nadrazreda se prenesejo
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
	  * Konstruktor za inicializacijo nove pivske steklenice, ki je polna in zaprta
	  * Inicializira vse lastnosti 
	  * @param k Kapaciteta steklenice (ml)
	  * @param z Znamka piva
	  * @param t Začetna temperatura steklenice
	  */
	  public PivskaSteklenica(int k, String z, double t) {
		  
		  // Pokličemo konstruktor nadrazreda - Steklenica
		  // ki bo inicializirala lastnosti nadrazreda
		  super(k, "Pivo");
		  
		  // Inicializiramo dodatne lastnosti razreda
		  znamka = z;
		  temperatura = t;
		  System.out.println("Pivska steklenica je znamke " + z);
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
  }