#set($page_title = "Hello")

<h2>Users</h2>

#foreach($user in $page.list)
	$user.id: $user.name<br/>
#end
<br />
page: $page.number, limit: $page.limit, total: $page.total<br/>

#if($page.number > 1)
	<a href="$linkTo[$UserController].paginate(1, $page.limit)">First</a>
#end

#if($page.hasPrev() && $page.number > 2)
	<a href="$linkTo[$UserController].paginate($page.prev, $page.limit)">Prev</a>
#end

#foreach($i in [1..$page.last])
	<a href="$linkTo[$UserController].paginate($i, $page.limit)">$i</a>
#end

#if($page.hasNext() && $page.number < $page.last - 1)
	<a href="$linkTo[$UserController].paginate($page.next, $page.limit)">Next</a>
#end

#if($page.number < $page.last)
	<a href="$linkTo[$UserController].paginate($page.last, $page.limit)">Last</a>
#end

<form action="$linkTo[$UserController].save()" method="post">
	<input type="text" name="user.name" value="Foo"/>
	<button>Add</button>
</form>

