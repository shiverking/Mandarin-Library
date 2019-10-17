$(function() { 
//获取class为caname的元素 
	$(".caname").click(function() { 
//			
			var ID = $("#Email");
			$('#Email').removeAttr("disabled")
			$('#LibrarianName').removeAttr("disabled")
			$('#Password').removeAttr("disabled")
			$('#LibrarianID').removeAttr("disabled")
//			var Name = $("#LibrarianName");
//			var Email=$("#Email");	
//			var Password=$("#Password");
//			
//			var IDtxt = ID.val(); 
//			var Nametxt= Name.val();
//			var Emailtxt= Email.val();
//			var Passwordtxt=Password.val();
//
//			var input1 = $("<input type='text' value='"+Name.val()+"'/>"); 
//			Name.html(input1); 
//			var input2 = $("<input type='text' value='" + Emailtxt + "'/>"); 
//			Email.html(input2); 
//			var input3 = $("<input type='text' value='" + Passwordtxt + "'/>"); 
//			Password.html(input3); 
//			input1.click(function() { return false; }); 
//			input2.click(function() { return false; }); 
//			input3.click(function() { return false; }); 
			//获取焦点 
//			input1.trigger("focus"); 
//			input2.trigger("focus");
//			input3.trigger("focus");
			//文本框失去焦点后提交内容，重新变为文本 
			$("#edit").hide();
			$("#save").show();
	}); 
}); 