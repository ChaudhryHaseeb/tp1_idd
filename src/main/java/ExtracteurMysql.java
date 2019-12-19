import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ExtracteurMysql
{
    static Connection cnx = null;
    static PreparedStatement prestmt = null;

    public static void makeJDBCConnection()
    {
        try
        {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/idd", "root", "azertyui");
            if (cnx != null)
            {
                System.out.println("Connection Successful! Enjoy. Now it's time to push data");
            }
            else
            {
                System.out.println("Failed to make connection!");
            }
        }
        catch (SQLException e)
        {
            System.out.println("MySQL Connection Failed!");
            e.printStackTrace();
        }
    }



}