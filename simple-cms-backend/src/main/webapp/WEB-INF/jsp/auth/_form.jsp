<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">${t['login']}</h3>
	</div>
	<div class="panel-body">
		<div class="form-group">
			<label for="username">${t['username']}</label>
			<input type="text" class="form-control" id="username" name="username" value="${username}"
				placeholder="Enter ${t['username']}">
		</div>

		<div class="form-group">
			<label for="password">${t['password']}</label>
			<input type="password" class="form-control" id="password" name="password" placeholder="Enter ${t['password']}"
				value="${password}" />
		</div>

		<div class="form-group">
			<input type="checkbox" class="form-control" id="remember" name="remember" placeholder="Enter ${t['remember']}"
				value="true" />
			<label for="password">${t['remember']}</label>
		</div>

		<button class="btn btn-primary">${t['action.login']}</button>
	</div>
</div>
