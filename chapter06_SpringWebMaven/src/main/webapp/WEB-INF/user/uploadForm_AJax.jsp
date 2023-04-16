<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Ajax 통신  -->
<form id="uploadForm">
<table border="1">
		<tr>
			<td>상품명</td>
			<td><input type="text" name="imageName" size="35"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea name="imageContent" rows="15" cols="50"></textarea>
			</td>	
		</tr>
		
		<tr>
			<td colspan="2">
				<!-- 업로드 버튼을 누르기 전에 카메라 아이콘을 통해서 선택한 이미지가 맞는지 확인하기 위해서 이미지를 보이게 한다. -->
				<img id="showImg" width="70" height="70">
			
				<img id="camera" alt="카메라" src="../image/camera.png" width="30" height="30">
				<input type="file" name="img[]" id="img" multiple="multiple" style="visibility: hidden;"> 
			</td>
		</tr> 
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="uploadBtn" value="이미지 등록">
			</td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/upload.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	// 강제 이벤트 발생 
	$('#img').trigger('click');
	
	
});

<!-- 업로드 버튼을 누르기 전에 카메라 아이콘을 통해서 선택한 이미지가 맞는지 확인하기 위해서 이미지를 보이게 한다. -->
$('#img').change(function(){
	readURL(this); //이벤트 발생한 나 img를 들고 글로 이동해. 
});

function readURL(input){
	var reader = new FileReader(); //자바 스크립트 객체임 
	
	reader.onload = function(e){	//읽어들여라 
		$('#showImg').attr('src', e.target.result); //e.target => event 발생한 아이의 결과를 가져와라 
	} 
	reader.readAsDataURL(input.files[0]); //이렇게 하면 첫번째 사진만 불려 들어올 수 있음. 
}
</script>
</html>
