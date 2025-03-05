import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Predpostavljam, da imaš razred OsnovniHladilnik in Hladilnik že definirana
// Če ne, ju bo treba definirati z ustreznimi metodami (getModel, getKapaciteta, itd.)

public class Hladilnik extends JFrame implements ActionListener {
    private ArrayList<OsnovniHladilnik> hladilniki;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private JTextField modelField, kapacitetaField, temperaturaField;
    private JButton dodajButton, povecajButton, zmanjsajButton;

    public Hladilnik() {
        // Inicializacija seznama hladilnikov
        hladilniki = new ArrayList<>();
        
        // Nastavitev okna
        setTitle("Upravljanje Hladilnikov");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Inicializacija tabele
        String[] stolpci = {"Model", "Kapaciteta (L)", "Temperatura (°C)"};
        tableModel = new DefaultTableModel(stolpci, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Celice niso ureljive neposredno
            }
        };
        tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Panel za vnos
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        // Polja za vnos
        inputPanel.add(new JLabel("Model:"));
        modelField = new JTextField(20);
        inputPanel.add(modelField);
        
        inputPanel.add(new JLabel("Kapaciteta (L):"));
        kapacitetaField = new JTextField(5);
        inputPanel.add(kapacitetaField);
        
        inputPanel.add(new JLabel("Sprememba temp (°C):"));
        temperaturaField = new JTextField(5);
        inputPanel.add(temperaturaField);

        // Gumbi
        dodajButton = new JButton("Dodaj hladilnik");
        povecajButton = new JButton("Povečaj temperaturo");
        zmanjsajButton = new JButton("Zmanjšaj temperaturo");
        
        dodajButton.addActionListener(this);
        povecajButton.addActionListener(this);
        zmanjsajButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(dodajButton);
        buttonPanel.add(povecajButton);
        buttonPanel.add(zmanjsajButton);
        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Začetni podatki
        dodajZacetneHladilnike();
    }

    private void dodajZacetneHladilnike() {
        hladilniki.add(new Hladilnik("Gorenje Retro", 250));
        hladilniki.add(new Hladilnik("Samsung NoFrost", 300));
        hladilniki.add(new Hladilnik("Bosch Serie 8", 200));
        osveziTabelo();
    }

    private void osveziTabelo() {
        tableModel.setRowCount(0); // Počisti tabelo
        for (OsnovniHladilnik h : hladilniki) {
            Object[] vrstica = {
                h.getModel(),
                h.getKapaciteta(),
                h.pridobiTemperaturo()
            };
            tableModel.addRow(vrstica);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == dodajButton) {
                String model = modelField.getText();
                int kapaciteta = Integer.parseInt(kapacitetaField.getText());
                
                OsnovniHladilnik novHladilnik = new Hladilnik(model, kapaciteta);
                novHladilnik.vkljuci();
                hladilniki.add(novHladilnik);
                osveziTabelo();
                
                // Počisti polja
                modelField.setText("");
                kapacitetaField.setText("");
                
            } else if (e.getSource() == povecajButton || e.getSource() == zmanjsajButton) {
                int selectedRow = tabela.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(this, "Izberite hladilnik iz tabele!");
                    return;
                }
                
                int stopinje = Integer.parseInt(temperaturaField.getText());
                OsnovniHladilnik izbran = hladilniki.get(selectedRow);
                
                if (e.getSource() == povecajButton) {
                    izbran.povecajTemperaturo(stopinje);
                } else {
                    izbran.zmanjsajTemperaturo(stopinje);
                }
                osveziTabelo();
                temperaturaField.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vnesite veljavne številke za kapaciteto in temperaturo!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Hladilnik gui = new Hladilnik();
            gui.setVisible(true);
        });
    }
}