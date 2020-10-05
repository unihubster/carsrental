<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<c:import url="/WEB-INF/jsp/fragment/head.jsp">
    <c:param name="title" value="login.page.title"/>
</c:import>
<main>
    <div class="container mt-2 mb-4">
        <div class="row justify-content-center">
            <div class="card col-md-6 shadow rounded pt-2">
                <div class="card-body">
                    <div class="col-sm-12">
                        <form action="${pageContext.request.contextPath}/command" method="post" id="singninForm" onSubmit="return validation();"
                              class="needs-validation" novalidate>
                            <input type="hidden" name="command" value="login">
                            <div class="form-group">
                                <label class="font-weight-bold"><fmt:message key="registration.label.username"/></label>
                                <input type="text" name="username" id="username" class="form-control" pattern="[A-Za-z]{1,100}" required
                                       placeholder="<fmt:message key="login.plaseholder.username"/>">
                            </div>
                            <div class="form-group">
                                <label class="font-weight-bold"><fmt:message key="registration.label.password"/></label>
                                <input type="password" name="password" id="password" class="form-control" pattern="[A-Za-z0-9]{3,}" required
                                       placeholder="********">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" value="<fmt:message key="login.label.signin"/>" class="btn btn-block btn-danger">
                            </div>
                            <!--/.next-form-->
                        </form>
                        <div class="text-info"><fmt:message key="login.registration.message"/>&nbsp;<a href="registration.jsp"><fmt:message
                                key="login.registration.label"/></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<c:import url="/WEB-INF/jsp/fragment/foot.jsp"/>