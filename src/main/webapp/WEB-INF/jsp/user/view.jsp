#set($page_title = "Hello")

<h2>User - View</h2>
$user.getId(): $user.getNome()
<br />

<a href="$linkTo[$UserController].index()">All</a>

