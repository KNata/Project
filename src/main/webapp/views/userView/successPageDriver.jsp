<%--
  Created by IntelliJ IDEA.
  User: nataliakiselyk
  Date: 12/22/18
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/views/commonView/header.jsp"%>
<br>
<br>
<div class="container-fluid">
    <div class="alert alert-success" role="alert">
        An item was added successfully.
    </div>
    <br>
    <br>

    <c:if test="">
        <a href="/views/adminView/adminMainPage.jsp"><button type="submit" class="btn btn-secondary btn-md"><fmt:message key="back.to.main.page" bundle="${rb}"/></button></a>
    </c:if>
    <c:if test="${driver}">
        <a href="/views/userView/driverMainPage.jsp"><button type="submit" class="btn btn-secondary btn-md"><fmt:message key="back.to.main.page" bundle="${rb}"/></button></a>
    </c:if>
    <br><br>
    <a href="/views/userView/successPageDriver.jsp" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true"><fmt:message key="back.to.main.page" bundle="${rb}"/></a>
</div>
    <br>
    <br>
    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
        <button type="submit" class="btn btn-success btn-md">Logout</button>
    </form>


</div>

<%@include file="/views/commonView/footer.jsp"%>

