import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Razred za prikaz grafičnega uporabniškega vmesnika za delo z objekti hladilnikov.
 */
public class HladilnikGUI {

    private JFrame frame;
    private JTextField znamkaField;
    private JTextField kapacitetaField;
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Hladilnik> hladilniki;

    public HladilnikGUI() {
        hladilniki = new ArrayList<>();
        initialize();
    }

    /**
     * Inicializacija grafičnega uporabniškega vmesnika
     */
    private void initialize() {
        // Nastavitev okna
        frame = new JFrame("Hladilniki");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nastavitev glavne plošče za postavitev komponent
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(5, 2));  // Sprememba za dodatne komponente

        // Vnos za model hladilnika
        JLabel znamkaLabel = new JLabel("Znamka hladilnika:");
        panel.add(znamkaLabel);
        znamkaField = new JTextField();
        panel.add(znamkaField);

        // Vnos za kapaciteto hladilnika
        JLabel kapacitetaLabel = new JLabel("Kapaciteta (v litrih):");
        panel.add(kapacitetaLabel);
        kapacitetaField = new JTextField();
        panel.add(kapacitetaField);

        // Gumb za dodajanje osnovnega hladilnika
        JButton btnAddHladilnik = new JButton("Dodaj Hladilnik");
        btnAddHladilnik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHladilnik();
            }
        });
        panel.add(btnAddHladilnik);

        // Gumb za dodajanje hladilnika z zamrzovalnikom
        JButton btnAddHladilnikZZamrzovalnikom = new JButton("Dodaj Hladilnik z Zamrzovalnikom");
        btnAddHladilnikZZamrzovalnikom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHladilnikZZamrzovalnikom();
            }
        });
        panel.add(btnAddHladilnikZZamrzovalnikom);

        // Tabela za prikaz hladilnikov
        tableModel = new DefaultTableModel(new Object[]{"Znamka", "Kapaciteta", "Temperatura", "Temperatura Zamrzovalnika"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Prikaz okna
        frame.setVisible(true);
    }

    /**
     * Metoda za dodajanje osnovnega hladilnika v seznam in prikaz v tabeli.
     */
    private void addHladilnik() {
        String znamka = znamkaField.getText();
        String kapacitetaStr = kapacitetaField.getText();

        // Preverjanje vnesenih podatkov
        if (znamka.isEmpty() || kapacitetaStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Vnesite vse podatke!", "Napaka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int kapaciteta = Integer.parseInt(kapacitetaStr);
            // Ustvarite objekt hladilnika
            Hladilnik novHladilnik = new Hladilnik(znamka, kapaciteta);
            hladilniki.add(novHladilnik);  // Dodamo hladilnik v seznam

            // Dodajanje podatkov v tabelo
            tableModel.addRow(new Object[]{znamka, kapaciteta, novHladilnik.povecajTemperaturo(), ""});

            // Počistimo polja za vnos
            znamkaField.setText("");
            kapacitetaField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Kapaciteta mora biti številka!", "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metoda za dodajanje hladilnika z zamrzovalnikom v seznam in prikaz v tabeli.
     */
    private void addHladilnikZZamrzovalnikom() {
        String znamka = znamkaField.getText();
        String kapacitetaStr = kapacitetaField.getText();

        // Preverjanje vnesenih podatkov
        if (znamka.isEmpty() || kapacitetaStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Vnesite vse podatke!", "Napaka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int kapaciteta = Integer.parseInt(kapacitetaStr);
            // Ustvarite objekt hladilnika z zamrzovalnikom
            HladilnikZZamrzovalnikom novHladilnikZZamrzovalnikom = new HladilnikZZamrzovalnikom(znamka, kapaciteta);
            hladilniki.add(novHladilnikZZamrzovalnikom);  // Dodamo hladilnik z zamrzovalnikom v seznam

            // Dodajanje podatkov v tabelo (pokažemo temperaturo v zamrzovalniku)
            tableModel.addRow(new Object[]{znamka, kapaciteta, novHladilnikZZamrzovalnikom.povecajTemperaturo(), novHladilnikZZamrzovalnikom.getTemperaturaZamrzovalnika()});

            // Počistimo polja za vnos
            znamkaField.setText("");
            kapacitetaField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Kapaciteta mora biti številka!", "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HladilnikGUI();
            }
        });
    }
}
