<html>
<head>
<title>Contents</title>
</head>
<body>
	<h2>Content</h2>
	<a href="${linkTo[info.controller].add()}" class="btn btn-default">New Content</a>

	<table class="table table-condensed table-hover table-striped table-responsive">
		<thead>
			<tr>
				<th>Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="content" items="${page.list}">
				<tr>
					<td>${content.title}</td>
					<td>
						<cms:actions object="${content}" editAction="${linkTo[info.controller].edit(content.id)}" 
							removeAction="${linkTo[info.controller].remove(content.id)}"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<cms:paginate />
	<cms:js/>
</body>
</html>