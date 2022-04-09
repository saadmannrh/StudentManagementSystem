import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class stums1Controller implements Initializable
{
    Connection con = ConnectToDB.connect();
    String coma = ",";
    String q="'";

    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    TextField deptField;
    @FXML
    TextField addressField;

    static ObservableList<student> stuList = FXCollections.observableArrayList();

    public stums1Controller() throws SQLException {
    }

    @FXML
    private void addBtn(ActionEvent event) throws SQLException
    {
        String name = nameField.getText();
        int id = Integer.parseInt(idField.getText());
        String dept = deptField.getText();
        String address = addressField.getText();
        if (name.equals("") || id==0 || dept.equals("") || address.equals(""))
        {
            return;
        }

        Statement st = con.createStatement();
        String query = "INSERT INTO students(sid,dept,address,sname,aid) VALUES ("+Integer.parseInt(idField.getText())+coma+
                q+deptField.getText()+q+coma+
                q+addressField.getText()+q+coma+
                q+nameField.getText()+q+coma+"201)";
        st.execute(query);

        nameField.clear();
        idField.clear();
        deptField.clear();
        addressField.clear();

        System.out.println(stuList);
    }
    @FXML
    private void deleteBtn(ActionEvent event) throws SQLException
    {
        int id = Integer.parseInt(idField.getText());
        if (id==0)
        {
            return;
        }
        Statement st = con.createStatement();
        String query = "DELETE FROM students WHERE sid="+id;
        st.execute(query);
        nameField.clear();
        idField.clear();
        deptField.clear();
        addressField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
