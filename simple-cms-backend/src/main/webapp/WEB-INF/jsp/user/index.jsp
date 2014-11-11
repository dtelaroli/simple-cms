<cms:view title="${t['users']}">
	<div class="col-md-2">
		<div class="list-group">
			<a class="list-group-item" href="${linkTo[info.controller].add()}">${t['action.add']}&nbsp;${t['add']}&nbsp;${t['user']}</a>
			<a class="list-group-item" href='<c:url value="/"/>'>${t['action.back']}</a>
			<%-- <a class="list-group-item" href="${linkTo[RoleController].save}">${t['role']}</a> --%>
		</div>
	</div>

	<div class="col-md-10">
		<h2>${t['user']}</h2>

		<table class="table table-condensed table-hover table-striped table-responsive">
			<thead>
				<tr>
					<th>${t['user.email']}</th>
					<th>${t['action']}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${page.list}">
					<tr>
						<td>${user.email}</td>
						<td>
							<cms:actions object="${user}" editAction="${linkTo[info.controller].edit(user.id)}"
								removeAction="${linkTo[info.controller].remove(user.id)}" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<cms:paginate />
	</div>
</cms:view>