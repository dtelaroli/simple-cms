<%@ taglib tagdir="/WEB-INF/tags" prefix="cms"%>
<%@ attribute name="action" required="true" %>
<%@ attribute name="method" required="true"%>
<%@ attribute name="title" required="true"%>

<cms:view title="${title}">
	<form role="form" action="${action}" method="${method ne 'get' ? 'post' : method}">
		<input type="hidden" name="_method" value="${method}"/>
		<jsp:doBody />
		<jsp:include page="./_form.jsp"/>
	</form>
</cms:view>
