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
	$("span#mainpagetille").html("用户管理");
	//设置日期的格式和选择
	
	//显示员工列表

	$("table#EmployeeGrid").jqGrid({
		url: '/house/getAll/page',
		datatype: "json",
		colModel: [
			{ label: '公建序号', name: 'houseNo', width: 55 },
			{ label: '小区编号', name: 'neighbourhood.hoodNo', width:55 },
			{ label: '供热编码', name: 'heatingCode', width: 55 },
			{ label: '公建名称', name: 'name', width: 55 },
			{ label: '公建编号', name: 'houseCode', width: 55 },
			{ label: '楼号', name: 'building', width: 30 },
			{ label: '建筑面积', name: 'area', width: 55 },
			{ label: '地址', name: 'address', width: 90 },
			{ label: '邮编', name: 'postcode', width: 55 },
			{ label: '联系人姓名', name: 'contactName', width: 70 },
			{ label: '电话', name: 'tel', width: 55 },
			{ label: '手机', name: 'mobile', width: 90 },
			{ label: 'Mail', name: 'mail', width: 100 },
			{ label: 'QQ', name: 'qq', width: 60 },
			{ label: '供热状态', name: 'heatingStatus', width: 50 },
			{ label: '实际供热面积', name: 'heatingArea', width: 80 },
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
		$("div#DepartmentDialogArea").load("fee/HtHouse/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加公共建筑",
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