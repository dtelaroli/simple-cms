#foreach($user in $userList)
	$user.id: $user.nome<br />
#end

<a href="$linkTo[$UserController].add()">Add</a>