<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">${t['user.data']}</h3>
		</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="username">${t['user.username']}</label>
				<input type="text" class="form-control" id="name" name="user.username" value="${user.username}"
					placeholder="Enter ${t['user.username']}">
			</div>
			<div class="form-group">
				<label for="password">${t['user.password']}</label>
				<input type="password" class="form-control" id="password" name="user.password" value="${user.password}"
					placeholder="Enter ${t['user.password']}">
			</div>
			<div class="form-group">
				<label for="confirm">${t['user.confirm']}</label>
				<input type="password" class="form-control" id="confirm" name="user.confirm" value="${user.confirm}"
					placeholder="Enter ${t['user.confirm']}">
			</div>
			
			<button class="btn btn-primary">${t['action.save']}&nbsp;${t['user']}</button>
			<a class="btn btn-default" href="${linkTo[info.controller].index()}">${t['action.back']}</a>
		</div>
	</div>
</div>

<div class="col-md-3">
	<c:if test="${not empty user.id}">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">${t['user.properties']}</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="createdAt">${t['createdAt']}</label>
					${user.createdAt.time}
				</div>
				<div class="form-group">
					<label for="updatedAt">${t['updatedAt']}</label>
					${user.updatedAt.time}
				</div>
				<div class="form-group">
					<button id="inactive" class="btn btn-default" type="button"
						onclick="User.active(false)"
						style="display: ${user.active ? 'block' : 'none'}">${t['inactive']}</button>
					<button id="active" class="btn btn-default" type="button"
						onclick="User.active(true)"
						style="display: ${user.active ? 'none' : 'block'}">${t['active']}</button>
				</div>
			</div>
		</div>
	</c:if>

</div>