import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class ExtracteurMysql
{
    static Connection cnx = null;
    static PreparedStatement prestmt = null;
    ResultSet rs;

    public ExtracteurMysql()
    {
        this.makeJDBCConnection();
    }

    private void makeJDBCConnection()
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

    public ArrayList req1RockMysql()
    {
        ArrayList listRock = new ArrayList();
        try
        {
            String getQueryStatement = "SELECT année, COUNT(`id-album`) as nb FROM albumliste a, genre g WHERE a.`id-genre`=g.`id-genre` AND g.libelle='Rock' GROUP BY année ORDER BY année";
            prestmt = cnx.prepareStatement(getQueryStatement);
            rs = prestmt.executeQuery();
            while (rs.next())
            {
                int annee = rs.getInt("année");
                int nb = rs.getInt("nb");
                listRock.add(annee);
                listRock.add(nb);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return listRock;
    }

    public ArrayList req1NonRockMysql()
    {
        ArrayList listRock = new ArrayList();
        try
        {
            String getQueryStatement = "SELECT année, COUNT(`id-album`) as nb FROM albumliste a, genre g WHERE a.`id-genre`=g.`id-genre` AND g.libelle<>'Rock' GROUP BY année ORDER BY année";
            prestmt = cnx.prepareStatement(getQueryStatement);
            rs = prestmt.executeQuery();
            while (rs.next())
            {
                int annee = rs.getInt("année");
                int nb = rs.getInt("nb");
                listRock.add(annee);
                listRock.add(nb);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return listRock;
    }

    public ArrayList req2Mysql()
    {
        ArrayList listRock = new ArrayList();
        try
        {
            String getQueryStatement = "SELECT année, libelle FROM albumliste a, genre g WHERE a.`id-genre`=g.`id-genre` ORDER BY année, libelle";
            prestmt = cnx.prepareStatement(getQueryStatement);
            rs = prestmt.executeQuery();
            while (rs.next())
            {
                int annee = rs.getInt("année");
                String libelle  = rs.getString("libelle");
                listRock.add(annee);
                listRock.add(libelle);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return listRock;
    }

    public ArrayList req3Mysql()
    {
        ArrayList listRock = new ArrayList();
        try
        {
            String getQueryStatement = "SELECT année, COUNT(DISTINCT(`id-genre`)) as nb FROM albumliste a GROUP BY année ORDER BY nb desc";
            prestmt = cnx.prepareStatement(getQueryStatement);
            rs = prestmt.executeQuery();
            while (rs.next())
            {
                int annee = rs.getInt("année");
                int nb = rs.getInt("nb");
                listRock.add(annee);
                listRock.add(nb);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return listRock;
    }

}