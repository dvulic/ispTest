package view;

import controller.IgrajView.DaljeControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.KvizPlayable;
import model.Pitanje;
import model.Predmet;
import model.base.Server;

import java.util.Set;


public class IgrajView extends Stage {
    public static IgrajView IGRAJ_VIEW = new IgrajView();

    private final VBox root = new VBox();

    //root hbox1
    private final Label l1 = new Label("Pitanje");
    private Label lbTekstPitanja = new Label();
    private final Label l2 = new Label("Odgovor");

    //root hbox2
    private TextField tfOdgovor = new TextField();
    //root hbox3
    private final Button btDalje = new Button("Dalje");

    public Label getLbTekstPitanja() {
        return lbTekstPitanja;
    }

    public TextField getTfOdgovor() {
        return tfOdgovor;
    }

    private IgrajView(){
        btDalje.setOnAction(new DaljeControl(lbTekstPitanja, tfOdgovor));
        setHbox1();
        setHbox2();
        setHbox3();
        super.setScene(new Scene(root, 400, 300));
    }

    private void setHbox1(){
        VBox vBox = new VBox(20, l1, lbTekstPitanja, l2);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setPadding(new Insets(10));
        this.root.getChildren().add(vBox);
    }

    private void setHbox2(){
        VBox vBox = new VBox(10,tfOdgovor);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20, 5, 5, 10));
        this.root.getChildren().add(vBox);
    }

    private void setHbox3(){
        VBox vBox = new VBox(10, btDalje);
        vBox.setPadding(new Insets(30));
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        this.root.getChildren().add(vBox);

    }
}
