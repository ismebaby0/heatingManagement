/**
 * 用户前端主管理JS
 * 模块：login
 * 业务对象:所有用户
 * 作者:马佳国
 * 
 */

$(function(){

	var no = 0;
	var name = null;
	//设置系统页面标题
	$("span#mainpagetille").html("用户管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: '/HouseType/getall/page',
		datatype: "json",
		colModel: [
			{ label: '户型编号', name: 'typeNo', width: 75 },
			{ label: '户型名', name: 'typeName', width: 90 },
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
		pager: "#EmployeeGridPager",
		onSelectRow:function(data){
			no = data ;
		}
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/HouseType/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加房子类型",
				width:500
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
	
	
	//修改按钮	//点击修改按钮事件处理
	$("button#modify").off().on("click",function(event){
		if(no==0){
			BootstrapDialog.show({
	            title: '操作信息',
	            message:"请选择要修改数据"
	        });
		}
		else {
			$("div#DepartmentDialogArea").load("fee/HouseType/modify.html",function(){
				$.getJSON("/HouseType/getbyno",{typeNo:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						
						$("input[name='typeNo']").val(no);
						$("input[name='typeNo']").attr("readonly","readonly");//设置主键为不可编辑状态
						$("input[name='typeName']").val(data.model.typeName);
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"房子类型修改",
					width:600
				});
				//拦截表单提交
				$("form#DepartmentModifyForm").ajaxForm(function(result){
					if(result.status=="ok"){
						$("input[name='typeNo']").removeAttr("readonly");	//去除只读
						$("table#EmployeeGrid").trigger("reloadGrid");
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '操作结果信息',
			            message:result.message
			        });
					$("div#DepartmentDialogArea" ).dialog( "close" );
					$("div#DepartmentDialogArea" ).dialog( "destroy" );
					$("div#DepartmentDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#DepartmentDialogArea" ).dialog( "close" );
					$( "div#DepartmentDialogArea" ).dialog( "destroy" );
					$("div#DepartmentDialogArea").html("");
				});
			});
			
		}
		
		
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