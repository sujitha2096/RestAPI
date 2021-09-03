<%--
  Created by IntelliJ IDEA.
  User: thilaga-6517
  Date: 19/06/21
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>weather</title>
  </head>
  <body>
  <div>
    <h1>weather</h1>
    <form action="weather" method="post">
      <p>
        temperature <input type="String" name="temperature" required />
      </p>
      <p>
        location <input type="String" name="location" required />
      </p>
      <p>
        weatherdate <input type="String" name="weatherdate" required />
      </p>
      <p>
        <input type="submit" value="RUN" />
      </p>
    </form>
    <form action="weather" method="get">
      <p>
        <input type="submit" value="show" />
      </p>
    </form>
  </div>
  </body>
</html>
