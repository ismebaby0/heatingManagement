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
		url: '/HouseFeePayRecord/getall/page',
		datatype: "json",
		colModel: [
			{ label: '缴费序号', name: 'recordNo', width: 75 },
			{ label: '公建供热序号', name: 'houseFee.feeNo', width: 90 },
			{ label: '交款方式编号', name: 'paymentType.typeno', width: 75 },
			{ label: '缴费日期', name: 'payDate', width: 90 },
			{ label: '缴费金额', name: 'payAmount', width: 75 },
			{ label: '缴费人', name: 'payPerson', width: 90 },
			{ label: '支票编号', name: 'checkCode', width: 75 },
			{ label: '发票编号', name: 'invoiceCode', width: 90 },
			{ label: '缴费备注', name: 'payDesc', width: 75 },
			{ label: '处理状态', name: 'recordStatus', width: 90 },
			
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
		      id: "recordNo"},
		pager: "#EmployeeGridPager",
		onSelectRow:function(data){
			no = data ;
		}
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/HouseFeePayRecord/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加缴费记录",
				width:500,
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
			$("div#DepartmentDialogArea").load("fee/HouseFeePayRecord/modify.html",function(){
				$.getJSON("/HouseFeePayRecord/getByNo",{recordNo:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						
						$("input[name='recordNo']").val(no);
						$("input[name='recordNo']").attr("readonly","readonly");//设置主键为不可编辑状态
						$("input[name='houseFee.feeNo']").val(data.model.houseFee.feeNo);
						$("input[name='paymentType.typeno']").val(data.model.paymentType.typeno);
						$("input[name='payDate']").val(data.model.payDate);
						$("input[name='payAmount']").val(data.model.payAmount);
						$("input[name='payPerson']").val(data.model.payPerson);
						$("input[name='checkCode']").val(data.model.checkCode);
						$("input[name='invoiceCode']").val(data.model.invoiceCode);
						$("input[name='payDesc']").val(data.model.payDesc);
						$("input[name='recordStatus']").val(data.model.recordStatus);
						
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"缴费记录修改",
					width:600,
					close: function (event, ui) {
						$(this).find("form").remove();
						$(this).dialog('destroy');
					}
				});
				//拦截表单提交
				$("form#DepartmentModifyForm").ajaxForm(function(result){
					if(result.status=="ok"){
						$("input[name='recordNo']").removeAttr("readonly");	//去除只读
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
            	
                $.post("/HouseFeePayRecord/delete",{recordNo:no},function(result){
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