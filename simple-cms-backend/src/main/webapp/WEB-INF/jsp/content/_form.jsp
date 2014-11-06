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
					<button id="draft" class="btn btn-default" type="button" onclick="Content.publish(false)" 
						style="display: ${content.published ? 'block' : 'none'}">Draft</button>
					<button id="publish" class="btn btn-default" type="button" onclick="Content.publish(true)"
						style="display: ${content.published ? 'none' : 'block'}">Publish</button>
				</div>
			</div>
		</div>
	</c:if>

	<cms:relatedBox saved="${content.category}" controller="${CategoryController}" 
		inputName="content.category.id" name="category" listAll="${categoryList}" title="Category" />
		
	<cms:relatedBox saved="${content.tags}" controller="${TagController}" 
		inputName="content.tags[].id" name="tag" listAll="${tagList}" title="Tags" multiple="true"/>
		
</div>

<cms:js />

<script>
	tinymce.init({
		selector : '#body',
		height : 400,
		plugins: 'emoticons autosave table autolink anchor code hr image link lists media preview spellchecker wordcount visualchars pagebreak',
	    toolbar: 'table code image link anchor emoticons spellchecker preview',

	});
	
	var Content = {
		init: function() {
			
		},
		publish: function(publish) {
			Backend.Ajax.post('${linkTo[info.controller].publish()}', {id: '${content.id}', publish: publish}, function(result) {
				if(result.published) {
					$('#draft').show();
					$('#publish').hide();
				}
				else {
					$('#publish').show();
					$('#draft').hide();
				}
			}, '#draft,#publish');
		}
	};
</script>