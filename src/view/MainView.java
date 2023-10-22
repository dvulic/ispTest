package view;

import controller.DodajPitanjeControl;
import controller.IgrajControl;
import controller.SnimiControl;
import controller.UcitajZaPredmetControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Kviz;
import model.KvizPlayable;
import model.Pitanje;
import model.Predmet;
import model.base.Server;
import view.tables.KvizTableView;


public class MainView extends Stage {
    public static MainView MAIN_VIEW = new MainView();

    private final VBox root = new VBox();

    //root -> vbox1
    private ListView<Pitanje> lvPitanje = new ListView<Pitanje>(FXCollections.observableArrayList(Server.SERVER.getPitanjeSet()));
    private TableView<Kviz> tvKviz = new KvizTableView(FXCollections.observableArrayList(Server.SERVER.getKvizLista()));
    //root -> vbox1
    private ComboBox<Predmet> cbPredmeti = new ComboBox<>(FXCollections.observableArrayList(Server.SERVER.getPredmetset()));//TODO
    private final Button btUcitajZaPredmet = new Button("Ucitaj za predmet");
    private final Button btDodajPitanje = new Button("Dodaj Pitanje");
    private final Button btSnimi = new Button("Snimi");
    private final Button btIgraj = new Button("Igraj");


    private MainView(){
        btSnimi.setOnAction(new SnimiControl());
        btUcitajZaPredmet.setOnAction(new UcitajZaPredmetControl(lvPitanje, cbPredmeti));
        btIgraj.setOnAction(new IgrajControl(cbPredmeti));
        btDodajPitanje.setOnAction(new DodajPitanjeControl());
        setHBox1();
        setHBox2();
        super.setScene(new Scene(root, 800, 600));
    }

    public ListView<Pitanje> getLvPitanje() {
        return lvPitanje;
    }

    public ComboBox<Predmet> getCbPredmeti() {
        return cbPredmeti;
    }

    public TableView<Kviz> getTvKviz() {
        return tvKviz;
    }

    private void setHBox1(){
        HBox vBox = new HBox(10, lvPitanje, tvKviz);
        vBox.setPadding(new Insets(30));
        vBox.setAlignment(Pos.CENTER);
        this.root.getChildren().add(vBox);
    }

    private void setHBox2(){
        cbPredmeti.getItems().add(new Predmet("Svi predmeti"));
        cbPredmeti.getSelectionModel().select(cbPredmeti.getItems().size()-1);
        HBox vBox = new HBox(10, cbPredmeti, btUcitajZaPredmet, btDodajPitanje, btSnimi, btIgraj);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        this.root.getChildren().add(vBox);

    }
}
