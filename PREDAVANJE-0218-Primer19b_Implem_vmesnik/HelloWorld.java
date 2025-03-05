// Uvozimo razred za delo z vrsto (buffer) iz paketa za delo z vhodno-izhodnimi operacijamo
// import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * Razred za prikaz objektno orientiranega programiranja
 *
 * @author Primož Vaupotič
 * @version Primer 19a - Implementacija vmesnika
 */

public class HelloWorld {
	
	/**
	 * Statični atribut/lastnost za branje vhoda iz konzole (tipkovnice)
	 */
	 private static BufferedReader in;
	 
	/**
	 * Seznam objektov tipa PivskaSteklenica - kot lastnost/atribut razreda HelloWorld
	 */
	 private static ArrayList<PivskaSteklenica> pivskeSteklenice;

	/**
	 * Glavna metoda programa. Zažene se vedno ob zagonu.
	 * 
	 * @param args Sezanm argumentov iz ukazne vrstice 
	 */
	public static void main(String[] args){
			
		// Izpišemo pozdrav v konzolo
		System.out.println("Pozdravljen, Svet!");
		
		// Inicializiramo objekt in za zajem podatkov iz tipkovnice preko konzole
		in = new BufferedReader(new InputStreamReader(System.in));
		
		// Inicializiramo seznam pivskih steklenic
		pivskeSteklenice = new ArrayList<>();
		
		// Delklariramo in inicializiramo lastnosti steklenice
		String znamkaPiva = "";
		int velikostSteklenice = 500;
		double temperaturaSteklenice = 5.0;
		
		// Poskusimo prebrati iz ukazne konzole
		try {
			// Vnos podatkov o pivski steklenici - znamka
			System.out.print("Vnesi znamko piva: ");
			znamkaPiva = in.readLine();
			
			// Če gre za malo pivo, nastavimo vrednost na 330 ml - default=da
			System.out.print("Je pivo veliko (d/n)?");
			
			// Preverimo, ali je vnešena vrednost ENAKA (in ne ISTA) kot "n"
			if (in.readLine().equals("n")) {
				velikostSteklenice = 330;
			}
			
			// Vnos podatkov o pivski steklenici - temperatura
			System.out.print("Vnesi temperaturo piva: ");
			temperaturaSteklenice = Double.parseDouble(in.readLine());
		}
		// Lovljenje in obravnava izjeme pri branju vrstice
		catch(Exception e) {
			System.out.println("Izjema pri branju podatkov o steklenici piva: " + e);
		}
		
		// Ustvarimo objekt tipa Steklenica
		Steklenica plastenkaVode = new Steklenica(500, "Voda");
		
		// Ustvarimo objekt tipa PivskaSteklenica, glede na vnešene podatke
		PivskaSteklenica mojePivo = new PivskaSteklenica(velikostSteklenice, znamkaPiva, temperaturaSteklenice);	
		
		// Objekt dodamo v seznam
		pivskeSteklenice.add(mojePivo);
		
		// V seznam dodamo še nekaj anonimnih objekov
		pivskeSteklenice.add(new PivskaSteklenica(500, "Laško", 8.0));
		pivskeSteklenice.add(new PivskaSteklenica(500, "Staropramen", 8.0));
		pivskeSteklenice.add(new PivskaSteklenica(500, "Union", 8.0));
		
		// Izpišemo število steklenic na seznamu
		System.out.println("V seznamu je " + pivskeSteklenice.size() + " steklenic.");
		
		// Odpremo vse steklenice na seznamu
		for(int c=0; c<pivskeSteklenice.size(); c++) {
			
			// Odpremo trenutno pivsko steklenico
			pivskeSteklenice.get(c).odpri();
		}
		
		// Izpijemo požirek piva
		try {
			System.out.println("Po prvem požirku je v stekelnici še " + mojePivo.izprazni(50));
		}
		catch (Exception e) {
			System.out.println("Izjema pri praznjenju steklenice: " + e);
			
			}
			mojePivo.odpri();
			
			try {
				System.out.println("Po drugem požirku je v stekelnici še " + mojePivo.izprazni(50));
				
				// Izpijemo požirek vode
				plastenkaVode.odpri();
				System.out.println("Po požirku vode je v stekelnici še " + plastenkaVode.izprazni(30));
		}
			//System.out.println("Po drugem požirku je v stekelnici še " + mojePivo.izprazni(50));
		catch(Exception e) {
			System.out.println("Izjema pri praznjenju steklenice: " + e);
		}
		
	}
}