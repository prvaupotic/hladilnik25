/**
 * Razred za predstavitev hladilnika z zamrzovalnikom.
 */
class HladilnikZZamrzovalnikom extends OsnovniHladilnik {

    private int temperaturaZamrzovalnika;

    public HladilnikZZamrzovalnikom(String model, int kapaciteta) {
        super(model, kapaciteta);
        this.temperaturaZamrzovalnika = -18;
    }

    public void spremeniTemperaturoZamrzovalnika(int sprememba) {
        this.temperaturaZamrzovalnika += sprememba;
    }

    public int getTemperaturaZamrzovalnika() {
        return temperaturaZamrzovalnika;
    }
}