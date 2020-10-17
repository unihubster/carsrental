<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<c:import url="/WEB-INF/jsp/fragment/head.jsp">
    <c:param name="title" value="access.error.page.title"/>
</c:import>
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h3><fmt:message key="access.error.message"/>&nbsp;<a href="login.jsp"><fmt:message key="nav.login"/></a></h3>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</main>
<c:import url="/WEB-INF/jsp/fragment/foot.jsp"/>
