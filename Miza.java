// Uvozimo razred za delo z vhodno-izhodnimi operacijami ter pripomočke
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Razred za prikaz delovanja grafičnega uporabniškega vmesnika
 *
 * @author Primož Vaupotič
 * @version Primer 20 - GUI
 */

public class Miza extends JFrame implements ActionListener {
	
	//Deklariramo zasebne lastnosti GUI
	private JPanel povrsina;
	private JButton dodajButton;
	private JTextField znamkaTextField;
	private JTextField stopnjaAlkoholaTextField;
	
	private PivskaSteklenicaTableModel modelTabele;
	
	/**
	 * Glavna metoda programa. Zažene se vedno ob zagonu.
	 *
	 * @param args Seznam argumentov iz ukazne vrstice
	 */
	 public static void main(String[] args) {
	 
		// Izpišemo začetek 
		System.out.println("Zaganjam GUI ...");
		
		// Ustvarimo objekt razreda Miza (kličemo konstruktor razreda Miza)
		Miza m = new Miza();
	 }
	 /**
	  * Konstruktor, ki postavi osnovne lastnosti okna
	  */
	  public Miza() {
		  
		  // Pokličemo konstruktor nadrazreda
		  super ("Miza s steklenicami");
		  
		  // Nastavimo obnašanje [x] tako, da konča aplikacjo
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  
		  // Nastavimo velikost okna
		  setSize(800, 600);
		  
		  // Inicializiramo elemente GUI
		  povrsina = new JPanel();
		  
		  // Vnosna polja za dodajanje steklenice
		  znamkaTextField = new JTextField(32);
		  stopnjaAlkoholaTextField = new JTextField(4);
		  
		  // Dodadamo vnosna polja na površino
		  povrsina.add(new JLabel("Znamka piva:"));
		  povrsina.add(znamkaTextField);
		  povrsina.add(new JLabel("Stopnja alkohola:"));
		  povrsina.add(stopnjaAlkoholaTextField);
		  
		  // Gumb za dodajanje steklenice
		  dodajButton = new JButton("Dodaj");
		  
		  // Gumbu dodamo action listener za dodajanje steklenic
		  dodajButton.addActionListener(this);
		  
		  // Dodaj gumb na površino
		  povrsina.add(dodajButton);
		  
		  // Inicializiraamo model tabele
		  modelTabele = new PivskaSteklenicaTableModel();
		  
		  // Tabelo postavimo na površini
		  // Ustvarimo anonimen objekt razreda JTable z modelomTable
		  povrsina.add(new JTable(modelTabele));
		  
		  // Površino dodamo na okno
		  add(povrsina);
		  
		  //  Prikažemo okno
		  setVisible(true);
	  }
	  
	  /**
		* Metoda, ki jo predpisuje vmesnik ActionListener
		* se kliče vedno, ko je pritisnjen gumb
		* @param e Dogodek ob kliku
		*/
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Dodaj steklenico...");
			System.out.println("Znamka piva: " + znamkaTextField.getText());
			System.out.println("Stopnja alkohola: " + stopnjaAlkoholaTextField.getText());
			
			// Spremenljivka za stopnjo alkohola
			double sa = Double.parseDouble(stopnjaAlkoholaTextField.getText());
			
			// Ustvarimo nov objekt tipa PivskaSteklenica
			PivskaSteklenica nova = new PivskaSteklenica(500, znamkaTextField.getText(), 8.0, sa);
			
			// Objekt dodamo v tabelo
			modelTabele.addPivskaSteklenica(nova);
		}
	
}