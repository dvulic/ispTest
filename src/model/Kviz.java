package model;

import java.time.LocalDate;

public class Kviz {
    private int skor;
    private LocalDate datum;
    private Predmet predmet;

    public Kviz(int skor, LocalDate datum, Predmet predmet) {
        this.skor = skor;
        this.datum = datum;
        this.predmet = predmet;
    }

    public int getSkor() {
        return skor;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Predmet getPredmet() {
        return predmet;
    }
}
