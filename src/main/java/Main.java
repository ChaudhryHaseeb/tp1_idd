public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Test");
        ExtracteurMysql.makeJDBCConnection();
        //ExtracteurMysql.req1Rock();
        //ExtracteurMysql.req1NonRock();
        ExtracteurMysql ex = new ExtracteurMysql();
        for(Object i : ex.req1RockMysql())
        {
            System.out.println(i);
        }
    }
}
