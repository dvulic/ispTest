package model;

public class Predmet {
    private String nazivPredmeta;

    public Predmet(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    @Override
    public String toString() {
        return nazivPredmeta;
    }
}
