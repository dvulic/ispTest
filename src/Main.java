import javafx.application.Application;
import model.utility.FileUtils;

public class Main {
    public static void main(String[] args) {
        FileUtils.UcitajPitanja("src/pitanja.txt");
        System.out.println("Questions loaded");
        Application.launch(App.class, args);


    }
}
