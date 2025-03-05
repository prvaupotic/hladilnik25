import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Razred za prikaz grafičnega uporabniškega vmesnika za delo z objekti hladilnikov.
 * @author Primož Vaupotič
 * @version Vaja 35 - GUI za delo z objekti in njihovim seznamom
 */
public class HladilnikGUI {

    private JFrame frame;
    private JTextField modelField;
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
        panel.setLayout(new GridLayout(4, 2));

        // Vnos za model hladilnika
        JLabel modelLabel = new JLabel("Model hladilnika:");
        panel.add(modelLabel);
        modelField = new JTextField();
        panel.add(modelField);

        // Vnos za kapaciteto hladilnika
        JLabel kapacitetaLabel = new JLabel("Kapaciteta (v litrih):");
        panel.add(kapacitetaLabel);
        kapacitetaField = new JTextField();
        panel.add(kapacitetaField);

        // Gumb za dodajanje hladilnika
        JButton btnAddHladilnik = new JButton("Dodaj Hladilnik");
        btnAddHladilnik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHladilnik();
            }
        });
        panel.add(btnAddHladilnik);

        // Tabela za prikaz hladilnikov
        tableModel = new DefaultTableModel(new Object[]{"Model", "Kapaciteta", "Temperatura"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Prikaz okna
        frame.setVisible(true);
    }

    /**
     * Metoda za dodajanje hladilnika v seznam in prikaz v tabeli.
     */
    private void addHladilnik() {
        String model = modelField.getText();
        String kapacitetaStr = kapacitetaField.getText();

        // Preverjanje vnesenih podatkov
        if (model.isEmpty() || kapacitetaStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Vnesite vse podatke!", "Napaka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int kapaciteta = Integer.parseInt(kapacitetaStr);
            // Ustvarite objekt hladilnika
            Hladilnik novHladilnik = new Hladilnik(model, kapaciteta);
            hladilniki.add(novHladilnik);  // Dodamo hladilnik v seznam

            // Dodajanje podatkov v tabelo
            tableModel.addRow(new Object[]{model, kapaciteta, novHladilnik.povecajTemperaturo()});

            // Počistimo polja za vnos
            modelField.setText("");
            kapacitetaField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Kapaciteta mora biti številka!", "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HladilnikGUI();
            }
        });
    }
}
