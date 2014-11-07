<nav class="navbar navbar-default" role="navigation">
	<header class="container">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Simple CMS Backend / <sitemesh:write property='title'/></a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li role="presentation"
						${info.controller eq UserController ? ' class="active"' : ''}>
						<a href="${linkTo[UserController].index()}">${t['user']}</a>
					</li>
					<li role="presentation"
						${info.controller eq ContentController ? ' class="active"' : ''}>
						<a href="${linkTo[ContentController].index()}">${t['content']}</a>
					</li>
					<li role="presentation">
						<a href="#">Groups</a>
					</li>
				</ul>
			</div>
		</div>
	</header>
</nav>
