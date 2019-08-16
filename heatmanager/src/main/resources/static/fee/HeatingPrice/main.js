/**
 * 用户前端主管理JS
 * 模块：login
 * 业务对象:所有用户
 * 作者:马佳国
 * 
 */

$(function(){
	var uuserid=null;
	var upassword=null;
	var uname=null;
	//设置系统页面标题
	$("span#mainpagetille").html("热水价格管理");
	//设置日期的格式和选择
	
	//显示员工列表

	$("table#EmployeeGrid").jqGrid({
		url: '/heatingPrice/getall/page',
		datatype: "json",
		colModel: [
			{ label: '供热年份', name: 'heatingYear', width: 55 },
			{ label: '居民价格', name: 'homePrice', width:55 },
			{ label: '公建价格', name: 'publicHousePrice', width: 55 },
			{ label: '供热天数', name: 'heatingdays', width: 55 },
			{ label: '备注', name: 'heatingMemo', width: 55 },
//			{ label: '价格文件', name: 'priceFile', width: 90 },
			{ label: '文件名', name: 'priceFileName', width: 55 },
			{ label: '文件类型', name: 'priceFileContentType', width: 70 },
			],
		styleUI : 'Bootstrap',
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 10,
		rowList:[2,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "houseNo"},
		pager: "#EmployeeGridPager"
		
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/HeatingPrice/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加热水年份",
				width:600
			});
			$("form#AddForm").ajaxForm(function(result){
				$("div#DepartmentDialogArea").dialog("close");
				$("div#DepartmentDialogArea").dialog("destroy");
				$("div#DepartmentDialogArea").html("");
				if(result.status=="ok"){
					alert(result.message);
					$("table#EmployeeGrid").trigger("reloadGrid");
				}
			})
			
			//点击取消
			$("input[value='取消']").off().on("click",function(event){
				$("div#DepartmentDialogArea").dialog("close");
				$("div#DepartmentDialogArea").dialog("destroy");
				$("div#DepartmentDialogArea").html("");
			});
		});
	});
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//更新jQGrid的列表显示
//	function reloadEmployeeList()
//	{
//		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{departmentNo:departmentNo,roleNo:roleNo,sex:sex,startJoinDate:startJoinDate,endJoinDate:endJoinDate}}).trigger("reloadGrid");
//		
//	}
//	
//	//点击检索事件处理
//	$("a#EmployeeSearchButton").on("click",function(){
//		departmentNo=$("select#DepartmentSelection").val();
//		roleNo=$("select#RoleSelection").val();
//		sex=$("input[name='empsex']:checked").val();
//		
//		startJoinDate=$("input#startJoinDate").val();
//		endJoinDate=$("input#endJoinDate").val();
//		if(startJoinDate==""){
//			startJoinDate=null;
//		}
//		if(endJoinDate==""){
//			endJoinDate=null;
//		}
//		reloadEmployeeList();
//	});
	
	
});