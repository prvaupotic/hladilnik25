// Uvozimo razred za delo z vrsto (buffer) iz paketa za delo z vhodno-izhodnimi operacijamo
// import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Primer 15 - Hello World v Javi
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
		Steklenica plastenkaVoda = new Stekelnica(500, "Voda");
		Steklenica maloPivo = new Steklenica(330, "Bevog");	
		
		// Izpijemo požirek piva
		System.out.println("Po prvem požirku je v stekelnici še" + maloPivo.izprazno(50));
		maloPivo.odpri();
		System.out.println("Po drugem požirku je v stekelnici še" + maloPivo.izprazno(50));
		
		// Izpijemo požirek vode
		plastenkaVode.odpri();
		System.out.println("Po požirku vode je v stekelnici še" + plastenkaVode.izprazno(50));
		}
	}