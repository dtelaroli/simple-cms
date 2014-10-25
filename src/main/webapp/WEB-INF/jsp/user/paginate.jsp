#set($page_title = "Hello")

<h2>Users</h2>
<a href="$linkTo[$UserController].add()" class="btn btn-default">New
	User</a>

<table
	class="table table-condensed table-hover table-striped table-responsive">
	<thead>
		<tr>
			<th>#</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		#foreach($user in $page.list)
		<tr>
			<td>$user.id</td>
			<td>$user.name</td>
			<td>
				<div class="btn-group">
					<a href="$linkTo[$UserController].edit($user.id)" type="button" class="btn btn-default btn-xs">
						<span class="glyphicon glyphicon-edit"></span>
					</a>
					<a href="$linkTo[$UserController].remove($user.id)" type="button" class="btn btn-default btn-xs">
						<span class="glyphicon glyphicon-remove"></span>
					</a>
				</div>
			</td>
		</tr>
		#end
	</tbody>
</table>

page: $page.number, limit: $page.limit, total: $page.total
<br />

<ul class="pagination btn-xs">

	#if($page.number > 1)
	<li>
		<a href="$linkTo[$UserController].paginate(1, $page.limit)"><<</a>
	</li>
	#else
	<li class="disabled">
		<a><<</a>
	</li>
	#end

	#if($page.hasPrev())
	<li>
		<a href="$linkTo[$UserController].paginate($page.prev, $page.limit)"><</a>
	</li>
	#else
	<li class="disabled">
		<a><</a>
	</li>
	#end
	
	#foreach($i in [1..$page.last])
		#if($i == $page.number)
		<li class="disabled">
			<a>$i</a>
		</li>
		#else
		<li>
			<a href="$linkTo[$UserController].paginate($i, $page.limit)">$i</a>
		</li>
		#end
	#end

	#if($page.hasNext())
	<li>
		<a href="$linkTo[$UserController].paginate($page.next, $page.limit)">></a>
	</li>
	#else
	<li class="disabled">
		<a>></a>
	</li>
	#end
	
	#if($page.number < $page.last)
	<li>
		<a href="$linkTo[$UserController].paginate($page.last, $page.limit)">>></a>
	</li>
	#else
	<li class="disabled">
		<a>>></a>
	</li>
	#end
</ul>