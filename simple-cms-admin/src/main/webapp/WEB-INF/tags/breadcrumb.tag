<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cms"%>
<%@ attribute name="controller" required="true"%>

<ol class="breadcrumb">
	<li>
		<a href='<c:url value="/"/>'>${t['dashboard']}</a>
	</li>
	<li${info.action eq 'index' ? ' class="active"': ''}>
		<a
			href="${info.action == 'index' ? 'javascript:void(0)' : linkTo[info.controller].index}">${t[info.controller.type.simpleName]}</a>
	</li>
	<li class="active">${t[info.action]}</li>
</ol>
