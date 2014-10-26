<html>
<head>
<title>Hello</title>
</head>
<body>
	<h2>Users</h2>
	<a href="${linkTo[UserController].add()}" class="btn btn-default">New User</a>

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
						<form action="${linkTo[UserController].remove(user.id)}" method="post" id="formDelete${user.id}">
							<input type="hidden" name="_method" value="delete"/>
							<div class="btn-group">
								<a href="${linkTo[UserController].edit(user.id)}" type="button"
									class="btn btn-default btn-xs">
									<span class="glyphicon glyphicon-edit"></span>
								</a>
								<button class="btn btn-default btn-xs" name="_method" value="delete" data-toggle="modal"
									data-target="#confirm${user.id}" type="button">
									<span class="glyphicon glyphicon-remove"></span>
								</button>

								<div class="modal fade" id="confirm${user.id}" tabindex="-1" role="dialog"
									aria-labelledby="modalLabel${user.id}" aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">&times;</span>
													<span class="sr-only">Close</span>
												</button>
												<h4 class="modal-title" id="modalLabel${user.id}">Delete User #${user.id}</h4>
											</div>
											<div class="modal-body">Are you sure?</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
												<button type="button" class="btn btn-primary" onclick="$('#formDelete${user.id}').submit()">Delete</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<x:paginate controller="${UserController}" page="${page}" />
</body>
</html>