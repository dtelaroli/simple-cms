var Backend = {
	Ajax: {
		post: function(url, data, callback, loader) {
			$.ajax({
				url : url,
				type : 'post',
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : callback,
				beforeSend: function() {
					if(loader) {
						var tmpl = $.templates('#loader');
						var html = tmpl.render();
						$(loader).append(html);
						$(loader).prop('disabled', true);
					}
					
					NProgress.start();
				},
				complete: function() {
					if(loader) {
						$('.ajaxloader').remove();
						$(loader).prop('disabled', false);
					}
					
					NProgress.done();
				}
			});
		}
	},
	Related: {
		add: function(name, url) {
			var nameObj= $('#' + name + 'Input').val();
			var obj = {};
			obj[name] = {
				name : nameObj
			};
			
			Backend.Ajax.post(url, obj, function(result) {
				var tmpl = $.templates('#' + name + 'Tmpl');
				var html = tmpl.render(result);
				$('#' + name + 'Container').append(html);
				$('#' + name + 'Input').val('');
			}, '#' + name + 'button');			
		}
	}
};