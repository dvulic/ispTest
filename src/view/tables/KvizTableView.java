package view.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Kviz;
import model.Predmet;

import java.time.LocalDate;
import java.util.ArrayList;

public class KvizTableView extends TableView<Kviz> {
    public KvizTableView(ObservableList<Kviz> kvizLista){
        super(kvizLista);
        TableColumn<Kviz, Predmet> tcPredmet = new TableColumn<>("Predmet");
        TableColumn<Kviz, LocalDate> tcDatum = new TableColumn<>("Datum");
        TableColumn<Kviz, Integer> tcSkor = new TableColumn<>("Skor");

        tcPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcSkor.setCellValueFactory(new PropertyValueFactory<>("skor"));

        this.getColumns().add(tcPredmet);
        this.getColumns().add(tcDatum);
        this.getColumns().add(tcSkor);
    }
}
