/**
  * Razred za pametni hladilnik, ki deduje od osnovnega hladilnika.
  * Ta razred omogoča dodatne funkcionalnosti, kot je povezovanje hladilnika na internet,
  * kar je značilnost pametnih hladilnikov.
  * @author Primož Vaupotič
  * @version Vaja 36
  */

// Uvozimo potrebne razrede za delo z vhodno-izhodnimi operacijami, GUI komponentami, tabelami, dogodki in naključnimi številkami.
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

	// Razred za predstavitev osnovnega hladilnika
	class Hladilnik {
    private String znamka;  // Ime znamke hladilnika
    private int kapaciteta; // Kapaciteta hladilnika v litrih
    private int temperatura; // Trenutna temperatura hladilnika
    private boolean vklopljen; // Ali je hladilnik vključen?
    private boolean povezanNaInternet; // Ali je hladilnik povezan na internet?

    // Konstruktor, ki nastavi osnovne lastnosti hladilnika
    public Hladilnik(String znamka, int kapaciteta) {
        this.znamka = znamka;
        this.kapaciteta = kapaciteta;
        this.temperatura = 5; // Privzeta temperatura hladilnika je 5 stopinj
        this.vklopljen = false; // Ob začetku hladilnik ni vklopljen
        this.povezanNaInternet = false; // Ob začetku hladilnik ni povezan na internet
    }

    // Getterji za pridobitev lastnosti hladilnika
    public String getZnamka() {
        return znamka;
    }

    public int getKapaciteta() {
        return kapaciteta;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean jeVklopljen() {
        return vklopljen;
    }

    public boolean jePovezanNaInternet() {
        return povezanNaInternet;
    }

    // Metoda za vklop hladilnika, pri čemer se temperatura nastavi na privzeto vrednost
    public void vkljuci() {
        vklopljen = true;
        temperatura = 5; // Ob vklopu se temperatura nastavi na 5 stopinj
    }

    // Metoda za izklop hladilnika, pri čemer temperatura pade na 0
    public void izkljuci() {
        vklopljen = false;
        temperatura = 0; // Ob izklopu temperatura postane 0
    }

    // Metoda za simulacijo povezovanja hladilnika na internet (naključno uspešno ali neuspešno)
    public void poveziNaInternet() {
        Random nakljucno = new Random();
        this.povezanNaInternet = nakljucno.nextBoolean(); // Naključno določi, ali bo povezovanje uspešno
    }

    // Metoda za spreminjanje temperature hladilnika z omejitvijo
    public void spremeniTemperaturo(int novaTemperatura) {
        if (novaTemperatura >= -18 && novaTemperatura <= 10) { // Omejitev za temperature
            this.temperatura = novaTemperatura;
        } else {
            JOptionPane.showMessageDialog(null, "Temperatura ni v veljavnem območju!", "Napaka", JOptionPane.ERROR_MESSAGE); // Ob napačni temperaturi izpišemo napako
        }
    }

    // Metoda za spreminjanje kapacitete hladilnika
    public void spremenitevKapacitete(int novaKapaciteta) {
        if (novaKapaciteta > 0) {
            this.kapaciteta = novaKapaciteta;
        } else {
            JOptionPane.showMessageDialog(null, "Kapaciteta mora biti večja od 0!", "Napaka", JOptionPane.ERROR_MESSAGE); // Ob napačni kapaciteti izpišemo napako
        }
    }

    // Metoda za nastavljanje vklopa/izklopa hladilnika
    public void nastaviVklop(boolean vklopljen) {
        this.vklopljen = vklopljen;
        if (!vklopljen) {
            this.temperatura = 0; // Ko izklopiš, temperatura pade na 0
        }
    }

    // Metoda za nastavitev povezave na internet
    public void nastaviPovezavoNaInternet(boolean povezanNaInternet) {
        this.povezanNaInternet = povezanNaInternet;
    }
}

	/**
     * Konstruktor, ki nastavi znamko in kapaciteto pametnega hladilnika.
     * Kliče konstruktor nadrazreda Hladilnik za inicializacijo osnovnih lastnosti.
     * 
     * @param znamka Znamka pametnega hladilnika.
     * @param kapaciteta Kapaciteta hladilnika v litrih.
     */
		class PametniHladilnik extends Hladilnik {
		public PametniHladilnik(String znamka, int kapaciteta) {
        super(znamka, kapaciteta);
		}

		// Povezovanje pametnega hladilnika na internet
		//	@Override
		public void poveziNaInternet() {
        super.poveziNaInternet(); // Pokliče metodo nadrazreda
		}

		// Nastavitev povezave pametnega hladilnika na internet
		//@Override
		public void nastaviPovezavoNaInternet(boolean povezanNaInternet) {
        super.nastaviPovezavoNaInternet(povezanNaInternet); // Pokliče metodo nadrazreda
		}
	}

	/**
	 * Konstruktor, ki nastavi osnovne lastnosti hladilnika in inicializira temperaturo zamrzovalnika.
	 * Kliče konstruktor nadrazreda Hladilnik za inicializacijo znamke in kapacitete,
     * ter nastavi začetno temperaturo zamrzovalnika na -18 stopinj.
     * 
     * @param model Znamka oziroma model hladilnika.
     * @param kapaciteta Kapaciteta hladilnika v litrih.
     */
	class HladilnikZZamrzovalnikom extends Hladilnik {
    private int temperaturaZamrzovalnika; // Temperatura v zamrzovalniku

    // Konstruktor, ki nastavi osnovne lastnosti in inicializira temperaturo zamrzovalnika
    public HladilnikZZamrzovalnikom(String model, int kapaciteta) {
        super(model, kapaciteta); // Klic konstruktorja nadrazreda
        this.temperaturaZamrzovalnika = -18; // Privzeta temperatura v zamrzovalniku je -18 stopinj
    }

	/**
     * Metoda za spreminjanje temperature v zamrzovalniku.
     * Omogoča povišanje ali znižanje temperature zamrzovalnika za določeno število stopinj.
     * 
     * @param sprememba Število stopinj za spremembo temperature (lahko je tako pozitivno kot negativno).
     */
    // Metoda za spreminjanje temperature v zamrzovalniku
    public void spremeniTemperaturoZamrzovalnika(int sprememba) {
        this.temperaturaZamrzovalnika += sprememba;
    }

    // Getter za temperaturo zamrzovalnika
    public int getTemperaturaZamrzovalnika() {
        return temperaturaZamrzovalnika;
    }

    /**
     * Metoda za nastavitev nove temperature zamrzovalnika z omejitvijo.
     * Temperatura zamrzovalnika mora biti v območju od -30 do 0 stopinj.
     * 
     * @param novaTemperatura Nova temperatura zamrzovalnika.
     */
	 public void spremenitevTemperaturoZamrzovalnika(int novaTemperatura) {
        if (novaTemperatura <= 0 && novaTemperatura >= -30) { // Omejitve za temperaturo zamrzovalnika
            this.temperaturaZamrzovalnika = novaTemperatura;
        } else {
            JOptionPane.showMessageDialog(null, "Temperatura zamrzovalnika ni v veljavnem območju!", "Napaka", JOptionPane.ERROR_MESSAGE); // Ob napačni temperaturi izpišemo napako
        }
    }
}

/**
 * Glavni razred za grafični uporabniški vmesnik
 */
public class GlavniProgramHladilnikGUI extends JFrame {
    private ArrayList<Hladilnik> hladilniki; // Seznam vseh hladilnikov
    private DefaultTableModel modelTabele; // Model tabele za prikaz hladilnikov v GUI
    private JTextField poljeZnamka; // Vnosno polje za znamko hladilnika
    private JTextField poljeKapaciteta; // Vnosno polje za kapaciteto hladilnika

    public GlavniProgramHladilnikGUI() {
        // Inicializacija seznamov in modela tabele
        hladilniki = new ArrayList<>();
        modelTabele = new DefaultTableModel(new String[]{"Znamka", "Kapaciteta", "Temperatura", "Vklopljen", "Povezan na internet"}, 0);

        // Nastavitev osnovnega okna
        setTitle("Upravljanje s Hladilniki");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Dodajanje tabele za prikaz hladilnikov v GUI
        JTable tabela = new JTable(modelTabele);
        JScrollPane drsniPanel = new JScrollPane(tabela); // Dodajanje drsnega panela
        add(drsniPanel, BorderLayout.CENTER);

        // Panel za vnos novih hladilnikov
        JPanel vnosniPanel = new JPanel(new GridLayout(6, 2)); // Povečali smo število vrstic, da dodamo še vrsto hladilnika
        JLabel napisZnamka = new JLabel("Znamka hladilnika:");
        poljeZnamka = new JTextField();

        JLabel napisKapaciteta = new JLabel("Kapaciteta (litri):");
        poljeKapaciteta = new JTextField();

        JLabel napisVrstaHladilnika = new JLabel("Vrsta hladilnika:");
        JComboBox<String> vrstaHladilnikaComboBox = new JComboBox<>();
        vrstaHladilnikaComboBox.addItem("Navaden Hladilnik");
        vrstaHladilnikaComboBox.addItem("Pametni Hladilnik");
        vrstaHladilnikaComboBox.addItem("Hladilnik z Zamrzovalnikom");

        JButton gumbDodaj = new JButton("Dodaj Hladilnik");

        // Dodajanje komponent v vnosni panel
        vnosniPanel.add(napisZnamka);
        vnosniPanel.add(poljeZnamka);
        vnosniPanel.add(napisKapaciteta);
        vnosniPanel.add(poljeKapaciteta);
        vnosniPanel.add(napisVrstaHladilnika);
        vnosniPanel.add(vrstaHladilnikaComboBox);
        vnosniPanel.add(new JLabel()); // Prazna celica
        vnosniPanel.add(gumbDodaj);

        add(vnosniPanel, BorderLayout.NORTH);

        // Dogodek za dodajanje hladilnika v seznam in tabelo
        gumbDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String znamka = poljeZnamka.getText();
                String kapacitetaText = poljeKapaciteta.getText();
                String vrstaHladilnika = (String) vrstaHladilnikaComboBox.getSelectedItem();
                if (!znamka.isEmpty() && !kapacitetaText.isEmpty()) {
                    try {
                        int kapaciteta = Integer.parseInt(kapacitetaText);
                        Hladilnik novHladilnik;

                        // Glede na vrsto hladilnika ustvarimo različne tipe hladilnikov
                        if (vrstaHladilnika.equals("Pametni Hladilnik")) {
                            novHladilnik = new PametniHladilnik(znamka, kapaciteta);
                        } else if (vrstaHladilnika.equals("Hladilnik z Zamrzovalnikom")) {
                            novHladilnik = new HladilnikZZamrzovalnikom(znamka, kapaciteta);
                        } else {
                            novHladilnik = new Hladilnik(znamka, kapaciteta);
                        }

                        // Dodajanje novega hladilnika v seznam in posodobitev tabele
                        hladilniki.add(novHladilnik);
                        modelTabele.addRow(new Object[]{novHladilnik.getZnamka(), novHladilnik.getKapaciteta(),
                                novHladilnik.getTemperatura(), novHladilnik.jeVklopljen(), novHladilnik.jePovezanNaInternet()});
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Napaka pri vnosu kapacitete!", "Napaka", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Panel za funkcionalnosti, ki omogočajo upravljanje s hladilnikom
        JPanel panelFunkcionalnosti = new JPanel();
        JButton gumbVklopi = new JButton("Vklopi");
        JButton gumbIzklopi = new JButton("Izklopi");
        JButton gumbPovezi = new JButton("Poveži na Internet");
        JButton gumbSpremeniTemperaturo = new JButton("Spremeni temperaturo");

        panelFunkcionalnosti.add(gumbVklopi);
        panelFunkcionalnosti.add(gumbIzklopi);
        panelFunkcionalnosti.add(gumbPovezi);
        panelFunkcionalnosti.add(gumbSpremeniTemperaturo);

        add(panelFunkcionalnosti, BorderLayout.SOUTH);

        // Dogodki za izvedbo akcij na izbranem hladilniku
        gumbVklopi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int izbranaVrstica = tabela.getSelectedRow();
                if (izbranaVrstica >= 0) {
                    Hladilnik izbranHladilnik = hladilniki.get(izbranaVrstica);
                    izbranHladilnik.vkljuci();
                    modelTabele.setValueAt(izbranHladilnik.getTemperatura(), izbranaVrstica, 2); // Posodobi temperaturo v tabeli
                    modelTabele.setValueAt(izbranHladilnik.jeVklopljen(), izbranaVrstica, 3); // Posodobi status vklopa
                }
            }
        });

        // Izklop hladilnika
        gumbIzklopi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int izbranaVrstica = tabela.getSelectedRow();
                if (izbranaVrstica >= 0) {
                    Hladilnik izbranHladilnik = hladilniki.get(izbranaVrstica);
                    izbranHladilnik.izkljuci();
                    modelTabele.setValueAt(izbranHladilnik.getTemperatura(), izbranaVrstica, 2);
                    modelTabele.setValueAt(izbranHladilnik.jeVklopljen(), izbranaVrstica, 3);
                }
            }
        });

        // Povezovanje pametnega hladilnika na internet
        gumbPovezi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int izbranaVrstica = tabela.getSelectedRow();
                if (izbranaVrstica >= 0) {
                    Hladilnik izbranHladilnik = hladilniki.get(izbranaVrstica);
                    if (izbranHladilnik instanceof PametniHladilnik) {
                        PametniHladilnik pametniHladilnik = (PametniHladilnik) izbranHladilnik;
                        pametniHladilnik.poveziNaInternet();
                        JOptionPane.showMessageDialog(null, "Hladilnik povezan na internet.", "Povezava", JOptionPane.INFORMATION_MESSAGE);
                        modelTabele.setValueAt(true, izbranaVrstica, 4);
                    } else {
                        JOptionPane.showMessageDialog(null, "Izbran hladilnik ni pametni hladilnik!", "Napaka", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Spreminjanje temperature hladilnika
        gumbSpremeniTemperaturo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int izbranaVrstica = tabela.getSelectedRow();
                if (izbranaVrstica >= 0) {
                    Hladilnik izbranHladilnik = hladilniki.get(izbranaVrstica);
                    String novaTemperaturaStr = JOptionPane.showInputDialog("Vnesite novo temperaturo:");
                    if (novaTemperaturaStr != null) {
                        try {
                            int novaTemperatura = Integer.parseInt(novaTemperaturaStr);
                            izbranHladilnik.spremeniTemperaturo(novaTemperatura);
                            modelTabele.setValueAt(izbranHladilnik.getTemperatura(), izbranaVrstica, 2); // Posodobi temperaturo v tabeli
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Napaka pri vnosu temperature!", "Napaka", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    // Glavna metoda za zagon GUI aplikacije
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GlavniProgramHladilnikGUI().setVisible(true); // Ustvari in prikaži okno aplikacije
            }
        });
    }
}
