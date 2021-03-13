import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label helloText;

    @FXML
    private AnchorPane parentPane;

    private double x = 0, y = 0;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        makeDraggable();

    }

    @FXML
    void sayHello(ActionEvent event) {
        helloText.setText("Hello World!");
    }

    @FXML
    private void makeDraggable() {
        parentPane.setOnMousePressed( ((event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
            System.out.println("getSceneXY is: " + x + ", " + y);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double stageX = stage.getX();
            double stageY = stage.getY();
            System.out.println("stage XY is: " + stageX + ", " + stageY);
        }) );

        parentPane.setOnMouseDragged( ((event) -> {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double stageX = stage.getX();
            double stageY = stage.getY();
            System.out.println("stage XY is: " + stageX + ", " + stageY);
            stage.setX(event.getX());
            stage.setY(event.getY());
        }) );


    }

}
