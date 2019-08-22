

$(function(){
	var no = 0;
	var name = null;
	var adr = null;
	//设置系统页面标题
	$("span#mainpagetille").html("住宅供热缴费");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: '/homefeerecord/list/page',
		datatype: "json",
		colModel: [
			{ label: '居民缴费序号', name: 'recordNo', width: 50 },
			{ label: '居民供热序号', name: 'homeFeeNo.feeNo', width: 50 },
			{ label: '缴费方式编号', name: 'paymentTypeNo.typeNo', width: 50 },
			{ label: '缴费日期', name: 'payDate', width: 50 },
			{ label: '缴费金额', name: 'payAmount', width: 50 },
			{ label: '缴费人', name: 'payPerson', width: 50 },
			{ label: '支票编号', name: 'checkCode', width: 50 },
			{ label: '收据编号', name: 'invoiceCode', width: 50 },
			{ label: '缴费备注', name: 'payDesc', width: 50 },
			{ label: '记录状态', name: 'recordStatus', width: 50 }
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
		$("div#DepartmentDialogArea").load("fee/homefeerecord/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加类型",
				width:500,
				close: function (event, ui) {
					$(this).find("form").remove();
					$(this).dialog('destroy');
				}
			});
			$("form#AddForm").ajaxForm(function(result){
				$("div#DepartmentDialogArea").dialog("close").html("");
				if(result.status=="ok"){
					alert(result.message);
					$("table#EmployeeGrid").trigger("reloadGrid");
				}
				
			})
			
			//点击取消
			$("input[value='取消']").off().on("click",function(event){
				$("div#DepartmentDialogArea").dialog("close").html("");
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
			$("div#DepartmentDialogArea").load("fee/homefeerecord/modify.html",function(){
				$.getJSON("/homefeerecord/get",{no:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						//$("#modForm input").each((k, v) =>console.log(v.name+v.value));
						$("#modForm input").each((k, v) => {//遍历表单设置值
							let nameJsonValue = null;
							if(v.name.trim().length>0){
								nameJsonValue = eval(`data.model.${v.name}`);
								if (nameJsonValue !== null) {
									if(v.type==="date"){
										v.value= nameJsonValue.split('T')[0];
									}else{
										v.value = nameJsonValue;	
									}
								}
							}
						}); 
						$("input[name='recordNo']").attr("readonly","readonly");//设置主键为不可编辑状态
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"信息修改",
					width:600,
					close: function (event, ui) {
						$(this).find("form").remove();
						$(this).dialog('destroy');
					}
				});
				//拦截表单提交
				$("form#modForm").ajaxForm(function(result){
					if(result.status=="ok"){
						$("table#EmployeeGrid").trigger("reloadGrid");
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '操作结果信息',
			            message:result.message
			        });
					$("div#DepartmentDialogArea").dialog("close").html("");
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$("div#DepartmentDialogArea").dialog("close").html("");
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
            	
                $.post("/homefeerecord/delete",{typeNo:no},function(result){
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