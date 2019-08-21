/**
 * 
 */
var host="http://localhost:8080/";
$(function(){
	 $.get("/login/getname",function(data,status){
		 $('a#loginname').html(data);
		 console.log(data);
		 console.log(status);
		 var src="http://localhost:8080/user/image/?id="+data+"";
		 $("img#loginimage").attr("src",src);
		 console.log(src);
		  });
    
	 $("a#modifyUser").off().on("click",function(){
		 $("section#maincontent").load("modifyhtml.html",function(){
			 $("section#maincontent").dialog({
					title:"修改信息",
					width:800
				});
		 });
	 });
	//点击左面功能菜单处理
	$("ul#menu_nav li ul li a").on("click",function(event){
		var url=$(this).attr("href");
		
		$("section#maincontent").load(url); //载入对应的对象管理主页
		
		event.preventDefault();  //停止对象的默认行为。

		
	});
	
	
	
	
});
