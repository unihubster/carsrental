<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="label"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/all.min.css">
    <title><fmt:message key="application.title"/> | <fmt:message key="${param.title}"/></title>
</head>
<body>
<c:import url="/WEB-INF/jsp/fragment/header.jsp"/>