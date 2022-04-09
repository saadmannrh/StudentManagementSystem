import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class stumsMain extends Application
{
    public static void main(String[] args) throws SQLException
    {
        Connection con = ConnectToDB.connect();
        if(con==null)
        {
            ConnectToDB.connect();
            con = ConnectToDB.connect();
        }
        if (!ConnectToDB.doesTablesExist("students"))
        {
            //Connection con = ConnectToDB.connect();
            Statement st = con.createStatement();
            String sdbt = "CREATE TABLE students(sid INT NOT NULL,dept VARCHAR(255)," +
            "address VARCHAR(255)," + "sname VARCHAR(255),aid INT NOT NULL,PRIMARY KEY(sid))";
            String adbt = "CREATE TABLE advisor(adid INT NOT NULL,aname VARCHAR(255),course VARCHAR(255),PRIMARY KEY(adid))";
            st.execute(sdbt);
            st.execute(adbt);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Connection con = ConnectToDB.connect();
        //Statement st = con.createStatement();

        //String sdbt = "CREATE TABLE students(sid INT NOT NULL,dept VARCHAR(255)," +
                //"address VARCHAR(255)," + "sname VARCHAR(255),aid INT NOT NULL,PRIMARY KEY(sid))";
        //String adbt = "CREATE TABLE advisor(adid INT NOT NULL,aname VARCHAR(255),course VARCHAR(255),PRIMARY KEY(adid))";

        //st.execute(sdbt);
        //st.execute(adbt);


        Parent p = FXMLLoader.load(getClass().getResource("stums.fxml"));
        Scene sc = new Scene(p);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
