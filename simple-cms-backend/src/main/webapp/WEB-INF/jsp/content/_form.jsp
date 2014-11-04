<div class="col-md-8">
	<div class="form-group">
		<label for="title">Title</label>
		<input type="text" class="form-control" id="title"
			name="content.title" value="${content.title}"
			placeholder="Enter title">
		<input type="hidden" name="content.id" value="${content.id}"/>			
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

	<button class="btn btn-default">Save</button>
</div>

<div class="col-md-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Content properties</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="createdAt">Created at</label>
				${content.createdAt.time}
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
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Categories</h3>
		</div>
		<div class="panel-body">
			<div class="checkbox">
				<label>
					<input type="checkbox" value="">
					Option 1
				</label>
			</div>
			<div class="checkbox">
				<label>
					<input type="checkbox" value="">
					Option 2
				</label>
			</div>
			<div class="input-group input-group-sm">
				<input type="text" class="form-control" placeholder="Add new">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">Add</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Tags</h3>
		</div>
		<div class="panel-body">
			<div id="tagContainer">
			</div>
			<div class="input-group input-group-sm">
				<form>
					<input type="text" id="tag" class="form-control" placeholder="Add new tag">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" onclick="addTag()">Add</button>
					</span>
				</form>
			</div>
			<!-- /input-group -->
		</div>
	</div>
</div>

<cms:js />
<script>
	tinymce.init({
		selector : '#body'
	});
	
	function addTag() {
		var tagName = $('#tag').val();
		var json = JSON.stringify({ tag: { name: tagName }});
		$.ajax({
			url: '${linkTo[TagController].save}',
			type: 'post',
			dataType: 'json',
			contentType: 'application/json',
			data: json,
			success: function(result) {
				var tagTmpl = $.templates("#tagTmpl");
				var html = tagTmpl.render(result);
				$('#tagContainer').append(html);
			},
			error: function(result) {
				console.log('e', result)
			}
		});
	}
</script>
<script id="tagTmpl" type="text/x-jsrender">
	<div class="checkbox">
		<label>
			<input type="checkbox" value="{{:id}}">
			{{:name}}
		</label>
	</div>
</script>