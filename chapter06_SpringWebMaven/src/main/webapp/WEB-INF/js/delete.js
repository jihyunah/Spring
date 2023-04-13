$(function(){
	$('#updateDiv').hide();
	
	//아이디 찾기 
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		$.ajax({
			type:'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id=' + $('#searchId').val(),
			//dataType: 지정 안하면, spring이 알아서 정해준다. 
			//아이디가 없으면 userDTO가 json으로 오지만, 아이디가 없으면
			//json으로 오지 못한다. 그래서 dataType을 생략한다. (오는대로 지정해줌)
			success: function(data){
				console.log(JSON.stringify(data)); //데이터 값 찍어보기 
				
				if(data == '') {
					$('#updateDiv').hide();
					
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다.');
					$('#resultDiv').css('color', 'red').css('font-weight', 'bold');
				}
				
				else {
					//삭제 
					if(confirm('삭제하시겠습니까?')) {
						$.ajax({
							type:'post',
							url: '/chapter06_SpringWebMaven/user/delete',
							data: 'id=' + $('#searchId').val(),
							success: function(){
								alert('회원 정보를 삭제하였습니다.');
								location.href="/chapter06_SpringWebMaven/user/list";
							},
							error: function(err){
								console.log(err);
							}
						});
					} //if
				}
			}, 
			error: function(err){
				console.log(err);
			}
		});//ajax
	});
});