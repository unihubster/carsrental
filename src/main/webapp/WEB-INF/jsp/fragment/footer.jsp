<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>
<footer class="pt-3 my-md-3 pt-md-3 border-top">
    <div class="container">
        <p class="text-center">
            © <fmt:message key="application.title"/>, 2020
        </p>
    </div>
</footer>