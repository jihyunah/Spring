$(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/uploadForm_AJax_list',
		dataType: 'json',
		success: function(data){
			console.log(data);
			
			console.log(data.list[0].name);
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#userListTable'));
			}); //each
			
			//페이징 처리 
			
		},
		error: function(err){
			console.log(err);
		}
	});
});