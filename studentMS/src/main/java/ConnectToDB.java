import java.sql.*;
import java.util.Locale;

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
    public static void createDB() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
        Connection connection = DriverManager.getConnection(url,username,pass);
        String sql = "CREATE DATABASE " + bd;

        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

    }
    public static boolean doesTablesExist(String tableName) throws SQLException
    {
        DatabaseMetaData databaseMetaData = ConnectToDB.connect().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null,null,tableName.toUpperCase(Locale.ROOT),null);
        if(rs.next()) return true;
        else return false;
    }

}
