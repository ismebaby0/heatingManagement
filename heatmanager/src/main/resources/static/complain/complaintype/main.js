/**
 * 用户前端主管理JS 模块：login 业务对象:所有用户 作者:马佳国
 * 
 */

$(function(){
	var uuserid=null;
	var upassword=null;
	var uname=null;
	// 设置系统页面标题
	$("span#mainpagetille").html("投诉管理");
	// 设置日期的格式和选择
	
	// 显示员工列表
	$("table#ComplainTypeGrid").jqGrid({
		url: '/complaintype/list/page',
		datatype: "json",
		colModel: [
			{ label: '类型编号', name: 'typeNo', width: 50 },
			{ label: '类型名称', name: 'typeName', width: 50 },
			],
		styleUI : 'Bootstrap',
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 10,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "typeNo"},
		pager: "#ComplainTypePager"
		
	});
	
	// 点击增加链接处理
	$("button#add").off().on("click",function(event){
//		if($("div#homeComplainTypeDialogArea").text()!=="")
//			return;
		$("div#ComplainTypeDialogArea").off().load("complain/ComplainType/add.html",function(){
			$("div#ComplainTypeDialogArea").dialog({
				title:"类型名称",
				width:600
			});
			$("form#addForm").ajaxForm(function(result){
				$("div#ComplainTypeDialogArea").dialog("close");
				$("div#ComplainTypeDialogArea").dialog("destroy");
				$("div#ComplainTypeDialogArea").html("");
				if(result.status==="OK"){
					alert(result.message);
					$("table#ComplainTypeGrid").trigger("reloadGrid");
				}
			})
			
			// 点击取消
			$("input[value='取消']").on("click",function(event){
				$("div#ComplainTypeDialogArea").dialog("close");
				$("div#ComplainTypeDialogArea").dialog("destroy");
				$("div#ComplainTypeDialogArea").html("");
			});
		});
	});
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 更新jQGrid的列表显示
// function reloadEmployeeList()
// {
// $("table#EmployeeGrid").jqGrid('setGridParam',{postData:{departmentNo:departmentNo,roleNo:roleNo,sex:sex,startJoinDate:startJoinDate,endJoinDate:endJoinDate}}).trigger("reloadGrid");
//		
// }
//	
// //点击检索事件处理
// $("a#EmployeeSearchButton").on("click",function(){
// departmentNo=$("select#DepartmentSelection").val();
// roleNo=$("select#RoleSelection").val();
// sex=$("input[name='empsex']:checked").val();
//		
// startJoinDate=$("input#startJoinDate").val();
// endJoinDate=$("input#endJoinDate").val();
// if(startJoinDate==""){
// startJoinDate=null;
// }
// if(endJoinDate==""){
// endJoinDate=null;
// }
// reloadEmployeeList();
// });
	
	
});