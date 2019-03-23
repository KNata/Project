<%@include file="header.jsp"%>

<div class="container-fluid">
    <div class="card" style="width: 18rem; width: auto; height: auto; margin-bottom: 20px; margin-top: 30px; ">
        <div class="card-body">
            <h5 class="card-title"><fmt:message key="admin.add.user.welcome.title" bundle="${rb}"/></h5>
            <p class="card-text"><fmt:message key="about.project.info" bundle="${rb}"/></p>
            <p class="card-text"><fmt:message key="made.by" bundle="${rb}"/></p>
            <a href="/index.jsp" class="btn btn-primary"><fmt:message key="index.page.login" bundle="${rb}"/></a>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
