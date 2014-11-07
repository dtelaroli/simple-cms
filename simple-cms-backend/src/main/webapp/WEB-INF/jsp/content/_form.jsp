<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">${t['content.data']}</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="title">${t['title']}</label>
				<input type="text" class="form-control" id="title"
					name="content.title" value="${content.title}"
					placeholder="Enter ${t['title']}">
				<input type="hidden" name="content.id" value="${content.id}" />
			</div>

			<div class="form-group">
				<label for="summary">${t['content.summary']}</label>
				<textarea class="form-control" id="summary" name="content.summary"
					placeholder="Enter ${t['content.summary']}">${content.summary}</textarea>
			</div>

			<div class="form-group">
				<label for="body">${t['content.body']}</label>
				<textarea class="form-control" id="body" name="content.body"
					placeholder="Enter ${t['content.body']}">${content.body}</textarea>
			</div>

			<button class="btn btn-primary">${t['action.save']}&nbsp;${t['content']}</button>
			<a class="btn btn-default" href="${linkTo[info.controller].index()}">${t['action.back']}</a>
		</div>
	</div>
</div>

<div class="col-md-3">
	<c:if test="${not empty content.id}">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">${t['content.properties']}</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="createdAt">${t['createdAt']}</label>
					${content.createdAt.time}
				</div>
				<div class="form-group">
					<label for="updatedAt">${t['updatedAt']}</label>
					${content.updatedAt.time}
				</div>
				<div class="form-group">
					<button id="draft" class="btn btn-default" type="button"
						onclick="Content.publish(false)"
						style="display: ${content.published ? 'block' : 'none'}">${t['draft']}</button>
					<button id="publish" class="btn btn-default" type="button"
						onclick="Content.publish(true)"
						style="display: ${content.published ? 'none' : 'block'}">${t['publish']}</button>
				</div>
			</div>
		</div>
	</c:if>

	<cms:relatedBox saved="${content.category}"
		controller="${CategoryController}" inputName="content.category.id"
		name="category" listAll="${categoryList}" title="${t['category']}" />

	<cms:relatedBox saved="${content.tags}" controller="${TagController}"
		inputName="content.tags[].id" name="tag" listAll="${tagList}"
		title="${t['tag']}" multiple="true" />

</div>
