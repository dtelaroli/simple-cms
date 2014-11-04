<style>
.panel-body .checkbox {
	margin-top: 0;
	margin-bottom: 0;
}

.panel-body .input-group {
	margin-top: 20px;
}
</style>
<cms:js />
<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Content data</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" name="content.title"
					value="${content.title}" placeholder="Enter title"> <input
					type="hidden" name="content.id" value="${content.id}" />
			</div>

			<div class="form-group">
				<label for="summary">Summary</label>
				<textarea class="form-control" id="summary" name="content.summary"
					placeholder="Enter summary">${content.summary}</textarea>
			</div>

			<div class="form-group">
				<label for="body">Body</label>
				<textarea class="form-control" id="body" name="content.body"
					placeholder="Enter body">${content.body}</textarea>
			</div>

			<button class="btn btn-default">Save Content</button>
		</div>
	</div>
</div>

<div class="col-md-3">
	<c:if test="${not empty content.id}">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Content properties</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="createdAt">Created at</label> ${content.createdAt.time}
				</div>
				<div class="form-group">
					<label for="updatedAt">Last update</label>
					${content.updatedAt.time}
				</div>
				<div class="form-group">
					<c:if test="${content.published}">
						<button class="btn btn-default" type="button">Draft</button>
					</c:if>
					<c:if test="${not content.published}">
						<button class="btn btn-default" type="button">Publish</button>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>

	<cms:relatedBox listSaved="${content.categories}" controller="${CategoryController}" 
		inputName="content.categories[].id" name="category" listAll="${categoryList}" title="Categories"/>
		
	<cms:relatedBox listSaved="${content.tags}" controller="${TagController}" 
		inputName="content.tags[].id" name="tag" listAll="${tagList}" title="Tags"/>
		
</div>

<script>
	tinymce.init({
		selector : '#body',
		height : 500
	});

	function add(name, url) {
		var nameObj= $('#' + name + 'Input').val();
		var obj = {};
		obj[name] = {
			name : nameObj
		};
		
		$.ajax({
			url : url,
			type : 'post',
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(obj),
			success : function(result) {
				var tmpl = $.templates('#' + name + 'Tmpl');
				var html = tmpl.render(result);
				$('#' + name + 'Container').append(html);
				$('#' + name + 'Input').val('');
			},
			error : function(result) {
				console.log('e', result)
			}
		});
	}
</script>