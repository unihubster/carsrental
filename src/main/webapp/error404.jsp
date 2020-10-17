<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<c:import url="/WEB-INF/jsp/fragment/head.jsp">
    <c:param name="title" value="error.page.title"/>
</c:import>
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2><fmt:message key="error.message.404"/></h2>
                <p><fmt:message key="error.message.request_uri"/>&nbsp;${requestScope['javax.servlet.forward.request_uri']}</p>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</main>
<c:import url="/WEB-INF/jsp/fragment/foot.jsp"/>