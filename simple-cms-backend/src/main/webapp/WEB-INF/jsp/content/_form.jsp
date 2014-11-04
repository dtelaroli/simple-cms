<style>
.panel-body .checkbox {
	margin-top: 0;
	margin-bottom: 0;
}

.panel-body .input-group {
	margin-top: 20px;
}
</style>

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

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Categories</h3>
		</div>
		<div class="panel-body">
			<c:forEach var="category" items="${categoryList}">
				<div class="checkbox">
					<label> <input type="checkbox"
						name="content.categories[].id" value="${category.id}"
						${content.categories.contains(category) ? 'checked': ''}>
						${category.name}
					</label>
				</div>
			</c:forEach>
			<div id="categoryContainer"></div>
			<div class="input-group input-group-sm">
				<input type="text" id="category" class="form-control"
					placeholder="Add new category"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button"
						onclick="addCategory()">Add</button>
				</span>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Tags</h3>
		</div>
		<div class="panel-body">
			<c:forEach var="tag" items="${tagList}">
				<div class="checkbox">
					<label> <input type="checkbox" name="content.tags[].id"
						value="${tag.id}" ${content.tags.contains(tag) ? 'checked': ''}>
						${tag.name}
					</label>
				</div>
			</c:forEach>
			<div id="tagContainer"></div>
			<div class="input-group input-group-sm">
				<input type="text" id="tag" class="form-control"
					placeholder="Add new tag"> <span class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="addTag()">Add</button>
				</span>
			</div>
		</div>
	</div>
</div>

<cms:js />
<script>
	tinymce.init({
		selector : '#body',
		height : 500
	});

	function addTag() {
		var tagName = $('#tag').val();
		var json = JSON.stringify({
			tag : {
				name : tagName
			}
		});
		$.ajax({
			url : '${linkTo[TagController].save}',
			type : 'post',
			dataType : 'json',
			contentType : 'application/json',
			data : json,
			success : function(result) {
				var tagTmpl = $.templates("#tagTmpl");
				var html = tagTmpl.render(result);
				$('#tagContainer').append(html);
			},
			error : function(result) {
				console.log('e', result)
			}
		});
	}

	function addCategory() {
		var categoryName = $('#category').val();
		var json = JSON.stringify({
			category : {
				name : categoryName
			}
		});
		$.ajax({
			url : '${linkTo[CategoryController].save}',
			type : 'post',
			dataType : 'json',
			contentType : 'application/json',
			data : json,
			success : function(result) {
				var categoryTmpl = $.templates("#categoryTmpl");
				var html = categoryTmpl.render(result);
				$('#categoryContainer').append(html);
			},
			error : function(result) {
				console.log('e', result)
			}
		});
	}
</script>
<script id="tagTmpl" type="text/x-jsrender">
	<div class="checkbox">
		<label>
			<input type="checkbox" name="content.tags[].id" value="{{:id}}" checked>
			{{:name}}
		</label>
	</div>
</script>
<script id="categoryTmpl" type="text/x-jsrender">
	<div class="checkbox">
		<label>
			<input type="checkbox" name="content.categories[].id" value="{{:id}}" checked>
			{{:name}}
		</label>
	</div>
</script>