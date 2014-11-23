<script>
	var User = {
		active : function(active) {
			Backend.Ajax.post('${linkTo[info.controller].active()}', {
				id : '${user.id}',
				active : active
			}, function(result) {
				if (result.active) {
					$('#inactive').show();
					$('#active').hide();
				} else {
					$('#active').show();
					$('#inactive').hide();
				}
			}, 
			'#inactive,#active');
		}
	};
</script>