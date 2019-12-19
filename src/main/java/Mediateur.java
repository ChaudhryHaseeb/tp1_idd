import java.sql.ResultSet;
import java.util.ArrayList;

public class Mediateur
{
    ExtracteurMysql mysqlExtract = new ExtracteurMysql();
    ExtracteurExcel excelExtract = new ExtracteurExcel();
    ArrayList list = new ArrayList();

    public void req1()
    {
        System.out.println("------Requete 1-------");
        list = mysqlExtract.req1RockMysql();
        list.addAll(excelExtract.req1RockExcel());
        for(int i=0; i<list.size();i++)
        {
            if(i%2==0)
            {
                System.out.print("Rock : "+ list.get(i)+",");
            }
            else
            {
                System.out.println(list.get(i));
            }
        }

        list = mysqlExtract.req1NonRockMysql();
        list.addAll(excelExtract.req1NonRockExcel());
        for(int i=0; i<list.size();i++)
        {
            if(i%2==0)
            {
                System.out.print("Non Rock : "+ list.get(i)+",");
            }
            else
            {
                System.out.println(list.get(i));
            }
        }

    }


    public void req2()
    {
        System.out.println("------Requete 2-------");
        list = mysqlExtract.req2Mysql();
        //list.addAll(excelExtract.req2Excel());
        for(int i=0; i<list.size();i++)
        {
            if(i%2==0)
            {
                System.out.print(list.get(i)+",");
            }
            else
            {
                System.out.println(list.get(i));
            }
        }
    }

    public void req3()
    {
        System.out.println("------Requete 3-------");
        list = mysqlExtract.req3Mysql();
        //list.addAll(excelExtract.req3Excel());
        for(int i=0; i<list.size();i++)
        {
            if(i%2==0)
            {
                System.out.print(list.get(i)+",");
            }
            else
            {
                System.out.println(list.get(i));
            }
        }
    }

}
