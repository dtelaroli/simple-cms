<cms:view title="Contents">
	<div class="col-md-2">
		<div class="list-group">
			<a class="list-group-item" href="${linkTo[info.controller].add()}">${t['action.add']}&nbsp;${t['add']}&nbsp;${t['content']}</a>
			<a class="list-group-item" href='<c:url value="/"/>'>${t['action.back']}</a>
			<a class="list-group-item" href="${linkTo[CategoryController].save}">${t['category']}</a>
			<a class="list-group-item" href="${linkTo[TagController].save}">${t['tag']}</a>
		</div>
	</div>

	<div class="col-md-10">
		<h2>${t['content']}</h2>

		<table
			class="table table-condensed table-hover table-striped table-responsive">
			<thead>
				<tr>
					<th>${t['title']}</th>
					<th>${t['action']}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="content" items="${page.list}">
					<tr>
						<td>${content.title}</td>
						<td class="col-md-1">
							<cms:actions object="${content}"
								editAction="${linkTo[info.controller].edit(content.id)}"
								removeAction="${linkTo[info.controller].remove(content.id)}" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<cms:paginate />
	</div>
</cms:view>
