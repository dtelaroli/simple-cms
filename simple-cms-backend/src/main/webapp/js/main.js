var Backend = {
	init: function() {
		Backend.Bootstrap.alertClose('.alert');
		Backend.Ajax.errors();
	},
	
	Ajax: {
		errors: function() {
			$(document).ajaxError(function(event, jqxhr, settings, thrownError) {
				switch (jqxhr.status) {
				case 400:
					Backend.Bootstrap.error(jqxhr.responseJSON);
					break;

				default:
					Backend.Bootstrap.error({errors: [{category: 'badRequest', message: 'error.unknown'}]});
					break;
				}
			});
		},
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
				Backend.Bootstrap.success('Item successfully added');
			}, '#' + name + 'button');			
		}
	},
	Bootstrap: {
		alertClose: function(selector) {
			$(selector).delay(10000).slideUp(200, function() {
			    $(this).alert('close');
			});
		},
		error: function(messages) {
			var tmpl = $.templates('#errorTmpl');
			var html = tmpl.render(messages);
			$('#messageContainer').html(html);
			Backend.Bootstrap.alertClose('#bootstrapError');
		},
		success: function(msg) {
			var tmpl = $.templates('#successTmpl');
			var html = tmpl.render({message: msg});
			$('#messageContainer').html(html);
			Backend.Bootstrap.alertClose('#bootstrapSuccess');
		}
	}
};

$(document).ready(function() {
	Backend.init();
});