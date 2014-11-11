<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">${t['user.data']}</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="email">${t['user.email']}</label> <input
					type="email" class="form-control" id="email" name="user.email" maxlength="120"
					value="${user.email}" placeholder="Enter ${t['user.email']}">
			</div>
			<div class="form-group">
				<label for="password">${t['user.password']}</label> <input
					type="password" class="form-control" id="password" minlength="6"
					name="user.password" value="${user.password}"
					placeholder="Enter ${t['user.password']}">
			</div>
			<div class="form-group">
				<label for="confirm">${t['user.confirm']}</label> <input
					type="password" class="form-control" id="confirm"
					name="user.confirm" value="${user.confirm}"
					placeholder="Enter ${t['user.confirm']}">
			</div>

			<button class="btn btn-primary">${t['action.save']}&nbsp;${t['user']}</button>
			<a class="btn btn-default" href="${linkTo[info.controller].index()}">${t['action.back']}</a>
		</div>
	</div>
</div>

<div class="col-md-3">
	<c:if test="${not empty user.id}">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">${t['user.properties']}</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="createdAt">${t['createdAt']}</label>
					${user.createdAt.time}
				</div>
				<div class="form-group">
					<label for="updatedAt">${t['updatedAt']}</label>
					${user.updatedAt.time}
				</div>
				<div class="form-group">
					<button id="inactive" class="btn btn-default" type="button"
						onclick="User.active(false)"
						style="display: ${user.active ? 'block' : 'none'}">${t['inactive']}</button>
					<button id="active" class="btn btn-default" type="button"
						onclick="User.active(true)"
						style="display: ${user.active ? 'none' : 'block'}">${t['active']}</button>
				</div>
			</div>
		</div>
	</c:if>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">${t['roles']} (Level: Name)</h3>
		</div>
		<div class="panel-body">
			<c:forEach var="item" items="${roleList}">
				<div class="checkbox">
					<label> 
						<c:set var="checked"
							value="${user.roles.contains(item) ? 'checked': ''}" />
						<input type="checkbox" name="user.roles[].id" value="${item.id}" ${checked} /> ${item.accessLevel}: ${item.name}
					</label>
				</div>
			</c:forEach>
			<div id="roleContainer"></div>
			<div class="input-group input-group-sm">
				<input type="text" id="roleInput" class="form-control"
					placeholder="Add new item" maxlength="80" /> 
				<span class="input-group-btn">
					<button id="rolebutton" class="btn btn-primary" type="button"
					onclick="Backend.Related.add('role', '${linkTo[RoleController].save}')">${t['action.add']}</button>
				</span>
			</div>
		</div>
	</div>


</div>
<script id="roleTmpl" type="text/x-jsrender">
	<div class="checkbox">
		<label>
			<input type="checkbox" name="user.roles[].id" value="{{:id}}" checked/>
			{{:name}}
		</label>
	</div>
</script>