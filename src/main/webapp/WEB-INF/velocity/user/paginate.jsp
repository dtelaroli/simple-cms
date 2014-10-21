<%@ taglib uri="http://velocity.apache.org/velocity-view" prefix="velocity" %>

<velocity:view>
#set($page_title = "Hello")
#set($layout = "form.vm")


<h2>Users</h2>
first: $first, limit: $limit<br/>
#foreach($user in $userList)
	$user.getId(): $user.getNome()<br/>
#end

$linkTo[$UserController].add()

</velocity:view>
${linkTo[UserController].add()}<br/>
