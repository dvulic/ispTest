import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView.MAIN_VIEW.show();
    }
}
