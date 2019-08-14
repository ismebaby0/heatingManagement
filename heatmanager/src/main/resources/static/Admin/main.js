/**
 * 用户前端主管理JS
 * 模块：login
 * 业务对象:所有用户
 * 作者:马佳国
 * 
 */

$(function(){
	var uuserid="lzc";
	var upassword=null;
	var uname=null;
	//设置系统页面标题
	$("span#mainpagetille").html("用户管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: 'user/list/page',
		datatype: "json",
		colModel: [
			{ label: '用户账号', name: 'uuserid', width: 75 },
			{ label: '用户密码', name: 'upassword', width: 90 },
			{ label: '角色名', name: 'uname', width: 100 }                 
		],
		styleUI : 'Bootstrap',
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 20,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "id"},
		pager: "#EmployeeGridPager"
		
	});
//	更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{id:uuserid,name:uname}}).trigger("reloadGrid");
		
	}
	
	//点击检索事件处理
	$("a#EmployeeSearchButton").on("click",function(){
		uuserid=$("input#uuserid").val();
		uname=$("input#uname").val();
//		alert(uname)
		reloadEmployeeList();
	});
	
	
});