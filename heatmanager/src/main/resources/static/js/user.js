$(function(){

	$.post("userinfo/functionList?id=admin",function(data,status){
		console.log(data.uuserid);
		$("input[name='uuserid']").val(data.uuserid);
	})
	
	
	
	
	
	
	
	
	
	
	
});
