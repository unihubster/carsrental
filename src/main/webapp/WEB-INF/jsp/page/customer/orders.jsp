<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<c:import url="/WEB-INF/jsp/fragment/head.jsp">
    <c:param name="title" value="orders.page.title"/>
</c:import>
<main>

</main>
<c:import url="/WEB-INF/jsp/fragment/foot.jsp"/>