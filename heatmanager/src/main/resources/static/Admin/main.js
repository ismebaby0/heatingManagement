/**
 * 用户前端主管理JS
 * 模块：login
 * 业务对象:所有用户
 * 作者:马佳国
 * 
 */

$(function(){
	var uuserid="";
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
			{ label: '用户账号', name: 'iuser.uuserid', width: 75 },
			{ label: '用户密码', name: 'upassword', width: 90 },
			{ label: '用户名', name: 'uname', width: 100 }                 
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
		      id: "iuser.uuserid"},
		pager: "#EmployeeGridPager",
			onSelectRow:function(empid){
				uuserid=empid;
			}
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
		reloadEmployeeList();
	});
	
	//===========================增加用户处理================================================
	$("a#EmployeeAddLink").off().on("click",function(){
		$("div#EmployeeDialog").load("Admin/add.html",function(){
			//取得部门列表，并填充部门下拉框
			
			//取得角色列表，生成角色选择下拉框
			
			//验证员工提交数据
			$("form#EmployeeAddForm").validate({
				  rules: {
					  "iuser.uuserid":{
				      required: true,
//				      remote: host+"employee/checkidexist"
				      
				    },
				    upassword:{
				    	required: true
				    },
				    "iuser.age":{
				    	number: true,
				    	min:18,
				    	max:60,
				    	range: [18, 60]
				    },
				    uname:{
				    	required:true
				    },
				    "iuser.mobile":{
				    	required:true,
				    	mobile:true
				    	
				    }
				  },
				  messages:{
					  "iuser.uuserid": {
					      required: "账号为空"
				      
					    },
					    uname:{
					    	required:"用户名为空"
					},
					"iuser.age":{
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
				$("div#EmployeeDialog").dialog("close");
				$("div#EmployeeDialog").dialog("destroy")
				$("div#EmployeeDialog").html("");
				
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
	//===========================删除用户处理================================================
$("a#EmployeeDelteLink").off().on("click",function(event){
					if(uuserid==null||uuserid==""){
						BootstrapDialog.show({
				            title: '员工操作信息',
				            message:"请选择要查看的员工",
				            buttons: [{
				                label: '确定',
				                action: function(dialog) {
				                    dialog.close();
				                }
				            }]
				        });
					}
					else{
					BootstrapDialog.confirm('确认删除此部门么?', function(result){
			            if(result) {
			            	
			                $.post("user/delete",{id:uuserid},function(result){
			                	if(result.status=="OK"){
			                		uuserid="";
			                		reloadEmployeeList();//更新员工列表
								}
								BootstrapDialog.show({
						            title: '部门操作信息',
						            message:result.message
						        });
			              
			            
			        });
			            }
		
	});
					}
});
//===========================查看用户详情================================================
$("a#EmployeeViewLink").off().on("click",function(){
	if(uuserid==null||uuserid==""){
		BootstrapDialog.show({
            title: '员工操作信息',
            message:"请选择要查看的员工",
            buttons: [{
                label: '确定',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
	}
	else{
		$("div#EmployeeDialog").load("Admin/view.html",function(){
			//取得指定的员工信息
			$.getJSON("userinfo/functionList",{id:uuserid},function(em){
				if(em){
					$("span#employeeId").html(uuserid);
					$("span#employeeName").html(em.admin.uname);
					$("span#employeeSex").html(em.sex);
					$("span#empage").html(em.age);
					$("span#empmobile").html(em.mobile);
					$("span#empphone").html(em.phone);
					if(em.functionss){
						$.each(em.functions,function(index,Function){
							$("span#empfunctions").append(Function.funName+"  ");
						});
					}
/*					if(em.photoFileName!=null&&em.photoFileName!=""){
						$("span#empphoto").html("<img src='user/image' class='img-thumbnail' alt='Cinque Terre' width='200'");
					}
					else{
						$("span#empphoto").html("<img src='user/image' class='img-thumbnail' alt='Cinque Terre' width='200'");
					}*/
					
				}
			});
			
			
			$("div#EmployeeDialog").dialog({
				title:"员工详细",
				width:800
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='关闭']").off().on("click",function(){
				$("div#EmployeeDialog").dialog("close");
				$("div#EmployeeDialog").dialog("destroy")
				$("div#EmployeeDialog").html("");
			});
			
			
		});
	}
	
	
	
});

});