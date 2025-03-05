/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Primer 15b - Razred v Javi
 */

public class HelloWorld {

	/**
	 * Glavna metoda programa. Zažene se vedno ob zagonu.
	 * 
	 * @param args Sezanm argumentov iz ukazne vrstice 
	 */
	public static void main(String[] args) {
			
		// Izpišemo pozdrav v konzolo
		System.out.println("Pozdravljen, Svet!");
		
		// Ustvarimo objekt tipa Steklenica
		Steklenica plastenkaVode = new Steklenica(500, "Voda");
		PivskaSteklenica maloPivo = new PivskaSteklenica(330, "Bevog");	
		
		// Izpijemo požirek piva
		System.out.println("Po prvem požirku je v stekelnici še " + maloPivo.izprazni(50));
		maloPivo.odpri();
		System.out.println("Po drugem požirku je v stekelnici še" + maloPivo.izprazni(50));
		
		// Izpijemo požirek vode
		plastenkaVode.odpri();
		System.out.println("Po požirku vode je v stekelnici še " + plastenkaVode.izprazni(30));
		}
	}