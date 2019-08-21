

$(function(){
	var no = 0;
	var name = null;
	var adr = null;
	//设置系统页面标题
	$("span#mainpagetille").html("小区管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: '/homefee/getall/withpage',
		datatype: "json",
		colModel: [
			{ label: '缴费序号', name: 'feeNo', width: 75 },
			{ label: '居民编号', name: 'homeNo.homeNo', width: 75 },
			{ label: '年份', name: 'heatingYear.heatingYear', width: 75 },
			{ label: '供热面积', name: 'heatArea', width: 90 },
			{ label: '应缴费', name: 'agreeFee', width: 75},
			{ label: '实缴费', name: 'actualFee', width: 75},
			{ label: '欠缴费', name: 'debtFee', width: 75},
			{ label: '缴费转态', name: 'feeStatus', width: 75},
			{ label: '实际供热天数', name: 'heatingdays', width: 75},
			{ label: '备注', name: 'feeDesc', width: 75},
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
		      id: "feeNo"},
		pager: "#EmployeeGridPager",
		onSelectRow:function(data){
			no = data ;
		}
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/HomeFee/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加居民收费表数据",
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
			$("div#DepartmentDialogArea").load("fee/HomeFee/modify.html",function(){

				$.getJSON("/homefee/getone/withrelation",{feeNo:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						
						$("input[name='feeNo']").val(no);
						$("input[name='feeNo']").attr("readonly","readonly");//设置主键为不可编辑状态
						$("input[name='homeNo.homeNo']").val(data.model.homeNo.homeNo);
						$("input[name='heatingYear.heatingYear']").val(data.model.heatingYear.heatingYear);
						$("input[name='heatArea']").val(data.model.heatArea);
						$("input[name='agreeFee']").val(data.model.agreeFee);
						$("input[name='actualFee']").val(data.model.actualFee);
						$("input[name='debtFee']").val(data.model.debtFee);
						$("input[name='feeStatus']").val(data.model.feeStatus);
						$("input[name='heatingdays']").val(data.model.heatingdays);
						$("input[name='feeDesc']").val(data.model.feeDesc);
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"小区信息修改",
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
			            message:result.message,
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

	
//==============================删除================
	$("button#delete").off().on("click",function(event){
		if(no==0){
			BootstrapDialog.show({
	            title: '用户操作信息',
	            message:"请选择要操作的数据",
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
                $.post("/homefee/delete",{feeNo:no},function(result){
                	if(result.status=="ok"){
                		$("table#EmployeeGrid").trigger("reloadGrid");
					}
					BootstrapDialog.show({
			            title: '操作结果',
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