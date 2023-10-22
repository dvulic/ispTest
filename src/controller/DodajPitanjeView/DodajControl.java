package controller.DodajPitanjeView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Pitanje;
import model.Predmet;
import model.base.Server;
import view.DodajPitanjeView;
import view.IgrajView;
import view.MainView;

public class DodajControl implements EventHandler<ActionEvent> {
    private TextField tfPitanje;
    private TextField tfOdgovor;
    private TextField tfPredmet;

    public DodajControl(TextField tfPitanje, TextField tfOdgovor, TextField tfPredmet) {
        this.tfPitanje = tfPitanje;
        this.tfOdgovor = tfOdgovor;
        this.tfPredmet = tfPredmet;
    }

    @Override
    public void handle(ActionEvent event) {
        //TODO
        String tekstPitanja = tfPitanje.getText();
        String odgovorPitanja = tfOdgovor.getText();
        String imePredmetaPitanja = tfPredmet.getText();

        Predmet predmetPitanja = null;
        boolean pronadjen = false;
        //resavanje predmeta
        for (Predmet p: Server.SERVER.getPredmetset()
             ) {
            if(p.getNazivPredmeta().equals(imePredmetaPitanja.trim())){
                pronadjen = true;
                predmetPitanja = p;
                break;
            }
        }

        if(!pronadjen){
            predmetPitanja = new Predmet(imePredmetaPitanja.trim());
            Server.SERVER.getPredmetset().add(predmetPitanja);
        }

        //dodavanje pitanja
        if(predmetPitanja != null){
            Server.SERVER.getPitanjeSet().add(new Pitanje(odgovorPitanja, tekstPitanja, predmetPitanja));

            ListView<Pitanje> lvPitanje = MainView.MAIN_VIEW.getLvPitanje();
            ComboBox<Predmet> cbPredmeti = MainView.MAIN_VIEW.getCbPredmeti();

            //MainView.MAIN_VIEW.lvPitanjeUcitaj(FXCollections.observableArrayList(Server.SERVER.getPitanjeSet()));
            lvPitanje.setItems(FXCollections.observableArrayList(Server.SERVER.getPitanjeSet()));
            lvPitanje.refresh();

            cbPredmeti.setItems(FXCollections.observableArrayList(Server.SERVER.getPredmetset()));
            cbPredmeti.getItems().add(new Predmet("Svi predmeti"));
            for (Predmet p: cbPredmeti.getItems()
                 ) {
                if(p.getNazivPredmeta().equals("Svi predmeti")){
                    cbPredmeti.getSelectionModel().select(p);
                    break;
                }
            }

            tfOdgovor.setText("");
            tfPitanje.setText("");
            tfPredmet.setText("");
        }

    }
}
