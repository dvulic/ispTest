package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import model.KvizPlayable;
import model.Pitanje;
import model.Predmet;
import model.base.Server;
import view.IgrajView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class IgrajControl implements EventHandler<ActionEvent> {
    private ComboBox<Predmet> cbPredmeti;

    public IgrajControl(ComboBox<Predmet> cbPredmeti) {
        this.cbPredmeti = cbPredmeti;
    }

    @Override
    public void handle(ActionEvent event) {
        Predmet predmet = cbPredmeti.getSelectionModel().getSelectedItem();
        ArrayList<Pitanje> pitanja = new ArrayList<>();
        //Pitanje pitanje =
        if(predmet.getNazivPredmeta().equals("Svi predmeti")){
            pitanja.addAll(Server.SERVER.getPitanjeSet());
        }
        else {
            for (Pitanje p:Server.SERVER.getPitanjeSet()
                 ) {
                if (p.getPredmet().getNazivPredmeta().equals(predmet.getNazivPredmeta())){
                    pitanja.add(p);
                }
            }
        }
        KvizPlayable kp = new KvizPlayable(predmet, pitanja);
        IgrajView.IGRAJ_VIEW.getTfOdgovor().setText("");
        IgrajView.IGRAJ_VIEW.getLbTekstPitanja().setText(pitanja.get(0).getPitanje());
        Server.SERVER.setKvizPlayable(kp);
        IgrajView.IGRAJ_VIEW.show();
    }
}
