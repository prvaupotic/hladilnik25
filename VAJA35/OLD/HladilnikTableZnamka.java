import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HladilnikTableZnamka extends DefaultTableModel {
    private ArrayList<Hladilnik> hladilniki;

    // Konstruktor, ki inicializira seznam hladilnikov in stolpce tabele
    public HladilnikTableZnamka() {
        hladilnik = new ArrayList<Hladilnik>();  // Starejša sintaksa brez predogleda
        // Dodajanje stolpcev
        super(new Object[]{"Znamka", "Kapaciteta", "Temperatura", "Vklopljen"}, 0);
    }

    // Dodajanje hladilnika v seznam
    public void dodajHladilnik(Hladilnik hladilnik) {
        hladilniki.add(hladilnik);
        fireTableRowsInserted(hladilniki.size() - 1, hladilniki.size() - 1); // Obvesti tabelo, da je nov hladilnik dodan
    }

    // Pridobitev hladilnika iz seznama
    public Hladilnik getHladilnik(int rowIndex) {
        return hladilniki.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return hladilniki.size();  // Število vrstic
    }

    @Override
    public Object getValueAt(int row, int column) {
        Hladilnik hladilnik = hladilniki.get(row);
        switch (column) {
            case 0: return hladilnik.getZnamka();       // Znamka hladilnika
            case 1: return hladilnik.getKapaciteta();   // Kapaciteta hladilnika
            case 2: return hladilnik.getTemperatura();  // Temperatura hladilnika
            case 3: return hladilnik.jeVklopljen() ? "Vklopljen" : "Izklopljen";  // Status vklopa
            default: return null;
        }
    }
}
