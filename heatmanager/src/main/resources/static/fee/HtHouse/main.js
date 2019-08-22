/**
 * 用户前端主管理JS
 * 模块：login
 * 业务对象:所有用户
 * 作者:马佳国
 * 
 */

$(function(){
	var no = 0;
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
			{ label: '楼号', name: 'building', width: 40 },
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
		pager: "#EmployeeGridPager",
		onSelectRow:function(data){
			no = data ;
		}
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/HtHouse/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加公共建筑",
				width:600,
				close: function (event, ui) {
					$(this).find("form").remove();
					$(this).dialog('destroy');
				}
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
				$("div#DepartmentDialogArea").dialog( "close" ).html("");
			});
		});
	});
	

	
	
	//点击修改按钮事件处理
	$("button#modify").off().on("click",function(event){
		if(no==0){
			BootstrapDialog.show({
	            title: '操作信息',
	            message:"请选择要修改数据"
	        });
		}
		else {
			$("div#DepartmentDialogArea").load("fee/HtHouse/modify.html",function(){
				$.getJSON("/house/getByNo",{houseNo:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						
						$("input[name='houseNo']").val(no);
						$("input[name='houseNo']").attr("readonly","readonly");//设置主键为不可编辑状态
						$("input[name='neighbourhood.hoodNo']").val(data.model.neighbourhood.hoodNo);
						$("input[name='heatingCode']").val(data.model.heatingCode);
						$("input[name='name']").val(data.model.name);
						$("input[name='houseCode']").val(data.model.houseCode);
						$("input[name='building']").val(data.model.building);
						$("input[name='area']").val(data.model.area);
						$("input[name='address']").val(data.model.address);
						$("input[name='postcode']").val(data.model.postcode);
						$("input[name='contactName']").val(data.model.contactName);
						$("input[name='tel']").val(data.model.tel);
						$("input[name='mobile']").val(data.model.mobile);
						$("input[name='mail']").val(data.model.mail);
						$("input[name='qq']").val(data.model.qq);
						$("input[name='heatingStatus']").val(data.model.heatingStatus);
						$("input[name='heatingArea']").val(data.model.heatingArea);
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"公建参数修改",
					width:600,
					close: function (event, ui) {
						$(this).find("form").remove();
						$(this).dialog('destroy');
					}
				});
				//拦截表单提交
				$("form#DepartmentModifyForm").ajaxForm(function(result){
					if(result.status=="ok"){
						$("input[name='houseNo']").removeAttr("readonly");	//去除只读
						$("table#EmployeeGrid").trigger("reloadGrid");
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '操作结果信息',
			            message:result.message
			        });
					$("div#DepartmentDialogArea").dialog( "close" ).html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$("div#DepartmentDialogArea").dialog( "close" ).html("");
				});
			});
			
		}
		
		
	});

	//==============================删除=========
	$("button#delete").off().on("click",function(event){
		if(no==0){
			BootstrapDialog.show({
	            title: '用户操作信息',
	            message:"请选择要操作的用户",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
		BootstrapDialog.confirm('确认删除这条数据?', function(result){
            if(result) {
            	
                $.post("/house/delete",{houseNo:no},function(result){
                	if(result.status=="ok"){
                		$("table#EmployeeGrid").trigger("reloadGrid");
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