<%@ attribute name="id" required="true"%>
<%@ attribute name="msg" required="true"%>
<%@ attribute name="title" required="true"%>

<div class="modal fade" id="${id}" tabindex="-1" role="dialog"
	aria-labelledby="label${id}" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
					<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="label${id}">${title}</h4>
			</div>
			<div class="modal-body">${msg}</div>
			<div class="modal-footer">
				<jsp:doBody/>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>