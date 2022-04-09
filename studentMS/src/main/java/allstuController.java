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

public class allstuController implements Initializable
{
    @FXML
    private TableView<student> stuTable;
    @FXML
    private TableColumn<student ,String> nameColl;
    @FXML
    private TableColumn<student ,Integer> idColl;
    @FXML
    private TableColumn<student ,String> deptColl;
    @FXML
    private TableColumn<student ,String> addressColl;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        stuTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        stums1Controller.stuList.clear();
        try
        {
            show();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        nameColl.setCellValueFactory(new PropertyValueFactory<student,String>("name"));
        idColl.setCellValueFactory(new PropertyValueFactory<student,Integer>("id"));
        deptColl.setCellValueFactory(new PropertyValueFactory<student,String>("dept"));
        addressColl.setCellValueFactory(new PropertyValueFactory<student,String>("address"));
        stuTable.setItems(stums1Controller.stuList);

    }
    void show() throws SQLException
    {
        String name;
        int id;
        String dept;
        String address;
        Connection cn = ConnectToDB.connect();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");
        while (rs.next())
        {
            id = rs.getInt(1);
            dept = rs.getString(2);
            address = rs.getString(3);
            name = rs.getString(4);
            student stu = new student(name,id,dept,address);
            stums1Controller.stuList.add(stu);
        }
    }
}
