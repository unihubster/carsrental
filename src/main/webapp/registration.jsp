<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<c:import url="/WEB-INF/jsp/fragment/head.jsp">
    <c:param name="title" value="registration.page.title"/>
</c:import>
<main>
    <div class="container mt-2 mb-4">
        <div class="row justify-content-center">
            <div class="card col-md-6 shadow rounded pt-2">
                <div class="card-header text-center"><fmt:message key="registration.label"/></div>
                <div class="card-body">
                    <div class="col-sm-12">
                        <form method="post" action="${pageContext.request.contextPath}/command" id="singnupForm" onSubmit="return validation();"
                              class="needs-validation" novalidate>
                            <input type="hidden" name="action" value="register">
                            <c:if test="${not empty sessionScope.registrationError}">
                                <small class="text-danger"><em><fmt:message key="registration.message.error.validation"/></em></small>
                            </c:if>
                            <c:if test="${not empty sessionScope.userExist}">
                                <small class="text-danger"><em><fmt:message key="registration.message.error.userExist"/></em></small>
                            </c:if>
                            <div class="form-group">
                                <label class="font-weight-bold">Email</label>
                                <div class="input-group">
                                    <input type="email" name="email" id="email" class="form-control"
                                           pattern="([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})" required
                                           placeholder="<fmt:message key="registration.plaseholder.email"/>">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onClick="return emailCheck();">
                                            <em class="fa fa-envelope"></em>
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div id="next-form" class="collapse">
                                <div class="form-group">
                                    <label class="font-weight-bold"><fmt:message key="registration.label.username"/>&nbsp;
                                        <small class="text-danger"><em><fmt:message key="registration.message.username"/></em></small>
                                    </label>
                                    <input type="text" name="username" id="username" class="form-control" pattern="[A-Za-z]{1,100}" required
                                           placeholder="<fmt:message key="registration.plaseholder.username"/>">
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold"><fmt:message key="registration.label.phone"/></label>
                                    <input type="tel" name="phone" id="phone" class="tel form-control" pattern="\([0-9-]{3}\) [0-9-]{3}-[0-9-]{4}" required
                                           placeholder="(000) 000-0000">
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold"><fmt:message key="registration.label.firstname"/>&nbsp;
                                        <small class="text-danger"><em><fmt:message key="registration.message.firstname"/></em></small>
                                    </label>
                                    <input type="text" name="first_name" id="first_name" class="form-control" required
                                           placeholder="<fmt:message key="registration.plaseholder.firstname"/>">
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold"><fmt:message key="registration.label.lastname"/>&nbsp;
                                        <small class="text-danger"><em><fmt:message key="registration.message.lastname"/></em></small>
                                    </label>
                                    <input type="text" name="last_name" id="last_name" class="form-control" required
                                           placeholder="<fmt:message key="registration.plaseholder.lastname"/>">
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold"><fmt:message key="registration.label.password"/></label>
                                    <input type="password" name="password" id="password" class="form-control" pattern="[A-Za-z0-9]{3,32}" required
                                           placeholder="********">
                                </div>
                                <div class="form-group">
                                    <label class="font-weight-bold"><fmt:message key="registration.label.cpassword"/></label>
                                    <input type="password" name="cpassword" id="cpassword" class="form-control" pattern="[A-Za-z0-9]{3,32}" required
                                           placeholder="********">
                                    <em id="cp" class="text-danger" style="visibility: hidden;"><fmt:message key="registration.message.cpassword"/></em>
                                </div>
                                <div class="form-group">
                                    <input type="submit" name="submit" value="<fmt:message key="registration.label.signup"/>" class="btn btn-block btn-danger">
                                </div>
                            </div>
                            <!--/.next-form-->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<c:import url="/WEB-INF/jsp/fragment/foot.jsp"/>