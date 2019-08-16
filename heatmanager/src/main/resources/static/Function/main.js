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
	$("span#mainpagetille").html("功能管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: 'function/list/page',
		datatype: "json",
		colModel: [
			{ label: '功能名', name: 'funName', width: 75 },
			{ label: '功能等级', name: 'levelNo', width: 90 }          
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
		alert(uname)
		reloadEmployeeList();
	});
	
	/*//===========================增加员工处理================================================
	$("a#EmployeeAddLink").off().on("click",function(){
		$("div#EmployeeDialog").load("Admin/add.html",function(){
			//取得部门列表，并填充部门下拉框
			
			//取得角色列表，生成角色选择下拉框
			
			//验证员工提交数据
			$("form#EmployeeAddForm").validate({
				  rules: {
				    id: {
				      required: true,
//				      remote: host+"employee/checkidexist"
				      
				    },
				    password:{
				    	required: true
				    },
				    age:{
				    	number: true,
				    	min:18,
				    	max:60,
				    	range: [18, 60]
				    },
				    name:{
				    	required:true
				    },
				    mobile:{
				    	required:true,
				    	mobile:true
				    	
				    }
				  },
				  messages:{
					id: {
					      required: "账号为空"
				      
					    },
					name:{
					    	required:"用户名为空"
					},
					age:{
						number: "年龄必须是数值",
				    	range:"年龄需要在18和60之间"
					}
				 }
			});
			//拦截增加提交表单
			$("form#EmployeeAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadEmployeeList();//更新员工列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '部门操作信息',
		            message:result.message
		        });
				$("div#DepartmentDialogArea" ).dialog( "close" );
				$("div#DepartmentDialogArea" ).dialog( "destroy" );
				$("div#DepartmentDialogArea").html("");
				
			});
			
			
			$("div#EmployeeDialog").dialog({
				title:"员工增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#EmployeeDialog").dialog("close");
				$("div#EmployeeDialog").dialog("destroy")
				$("div#EmployeeDialog").html("");
			});
			
			
		});
		
	});
	*/
	
	
});