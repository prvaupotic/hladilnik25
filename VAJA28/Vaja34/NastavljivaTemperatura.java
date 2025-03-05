/**
 * Vmesnik za objekte, ki imajo nastavljivo temperaturo.
 */
interface NastavljivaTemperatura {

    /**
     * Metoda za nastavitev temperature.
     * @param temperatura Nova temperatura.
     */
    void nastaviTemperaturo(int temperatura);

    /**
     * Metoda za pridobitev trenutne temperature.
     * @return Trenutna temperatura.
     */
    int pridobiTemperaturo();
}