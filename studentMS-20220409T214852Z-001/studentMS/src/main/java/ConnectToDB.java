import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB
{
    public static final String username = "root";
    public static final String pass = "sifatsql@12-";
    public static final String bd = "StudentMS";
    public static final String url = "jdbc:mysql://localhost:3306/"+bd;
    static Connection connect() throws SQLException
    {
        Connection con = DriverManager.getConnection(url,username,pass);
        return con;
    }

}
