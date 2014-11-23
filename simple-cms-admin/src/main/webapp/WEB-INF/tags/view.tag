<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cms"%>

<%@ attribute name="title" required="true"%>

<html>
<head>
<title>${title}</title>
</head>
<body>
	<cms:breadcrumb controller="${info.controller}" />
	<jsp:include page="/WEB-INF/elements/alerts.jsp"></jsp:include>

	<jsp:doBody />

	<cms:js />
	<jsp:include page="./_js.jsp" />
</body>
</html>