<html>
<head>
<title>Hello</title>
</head>
<body>
	<h2>Users</h2>
	<a href="${linkTo[requestInfo.controller].add()}" class="btn btn-default">New User</a>

	<table class="table table-condensed table-hover table-striped table-responsive">
		<thead>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${page.list}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>
						<cms:actions object="${user}" editAction="${linkTo[requestInfo.controller].edit(user.id)}" 
							removeAction="${linkTo[requestInfo.controller].remove(user.id)}"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<cms:paginate />
</body>
</html>