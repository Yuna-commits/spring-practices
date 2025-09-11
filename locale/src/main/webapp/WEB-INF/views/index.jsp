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
<script>
	window.addEventListener("load", function() {
		var anchors = document.querySelectorAll('#languages a');
		anchors.forEach(function(element) {
			// click event
			element.addEventListener("click", function(event) {
				// 기본 핸들러의 기능(link to href) 막기
				event.preventDefault();
				// data-lang을 쿠키에 저장
				document.cookie = 
					"lang=" + this.getAttribute("data-lang") + ";" +
					"path=" + "${pageContext.request.contextPath}" + ";" +
					"max-age=" + (30*24*60*60);
					
				location.reload();
			});
		});
	});
</script>
</head>
<body>
	<h1>
		<spring:message code="index.title"/>
	</h1>
	<div id="languages">
		<c:choose>
			<c:when test='${lang == "ko" }'>
				<a href="" data-lang="ko" class="active">KO</a> <a href="" data-lang="en">EN</a> <a href="" data-lang="ja">JP</a>
			</c:when>
			<c:when test='${lang == "en" }'>
				<a href="" data-lang="ko">KO</a> <a href="" data-lang="en"  class="active">EN</a> <a href="" data-lang="ja">JP</a>
			</c:when>
			<c:otherwise>
				<a href="" data-lang="ko">KO</a> <a href="" data-lang="en">EN</a> <a href="" data-lang="ja"  class="active">JP</a>
			</c:otherwise>			
		</c:choose>
	</div>
</body>
</html>