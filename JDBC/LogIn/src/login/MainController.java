package login;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Label labelid;

    @FXML
    private TextField usrid;

    @FXML
    private TextField passid;

    public void Authenticate(ActionEvent event) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", usrid.getText(), passid.getText());
            labelid.setText("Success");
        } catch (Exception e) {
            labelid.setText("Fail");

        }
    }
}
