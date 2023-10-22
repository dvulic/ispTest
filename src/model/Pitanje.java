package model;

public class Pitanje {
    private String odgovor;
    private String pitanje;
    private Predmet predmet;

    public Pitanje(String odgovor, String pitanje, Predmet predmet) {
        this.odgovor = odgovor;
        this.pitanje = pitanje;
        this.predmet = predmet;
    }

    @Override
    public String toString() {
        return pitanje;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public String getPitanje() {
        return pitanje;
    }
}
