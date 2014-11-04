var Backend = {
	Related: {
		add: function(name, url) {
			var nameObj= $('#' + name + 'Input').val();
			var obj = {};
			obj[name] = {
				name : nameObj
			};
			
			$.ajax({
				url : url,
				type : 'post',
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify(obj),
				success : function(result) {
					var tmpl = $.templates('#' + name + 'Tmpl');
					var html = tmpl.render(result);
					$('#' + name + 'Container').append(html);
					$('#' + name + 'Input').val('');
				},
				error : function(result) {
					console.log('e', result)
				}
			});
		}
	}
};