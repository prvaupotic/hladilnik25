/**
 * Razred za predstavitev osnovnega hladilnika.
 */
public class Hladilnik extends OsnovniHladilnik {

    public Hladilnik(String model, int kapaciteta) {
        super(model, kapaciteta);
    }

    public void povecajTemperaturo(int sprememba) {
        temperatura += sprememba;
    }

    public void zmanjsajTemperaturo(int sprememba) {
        temperatura -= sprememba;
        if (temperatura < 0) {
            temperatura = 0;
        }
    }
}