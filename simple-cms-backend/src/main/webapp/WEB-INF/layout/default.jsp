<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><sitemesh:write property='title'/> - Simple CMS Administrator</title>
	<sitemesh:write property='head'/>
	<jsp:include page="/WEB-INF/elements/css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/elements/nav.jsp"></jsp:include>

	<section class="container">
		<sitemesh:write property='body'/>
	</section>

	<footer class="container">
		<jsp:include page="/WEB-INF/elements/footer.jsp"></jsp:include>
	</footer>
	
	<cms:loader/>
</body>
</html>