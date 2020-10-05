<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<header>
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}"><fmt:message key="application.title"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}"><fmt:message key="nav.home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}"><fmt:message key="nav.cars.list"/></a>
                </li>
            </ul>
            <c:if test="${not empty sessionScope.username}">
                <div class="navbar-text mr-3">${sessionScope.username}</div>
            </c:if>
            <%--
                        <form class="form-inline mt-2 mt-md-0 p-2">
                            <input class="form-control mr-sm-2" type="text" placeholder="<fmt:message key="nav.search"/>" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><fmt:message key="nav.search"/></button>
                        </form>
            --%>
            <%--
                        <ul class="navbar-nav justify-content-end">
            --%>
            <%--
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}" id="dropdown01"
                                   data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false"><fmt:message key="nav.lang"/></a>
                                <div class="dropdown-menu" aria-labelledby="dropdown01">
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}"><fmt:message key="nav.lang.en"/></a>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}"><fmt:message key="nav.lang.uk"/></a>
                                </div>
                            </li>
            --%>
            <%--
                            <li class="nav-item">
            --%>
            <form class="form-inline" method="post">
                <select class="custom-select mr-sm-2" id="language" name="lang" onchange="submit()">
                    <option value="en" ${sessionScope.lang == 'en' ? 'selected' : ''}><fmt:message key="nav.lang.en"/></option>
                    <option value="uk" ${sessionScope.lang == 'uk' ? 'selected' : ''}><fmt:message key="nav.lang.uk"/></option>
                </select>
                <label class="mr-sm-2 sr-only" for="language"><fmt:message key="nav.lang"/></label>
            </form>
            <%--
                            </li>
                        </ul>
            --%>
            <div>&nbsp;</div>
            <c:if test="${empty sessionScope.username}">
                <a class="btn btn-primary px-4" href="${pageContext.request.contextPath}/login.jsp"><fmt:message key="nav.login"/></a>
            </c:if>
            <c:if test="1==3">
                <p>1</p>
            </c:if>
            <c:if test="${not empty sessionScope.username}">
                <form class="form-inline" method="post" action="${pageContext.request.contextPath}/command">
                    <input type="hidden" name="action" value="logout">
                    <input type="submit" name="submit" class="btn btn-primary px-4" value="<fmt:message key="nav.logout"/>">
                </form>
            </c:if>
        </div>
    </nav>
</header>