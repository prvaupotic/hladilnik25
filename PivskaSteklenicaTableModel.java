import javax.swing.table.*;

/**
 * Razred za delo s tabelo pivskih steklenic
 * razširja privzeti razred za tabele
 *
 * @author Primož Vaupotič
 * @version Primer 20 - GUI
 */
 
 public class PivskaSteklenicaTableModel extends DefaultTableModel {

		/**
		 * Konstruktor, ki ustavri tabelo steklenic na mizi
		 */
		 public PivskaSteklenicaTableModel(){
			 
			 // Pokličemo konstruktor nadrazreda
			 super();
			 
			 // Dodamo stolpce v tabelo
			 addColumn("Znamka");
			 addColumn("StopnjaAlkohola");
			 
			 // ustvarimo seznam objektov (nizov), ki predstavljajo vrstico tabele
			 Object[] vrstica = new Object[] {"Testna zanka", "5.0"};
			 
			 // Vrstico vstavimo v tabelo
			 addRow(vrstica);
		 }
		 
		 /**
		 * Javna metoda, ki doda pivsko steklenico v tabelo
		 * @param ps Objekt, ki ga dodamo v tabelo
		 */
		 public void addPivskaSteklenica(PivskaSteklenica ps) {
			 
			 // ustvarimo seznam objektov (nizov), ki predstavljajo vrstico tabele
			 Object[] vrstica = new Object[] {ps.getZnamka(), ps.getStopnjaAlkohola()};
			 
			 // Vrstico vstavimo v tabelo
			 addRow(vrstica);
		 }
 }