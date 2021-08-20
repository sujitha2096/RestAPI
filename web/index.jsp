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
    <title>BookNow</title>
  </head>
  <body>
  <div>
    <h1>BookNow</h1>
    <form action="product" method="post">
      <p>
        productname <input type="String" name="productname" required />
      </p>
      <p>
        price <input type="number" name="price" required />
      </p>
      <p>
        quantity <input type="number" name="quantity" required />
      </p>
      <p>
        unit <input type="String" name="unit" required />
      </p>
      <p>
        <input type="submit" value="RUN" />
      </p>
    </form>
    <form action="product" method="get">
      <p>
        <input type="submit" value="show" />
      </p>
    </form>
  </div>
  </body>
</html>
