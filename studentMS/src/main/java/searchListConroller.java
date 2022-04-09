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

public class searchListConroller implements Initializable
{
    @FXML
    private TableView<adviser> searchTeacher;
    @FXML
    private TableColumn<adviser, String> stname;
    @FXML
    private TableColumn<adviser, String> stId;
    @FXML
    private TableColumn<adviser, String> stCourse;

    public searchListConroller() throws SQLException {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        searchTeacher.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        addadviserController.advList.clear();

        stname.setCellValueFactory(new PropertyValueFactory<adviser,String>("name"));
        stId.setCellValueFactory(new PropertyValueFactory<adviser,String>("id"));
        stCourse.setCellValueFactory(new PropertyValueFactory<adviser,String>("course"));
        searchTeacher.setItems(addadviserController.advList);
    }
    void show(String name,ResultSet rs) throws SQLException
    {
        int id;
        String course;
        String nname;
        while (rs.next())
        {
            id = rs.getInt(1);
            nname = rs.getString(2);
            course = rs.getString(3);
            adviser adv = new adviser(nname,id,course);
            addadviserController.advList.add(adv);
        }

    }
}
