#set($page_title = "Hello")

<h2>Users</h2>

#foreach($user in $page.list)
	$user.id: $user.name<br/>
#end
<br />
page: $page.number, limit: $page.limit, total: $page.total<br/>

<form action="$linkTo[$UserController].save()" method="post">
	<input type="text" name="user.name" value="Foo"/>
	<button>Add</button>
</form>

