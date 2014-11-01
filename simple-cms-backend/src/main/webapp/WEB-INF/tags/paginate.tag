<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="controller" required="true" type="java.lang.Object" %>
<%@ attribute name="page" required="true" type="java.lang.Object" %>

<ul class="pagination pagination-sm">
	<c:if test="${page.number > 1}">
		<li>
			<a href="${linkTo[controller].index}">&laquo;</a>
		</li>
	</c:if>
	<c:if test="${page.number eq 1}">
		<li class="disabled">
			<a>&laquo;</a>
		</li>
	</c:if>
	<c:if test="${page.hasPrev()}">
		<li>
			<a href="${linkTo[controller].index(page.prev)}">&lsaquo;</a>
		</li>
	</c:if>
	<c:if test="${not page.hasPrev()}">
		<li class="disabled">
			<a>&lsaquo;</a>
		</li>
	</c:if>
	<c:forEach var="i" begin="1" end="${page.last}">
		<c:if test="${i eq page.number}">
			<li class="disabled">
				<a>${i}</a>
			</li>
		</c:if>
		<c:if test="${i ne page.number}">
			<li>
				<a href="${linkTo[controller].index(i)}">${i}</a>
			</li>
		</c:if>
	</c:forEach>
	<c:if test="${page.hasNext()}">
		<li>
			<a href="${linkTo[controller].index(page.next)}">&rsaquo;</a>
		</li>
	</c:if>
	<c:if test="${not page.hasNext()}">
		<li class="disabled">
			<a>&rsaquo;</a>
		</li>
	</c:if>
	<c:if test="${page.number < page.last}">
		<li>
			<a href="${linkTo[controller].index(page.last)}">&raquo;</a>
		</li>
	</c:if>
	<c:if test="${page.number >= page.last}">
		<li class="disabled">
			<a>&raquo;</a>
		</li>
	</c:if>
</ul>