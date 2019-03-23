<%--
  Created by IntelliJ IDEA.
  User: nataliakiselyk
  Date: 12/21/18
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/views/commonView/header.jsp"%>

<div class="container-fluid">
    <div class="alert alert-danger" role="alert">
        <fmt:message key="error.message" bundle="${rb}"/>
    </div>
    <br><br>
    <a href="/views/userView/errorPageDriver.jsp" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true"><fmt:message key="back.to.main.page" bundle="${rb}"/></a>
</div>
<br>
    <br>
    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
        <button type="submit" class="btn btn-success btn-md"><fmt:message key="logout.button" bundle="${rb}"/></button>
    </form>
</div>

<%@include file="/views/commonView/footer.jsp"%>
