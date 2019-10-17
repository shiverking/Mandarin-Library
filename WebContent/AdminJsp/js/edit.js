$(function() { 
//获取class为caname的元素 
	$(".caname").click(function() { 
//			
			$('#Email').removeAttr("readonly")
			$('#LibrarianName').attr("readonly","readonly")
			$('#Password').removeAttr("readonly")
			$('#LibrarianID').removeAttr("readonly")
			$("#edit").hide();
			$("#save").show();
	}); 
}); 