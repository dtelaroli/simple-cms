<form role="form" action="$linkTo[$UserController].update()" method="post">
	<input type="hidden" name="_method" value="put"/>
	<input type="hidden" name="user.id" value="$user.id"/>
	#parse('WEB-INF/jsp/user/form.jsp')
</form>