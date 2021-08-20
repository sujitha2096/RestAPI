package net.codejava;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlCon{

    public static void updateInDB(String productnamestr, String pricestr, String quantitystr, String unitstr)
    {
        try{

            Connection con = getJDBC();
            Statement stmt =  con.createStatement();
            String sql = "INSERT INTO product (productname, price, quantity, unit, id) VALUES ('"+ productnamestr +"',"+ pricestr +"," + quantitystr + ",'" + unitstr + "',1)";
            System.out.println(sql);
            int rs = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println(e.getStackTrace().toString());
        }
    }



    public static ResultSet getDataFromDB()
    {
        ResultSet set = null;
        try
        {
            Connection con = getJDBC();
            Statement stmt =  con.createStatement();
            String sql = "select * from product";
            set = stmt.executeQuery(sql);
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println(e.getStackTrace().toString());
        }
        return set;
    }

    public static Connection getJDBC() throws Exception
    {
        FileInputStream fis=new FileInputStream("/home/local/ZOHOCORP/thilaga-6517/IdeaProjects/calci/src/main/resources/connection.prop");
        Properties p=new Properties ();
        p.load (fis);
        String dname= (String) p.get ("Dname");
        String url= (String) p.get ("URL");
        String username= (String) p.get ("Uname");
        String password= (String) p.get ("password");
        Connection con = null;
        try
        {
            Class.forName(dname);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("connected");

        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println(e.getStackTrace().toString());
        }
        return con;
    }
}
