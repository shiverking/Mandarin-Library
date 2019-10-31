function check()
{
	var p=$('exampleInputPassword1')
	var np=$('exampleInputConfirmPassword1')
	if(p!=np)
	{

		var t=setTimeout("The password is inconsistent with the confirmation password",5000)
		return false
	}
	else
	{
		document.forms['Register'].action="librariansignup";
		document.forms['Register'].submit();
		
	}

}
