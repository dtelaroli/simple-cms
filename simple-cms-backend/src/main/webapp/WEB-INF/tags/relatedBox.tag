<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cms"%>

<%@ attribute name="saved" required="true" type="java.lang.Object"%>
<%@ attribute name="listAll" required="true" type="java.lang.Object"%>
<%@ attribute name="inputName" required="true"%>
<%@ attribute name="controller" required="true" type="java.lang.Object"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="multiple" required="false" type="java.lang.Boolean"%>

<c:set var="type" value="${multiple ? 'checkbox' : 'radio'}"/>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${title}</h3>
	</div>
	<div class="panel-body">
		<c:forEach var="item" items="${listAll}">
			<div class="${type}">
				<label> 
					<c:set var="checked" value="${(not multiple and saved eq item) or (multiple and saved.contains(item)) ? 'checked': ''}"/>
					<input type="${type}" name="${inputName}" value="${item.id}" ${checked}/>
					${item.name}
				</label>
			</div>
		</c:forEach>
		<div id="${name}Container"></div>
		<div class="input-group input-group-sm">
			<input type="text" id="${name}Input" class="form-control"
				placeholder="Add new item"/> 
			<span class="input-group-btn">
				<button id="${name}button" class="btn btn-default" type="button" onclick="Backend.Related.add('${name}', '${linkTo[controller].save}')">Add</button>
			</span>
		</div>
	</div>
</div>

<script id="${name}Tmpl" type="text/x-jsrender">
	<div class="${type}">
		<label>
			<input type="${type}" name="${inputName}" value="{{:id}}" checked/>
			{{:name}}
		</label>
	</div>
</script>