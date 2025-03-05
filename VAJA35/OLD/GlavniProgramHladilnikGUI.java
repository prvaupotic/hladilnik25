// Uvozimo razred za delo z vhodno-izhodnimi operacijami ter pripomočke
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlavniProgramHladilnikGUI extends JFrame implements ActionListener {
    private HladilnikTableZnamka znamkaTabele;
    private JTable tabela;
    private JTextField poljeZnamka, poljeKapaciteta;
    private JButton gumbDodaj, gumbVkljuci, gumbIzkljuci, gumbPovecaj, gumbZmanjsaj;

    public GlavniProgramHladilnikGUI() {
        znamkaTabele = new HladilnikTableZnamka();
        tabela = new JTable(znamkaTabele);

        poljeZnamka = new JTextField(20);
        poljeKapaciteta = new JTextField(5);

        gumbDodaj = new JButton("Dodaj");
        gumbVkljuci = new JButton("Vključi");
        gumbIzkljuci = new JButton("Izključi");
        gumbPovecaj = new JButton("Povečaj temp.");
        gumbZmanjsaj = new JButton("Zmanjšaj temp.");

        gumbDodaj.addActionListener(this);
        gumbVkljuci.addActionListener(this);
        gumbIzkljuci.addActionListener(this);
        gumbPovecaj.addActionListener(this);
        gumbZmanjsaj.addActionListener(this);

        JPanel vnosniPanel = new JPanel();
        vnosniPanel.add(new JLabel("Znamka:"));
        vnosniPanel.add(poljeZnamka);
        vnosniPanel.add(new JLabel("Kapaciteta:"));
        vnosniPanel.add(poljeKapaciteta);
        vnosniPanel.add(gumbDodaj);

        JPanel gumbiPanel = new JPanel();
        gumbiPanel.add(gumbVkljuci);
        gumbiPanel.add(gumbIzkljuci);
        gumbiPanel.add(gumbPovecaj);
        gumbiPanel.add(gumbZmanjsaj);

        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(vnosniPanel, BorderLayout.NORTH);
        add(gumbiPanel, BorderLayout.SOUTH);

        setTitle("Upravljanje s hladilniki");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gumbDodaj) {
            String znamka = poljeZnamka.getText();
            int kapaciteta = Integer.parseInt(poljeKapaciteta.getText());
            Hladilnik hladilnik = new Hladilnik(znamka, kapaciteta);
            znamkaTabele.dodajHladilnik(hladilnik);
        } else if (e.getSource() == gumbVkljuci) {
            int izbranaVrstica = tabela.getSelectedRow();
            if (izbranaVrstica >= 0) {
                Hladilnik hladilnik = znamkaTabele.getHladilnik(izbranaVrstica);
                hladilnik.vkljuci();
                znamkaTabele.fireTableRowsUpdated(izbranaVrstica, izbranaVrstica);
            }
        } else if (e.getSource() == gumbIzkljuci) {
            int izbranaVrstica = tabela.getSelectedRow();
            if (izbranaVrstica >= 0) {
                Hladilnik hladilnik = znamkaTabele.getHladilnik(izbranaVrstica);
                hladilnik.izkljuci();
                znamkaTabele.fireTableRowsUpdated(izbranaVrstica, izbranaVrstica);
            }
        } else if (e.getSource() == gumbPovecaj) {
            int izbranaVrstica = tabela.getSelectedRow();
            if (izbranaVrstica >= 0) {
                Hladilnik hladilnik = znamkaTabele.getHladilnik(izbranaVrstica);
                hladilnik.povecajTemperaturo(5); // Povečamo za 5 stopinj
                znamkaTabele.fireTableRowsUpdated(izbranaVrstica, izbranaVrstica);
            }
        } else if (e.getSource() == gumbZmanjsaj) {
            int izbranaVrstica = tabela.getSelectedRow();
            if (izbranaVrstica >= 0) {
                Hladilnik hladilnik = znamkaTabele.getHladilnik(izbranaVrstica);
                hladilnik.zmanjsajTemperaturo(5); // Zmanjšamo za 5 stopinj
                znamkaTabele.fireTableRowsUpdated(izbranaVrstica, izbranaVrstica);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GlavniProgramHladilnikGUI::new);
    }
}