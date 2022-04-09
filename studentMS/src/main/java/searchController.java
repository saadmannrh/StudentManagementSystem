import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class searchController implements Initializable
{
    Connection con = ConnectToDB.connect();
    String coma = ",";
    String q="'";

    @FXML
    TextField tcsField;
    @FXML
    TextField tnsField;
    @FXML
    TextField tisField;
    @FXML
    TextField sisField;
    @FXML
    TextField sasField;
    @FXML
    TextField scsField;

    public searchController() throws SQLException
    {

    }

    @FXML
    private void tcs(ActionEvent event) throws SQLException, IOException
    {
        String course = tisField.getText();
        Statement st = con.createStatement();
        st.execute("SELECT * FROM advisor WHERE course = "+q+course+q+"");
        Parent pa = FXMLLoader.load(getClass().getResource("searchList.fxml"));
        Scene sc = new Scene(pa);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.show();
    }
    @FXML
    private void tns(ActionEvent event) throws SQLException, IOException {
        String name = tisField.getText();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM advisor WHERE aname = "+q+name+q+"");
        searchListConroller s = new searchListConroller();
        s.show(name,rs);
        Parent pa = FXMLLoader.load(getClass().getResource("searchList.fxml"));
        Scene sc = new Scene(pa);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.show();
    }
    @FXML
    private void tis(ActionEvent event) throws SQLException, IOException
    {
        int id = Integer.parseInt(tisField.getText());
        Statement st = con.createStatement();
        st.execute("SELECT * FROM advisor WHERE adid="+id);
        Parent pa = FXMLLoader.load(getClass().getResource("searchList.fxml"));
        Scene sc = new Scene(pa);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.show();
    }
    @FXML
    private void sis(ActionEvent event) throws SQLException, IOException {
        int id = Integer.parseInt(sisField.getText());
        Statement st = con.createStatement();
        st.execute("SELECT * FROM students WHERE sid="+id);
        Parent pa = FXMLLoader.load(getClass().getResource("searchList.fxml"));
        Scene sc = new Scene(pa);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.show();
    }
    @FXML
    private void sas(ActionEvent event) throws SQLException, IOException {

    }
    @FXML
    private void scs(ActionEvent event) throws SQLException
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
