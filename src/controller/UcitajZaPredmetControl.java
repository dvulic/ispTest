package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import model.Pitanje;
import model.Predmet;
import model.base.Server;

public class UcitajZaPredmetControl implements EventHandler<ActionEvent> {
    private ListView<Pitanje> lvPitanje;
    private ComboBox<Predmet> cbPredmet;
    private ObservableList<Pitanje> obLista;

    public UcitajZaPredmetControl(ListView<Pitanje> lvPitanje, ComboBox<Predmet> cbPredmet) {
        this.lvPitanje = lvPitanje;
        this.cbPredmet = cbPredmet;
    }

    @Override
    public void handle(ActionEvent event) {
        obLista = FXCollections.observableArrayList();
        Predmet predmet = cbPredmet.getSelectionModel().getSelectedItem();
        if(predmet.getNazivPredmeta().equals("Svi predmeti")){
            obLista.addAll(Server.SERVER.getPitanjeSet());

        }
        else {
            for (Pitanje pitanje: Server.SERVER.getPitanjeSet()
                 ) {
                if(pitanje.getPredmet().getNazivPredmeta().equals(predmet.getNazivPredmeta())){
                    obLista.add(pitanje);
                }
            }

        }
        lvPitanje.setItems(obLista);
        lvPitanje.refresh();

    }
}
