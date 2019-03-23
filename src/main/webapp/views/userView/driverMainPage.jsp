<%--
  Created by IntelliJ IDEA.
  User: nataliakiselyk
  Date: 12/19/18
  Time: 2:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/views/commonView/header.jsp"%>

<div class="container">

    <h2><fmt:message key="driver.main.text" bundle="${rb}"/></h2>


    <form action="${pageContext.request.contextPath}/RouteDriverServlet" method="get">
        <button type="submit" class="btn btn-info"><fmt:message key="driver.my.routes" bundle="${rb}"/></button>
    </form>
    <a href="/views/userView/editDriver.jsp" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true"><fmt:message key="driver.edit.info" bundle="${rb}"/></a>

    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
        <button type="submit" class="btn btn-success btn-md"><fmt:message key="logout.button" bundle="${rb}"/></button>
    </form>
</div>
<%@include file="/views/commonView/footer.jsp"%>


