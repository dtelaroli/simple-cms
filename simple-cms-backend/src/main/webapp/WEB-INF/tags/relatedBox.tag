<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cms"%>

<%@ attribute name="listSaved" required="true" type="java.lang.Object"%>
<%@ attribute name="listAll" required="true" type="java.lang.Object"%>
<%@ attribute name="inputName" required="true"%>
<%@ attribute name="controller" required="true" type="java.lang.Object"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="title" required="true"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${title}</h3>
	</div>
	<div class="panel-body">
		<c:forEach var="item" items="${listAll}">
			<div class="checkbox">
				<label> 
					<input type="checkbox" name="${inputName}"
					value="${item.id}" ${listSaved.contains(item) ? 'checked': ''}>
					${item.name}
				</label>
			</div>
		</c:forEach>
		<div id="${name}Container"></div>
		<div class="input-group input-group-sm">
			<input type="text" id="${name}Input" class="form-control"
				placeholder="Add new item"> <span class="input-group-btn">
				<button class="btn btn-default" type="button" onclick="add('${name}', '${linkTo[controller].save}')">Add</button>
			</span>
		</div>
	</div>
</div>

<script id="${name}Tmpl" type="text/x-jsrender">
	<div class="checkbox">
		<label>
			<input type="checkbox" name="${inputName}" value="{{:id}}" checked>
			{{:name}}
		</label>
	</div>
</script>