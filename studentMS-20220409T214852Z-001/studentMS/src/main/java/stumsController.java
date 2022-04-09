import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class stumsController implements Initializable
{
    @FXML
    private VBox maincontent;

    @FXML
    void addstu(ActionEvent event) throws IOException
    {
        Parent pa = FXMLLoader.load(getClass().getResource("stums1.fxml"));
        maincontent.getChildren().setAll(pa);
    }
    @FXML
    void showstu(ActionEvent event) throws IOException
    {
        Parent pa = FXMLLoader.load(getClass().getResource("allstu.fxml"));
        maincontent.getChildren().setAll(pa);
    }
    @FXML
    void showaddv(ActionEvent event) throws IOException
    {
        Parent pa = FXMLLoader.load(getClass().getResource("alladviser.fxml"));
        maincontent.getChildren().setAll(pa);
    }
    @FXML
    void search(ActionEvent event) throws IOException
    {
        Parent pa = FXMLLoader.load(getClass().getResource("search.fxml"));
        maincontent.getChildren().setAll(pa);
    }
    @FXML
    void addadv(ActionEvent event) throws IOException
    {
        Parent pa = FXMLLoader.load(getClass().getResource("addadviser.fxml"));
        maincontent.getChildren().setAll(pa);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            Parent pa = FXMLLoader.load(getClass().getResource("stums1.fxml"));
            maincontent.getChildren().add(pa);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
