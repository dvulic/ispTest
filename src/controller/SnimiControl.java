package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.utility.FileUtils;

import java.nio.channels.Pipe;

public class SnimiControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        FileUtils.SacuvajPitanja("src/pitanja_out.txt");
    }
}
