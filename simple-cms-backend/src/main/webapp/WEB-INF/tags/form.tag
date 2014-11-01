<%@ attribute name="action" required="true" %>
<%@ attribute name="method" required="true"%>

<div class="row">
	<form role="form" action="${action}" method="${method ne 'get' ? 'post' : method}">
		<input type="hidden" name="_method" value="${method}"/>
		<jsp:doBody/>
		<jsp:include page="./_form.jsp"></jsp:include>
	</form>
</div>
