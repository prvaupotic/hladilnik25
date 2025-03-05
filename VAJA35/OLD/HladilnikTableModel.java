// Uvozimo razred za delo z vhodno-izhodnimi operacijami ter pripomočke
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HladilnikTableModel extends DefaultTableModel {
    private ArrayList<Hladilnik> hladilniki;

    // Popravljeno: inicializacija seznama hladilniki
    public HladilnikTableModel() {
        hladilniki = new ArrayList<>();  // Inicializacija seznama
        addColumn("Znamka");
        addColumn("Kapaciteta");
        addColumn("Temperatura");
        addColumn("Vklopljen");
    }

    public void dodajHladilnik(Hladilnik hladilnik) {
        hladilniki.add(hladilnik);
        fireTableRowsInserted(hladilniki.size() - 1, hladilniki.size() - 1);
    }

    public Hladilnik getHladilnik(int rowIndex) {
        return hladilniki.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return hladilniki.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Hladilnik hladilnik = hladilniki.get(row);
        switch (column) {
            case 0: return hladilnik.getZnamka();
            case 1: return hladilnik.getKapaciteta();
            case 2: return hladilnik.getTemperatura();
            case 3: return hladilnik.jeVklopljen() ? "Vklopljen" : "Izklopljen";
            default: return null;
        }
    }
}
