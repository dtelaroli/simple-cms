#set($page_title = "Hello")

<h2>Users</h2>
page: $page, limit: $limit
#foreach($user in $userList)
	$user.getId(): $user.getNome()
#end
<br />

<a href="$linkTo[$UserController].add()">$linkTo[$UserController].add()</a>

