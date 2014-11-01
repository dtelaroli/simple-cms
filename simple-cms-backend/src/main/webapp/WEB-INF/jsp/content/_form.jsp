<div class="form-group">
	<label for="title">Title</label>
	<input type="text" class="form-control" id="title" name="content.title" value="${content.title}"
		placeholder="Enter title">
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
