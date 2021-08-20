package net.codejava;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/product")
public class BookNowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        String productname = request.getParameter("productname");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String unit = request.getParameter("unit");
        MysqlCon.updateInDB(productname, price, quantity, unit);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        ResultSet rs = MysqlCon.getDataFromDB();
        try
        {
            while (rs.next()) {
                // Read values using column name
                String product = rs.getString("productname");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String unit = rs.getString("unit");
                response.getWriter().println(product + " , " + price + " , " + quantity + " , " + unit);
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println(e.getStackTrace().toString());
        }
    }

}
