<ul class="nav nav-pills" role="tablist">
	<li role="presentation"${controller eq UserController ? 'class="active"' : ''}><a href="${linkTo[UserController].paginate}">User</a></li>
	<li role="presentation"><a href="#">Profile</a></li>
	<li role="presentation"><a href="#">Groups</a></li>
</ul>