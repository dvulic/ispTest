package controller.IgrajView;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Kviz;
import model.KvizPlayable;
import model.Pitanje;
import model.Predmet;
import model.base.Server;
import view.IgrajView;
import view.MainView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

public class DaljeControl implements EventHandler<ActionEvent> {
    private KvizPlayable kvizPlayable;
    private Label lbTekstPitanja;
    private TextField tfOdgovor;

    public DaljeControl(Label lbTekstPitanja, TextField tfOdgovor) {

        this.lbTekstPitanja = lbTekstPitanja;
        this.tfOdgovor = tfOdgovor;
    }

    @Override
    public void handle(ActionEvent event) {
        kvizPlayable = Server.SERVER.getKvizPlayable();
        if(kvizPlayable != null){
            if(!kvizPlayable.getPitanja().isEmpty()){
                Pitanje trenutnoPitanje = kvizPlayable.getPitanja().get(0);
                if(trenutnoPitanje.getOdgovor().toLowerCase(Locale.ROOT).equals(tfOdgovor.getText().toLowerCase(Locale.ROOT))){
                    kvizPlayable.uvecajSkor();
                }
                kvizPlayable.getPitanja().remove(0);
                if(!kvizPlayable.getPitanja().isEmpty()){
                    Pitanje sledecePitanje = kvizPlayable.getPitanja().get(0);
                    lbTekstPitanja.setText(sledecePitanje.getPitanje());
                    tfOdgovor.setText("");
                }
                else{
                    Server.SERVER.getKvizLista().add(new Kviz(kvizPlayable.getSkor(), kvizPlayable.getDatum(), kvizPlayable.getPredmet()));
                    MainView.MAIN_VIEW.getTvKviz().setItems(FXCollections.observableArrayList(Server.SERVER.getKvizLista()));
                    MainView.MAIN_VIEW.getTvKviz().refresh();
                    IgrajView.IGRAJ_VIEW.close();
                }

            }
            else {
                IgrajView.IGRAJ_VIEW.close();
            }
        }


    }
}
