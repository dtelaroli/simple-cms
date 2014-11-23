<c:if test="${not empty message}">
	<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			<span class="sr-only">Close</span>
		</button>
		${t[message]}
	</div>
</c:if>
<c:if test="${not empty errors}">
	<div class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			<span class="sr-only">Close</span>
		</button>
		<c:forEach var="error" items="${errors}">
			<strong>${t[error.category]}</strong>: ${error.message}<br />
		</c:forEach>
	</div>
</c:if>
<c:if test="${not empty error}">
	<div class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			<span class="sr-only">Close</span>
		</button>
		${error}
	</div>
</c:if>

<div id="messageContainer"></div>
<script id="successTmpl" type="text/x-jsrender">
	<div id="bootstrapSuccess" class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			<span class="sr-only">Close</span>
		</button>
		{{if message}}
			{{:message}}
		{{else}}
			Operation was successful
		{{/if}}
	</div>
</script>
<script id="errorTmpl" type="text/x-jsrender">
	<div id="bootstrapError" class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			<span class="sr-only">Close</span>
		</button>
		{{for errors}}
			{{:category}} - {{:message}}<br />
		{{/for}}
	</div>	
</script>