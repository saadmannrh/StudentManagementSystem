import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addadviserController implements Initializable
{
    Connection con = ConnectToDB.connect();
    String coma = ",";
    String q="'";
    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    TextField courseField;

    static ObservableList<adviser> advList = FXCollections.observableArrayList();

    public addadviserController() throws SQLException {
    }

    @FXML
    private void addBtn(ActionEvent event) throws SQLException
    {
        String name = nameField.getText();
        int id = Integer.parseInt(idField.getText());
        String course = courseField.getText();
        if (name.equals("") || id==0 || course.equals(""))
        {
            return;
        }
        Statement st = con.createStatement();
        String query = "INSERT INTO advisor(adid,aname,course) VALUES " +
                "("+id+coma+q+name+q+coma+q+course+q+")";
        st.execute(query);

        nameField.clear();
        idField.clear();
        courseField.clear();

        System.out.println(advList);
    }
    @FXML
    private void deleteBtn(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(idField.getText());
        if (id==0)
        {
            return;
        }
        Statement st = con.createStatement();
        String query = "DELETE FROM advisor WHERE adid="+id;
        st.execute(query);
        nameField.clear();
        idField.clear();
        courseField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
