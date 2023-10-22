package controller.DodajPitanjeView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.DodajPitanjeView;

public class OdustaniControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        DodajPitanjeView.DODAJ_PITANJE_VIEW.close();
    }
}
