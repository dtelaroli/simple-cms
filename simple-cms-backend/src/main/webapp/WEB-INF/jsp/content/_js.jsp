<script>
	tinymce.init({
		selector : '#body',
		height : 400,
		plugins : 'emoticons table autolink anchor code hr image media link preview spellchecker pagebreak lists searchreplace',
		menubar : false,
		toolbar1 : 'undo redo | alignleft aligncenter alignright | indent outdent | '
				+ 'bold italic underline strikethrough | subscript superscript | table code | image media emoticons | link anchor',
		toolbar2 : 'formatselect fontselect fontsizeselect removeformat | bullist numlist pagebreak | search searchreplace | spellchecker preview'
	});

	var Content = {
		publish : function(publish) {
			Backend.Ajax.post('${linkTo[info.controller].publish()}', {
				id : '${content.id}',
				publish : publish
			}, function(result) {
				if (result.published) {
					$('#draft').show();
					$('#publish').hide();
				} else {
					$('#publish').show();
					$('#draft').hide();
				}
			}, 
			'#draft,#publish');
		}
	};
</script>