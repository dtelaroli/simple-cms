#set($page_title = "Hello")

<h2>User - View</h2>
$user.id: $user.name
<br />

<a href="$linkTo[$UserController].paginate(1, 2)">All</a>

