// Uvozimo razred za delo z vhodno-izhodnimi operacijami ter pripomočke
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HladilnikTableModel extends DefaultTableModel {
    private ArrayList<Hladilnik> hladilniki;
    private String[] stolpci = {"Model", "Kapaciteta", "Temperatura", "Vklopljen"};

    public HladilnikTableModel() {
		System.out.println("Ustvarjam HladilnikTableModel");
        hladilniki = new ArrayList<>(); // Inicializacija seznama
        setColumnIdentifiers(stolpci);
    }

    @Override
    public int getRowCount() {
        return hladilniki.size();
    }

    @Override
    public Object getValueAt(int vrstica, int stolpec) {
        Hladilnik hladilnik = hladilniki.get(vrstica);
        switch (stolpec) {
            case 0: return hladilnik.getModel();
            case 1: return hladilnik.getKapaciteta();
            case 2: return hladilnik.getTemperatura();
            case 3: return hladilnik.jeVklopljen();
            default: return null;
        }
    }

    public void dodajHladilnik(Hladilnik hladilnik) {
        hladilniki.add(hladilnik);
        fireTableDataChanged();
    }

    public Hladilnik getHladilnik(int vrstica) {
        return hladilniki.get(vrstica);
    }
}