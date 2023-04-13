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
					
					$('#updateDiv').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
					$('#pwd').val(data.pwd);
				}
			}, 
			error: function(err){
				console.log(err);
			}
		});//ajax
	});
});


//취소 버튼 
$('#resetBtn').click(function(){
	//강제 이벤트 발생 => .trigger();
	// searchBtn 누른 것과 같은 효과가 resetBtn눌렀을 때 나오게 하기를 바란다. 
	$('#searchIdBtn').trigger('click');
});

//수정 버튼 
$('#updateBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == '') {
		$('#nameDiv').text('이름 입력 ');
		$('#name').focus();
		
	} else if($('#pwd').val() == '') {
		$('#pwdDiv').text('비밀번호 입력 ');
		$('#pwd').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/update',
			data: $('#updateForm').serialize(),
			success: function(){
				alert('회원 정보를 수정하였습니다.')
				location.href='/chapter06_SpringWebMaven/user/list';
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});