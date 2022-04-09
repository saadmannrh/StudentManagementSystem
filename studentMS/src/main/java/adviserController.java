import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class adviserController implements Initializable
{
    @FXML
    private TableView<adviser> advTable;
    @FXML
    private TableColumn<adviser ,String> nameColl;
    @FXML
    private TableColumn<adviser ,String> idColl;
    @FXML
    private TableColumn<adviser ,String> courseColl;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        advTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        addadviserController.advList.clear();
        try
        {
            show();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        nameColl.setCellValueFactory(new PropertyValueFactory<adviser,String>("name"));
        idColl.setCellValueFactory(new PropertyValueFactory<adviser,String>("id"));
        courseColl.setCellValueFactory(new PropertyValueFactory<adviser,String>("course"));
        advTable.setItems(addadviserController.advList);
    }
    void show() throws SQLException
    {
        String name;
        int id;
        String course;
        Connection cn = ConnectToDB.connect();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM advisor");
        while (rs.next())
        {
            id = rs.getInt(1);
            name = rs.getString(2);
            course = rs.getString(3);
            adviser adv = new adviser(name,id,course);
            addadviserController.advList.add(adv);
        }
    }

}
