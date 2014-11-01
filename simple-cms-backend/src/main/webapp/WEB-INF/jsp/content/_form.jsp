<div class="col-md-8">
	<div class="form-group">
		<label for="title">Title</label>
		<input type="text" class="form-control" id="title" name="content.title" value="${content.title}"
			placeholder="Enter title">
	</div>

	<div class="form-group">
		<label for="summary">Summary</label>
		<textarea class="form-control" id="summary" name="content.summary" placeholder="Enter summary">${content.summary}</textarea>
	</div>

	<div class="form-group">
		<label for="body">Body</label>
		<textarea class="form-control" id="body" name="content.body" placeholder="Enter body">${content.body}</textarea>
	</div>

	<button class="btn btn-default">Save</button>
</div>

<div class="col-md-4">
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
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Add new">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">Save</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
	</div>
</div>