package net.codejava;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/weather")
public class RestAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        String temperature = request.getParameter("temperature");
        String location = request.getParameter("location");
        String weatherdate = request.getParameter("weatherdate");
        MysqlCon.updateInDB(temperature, location, weatherdate);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {
        ResultSet rs = MysqlCon.getDataFromDB();
        try
        {
            while (rs.next()) {
                // Read values using column name
                String temperature = rs.getString("temperature");
                String location = rs.getString("location");
                String weatherdate = rs.getString("weatherdate");
                response.getWriter().println(temperature + " , " + location + " , " + weatherdate );
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println(e.getStackTrace().toString());
        }
    }

}
