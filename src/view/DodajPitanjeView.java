package view;

import controller.DodajPitanjeView.DodajControl;
import controller.DodajPitanjeView.OdustaniControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DodajPitanjeView extends Stage {
    public static DodajPitanjeView DODAJ_PITANJE_VIEW = new DodajPitanjeView();

    private final VBox root = new VBox();

    //root hbox1
    private final Label l1 = new Label("Pitanje: ");
    private TextField tfPitanje = new TextField();

    //root hbox2
    private final Label l2 = new Label("Odgovor: ");
    private TextField tfOdgovor = new TextField();

    //root hbox3
    private final Label l3 = new Label("Predmet: ");
    private TextField tfPredmet = new TextField();

    //root hbox4

    private final Button btOdustani = new Button("Odustani");
    private final Button btDodaj = new Button("Dodaj");

    private DodajPitanjeView(){
        btDodaj.setOnAction(new DodajControl(tfPitanje, tfOdgovor, tfPredmet));
        btOdustani.setOnAction(new OdustaniControl());
        setHbox1();
        setHbox2();
        setHbox3();
        setHbox4();
        super.setScene(new Scene(root, 500, 300));
    }

    private void setHbox1(){
        HBox hBox = new HBox(30, l1, tfPitanje);
        l1.setAlignment(Pos.CENTER_LEFT);
        tfPitanje.setAlignment(Pos.CENTER_LEFT);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        this.root.getChildren().add(hBox);
    }

    private void setHbox2(){
        HBox hBox = new HBox(25, l2, tfOdgovor);
        l2.setAlignment(Pos.CENTER_LEFT);
        tfOdgovor.setAlignment(Pos.CENTER_LEFT);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        this.root.getChildren().add(hBox);
    }
    private void setHbox3(){
        HBox hBox = new HBox(25, l3, tfPredmet);
        l3.setAlignment(Pos.CENTER_LEFT);
        tfPredmet.setAlignment(Pos.CENTER_LEFT);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        this.root.getChildren().add(hBox);
    }

    private void setHbox4(){
        HBox hBox = new HBox(300, btOdustani,btDodaj);
        hBox.setAlignment(Pos.CENTER);
        btOdustani.setAlignment(Pos.CENTER_LEFT);
        btDodaj.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(10));
        this.root.getChildren().add(hBox);
    }
}
