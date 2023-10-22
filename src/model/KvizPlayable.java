package model;

import javafx.scene.control.Label;
import model.Pitanje;
import model.Predmet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class KvizPlayable {
    private Predmet predmet;
    private ArrayList<Pitanje> pitanja;
    private int skor;
    private LocalDate datum;
    private Label tekstPitanja;

    public KvizPlayable(Predmet predmet, ArrayList<Pitanje> pitanja) {
        this.predmet = predmet;
        this.pitanja = pitanja;
        this.skor = 0;
        this.datum = LocalDate.now();
    }

    public void uvecajSkor() {
        this.skor += 1;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public ArrayList<Pitanje> getPitanja() {
        return pitanja;
    }

    public int getSkor() {
        return skor;
    }
}
