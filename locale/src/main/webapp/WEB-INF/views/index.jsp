<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
	<h1>
		<spring:message code="index.title"/>
	</h1>
	<div id="languages">
		<a href="" class="active">KO</a><a href="">EN</a>
	</div>
</body>
</html>