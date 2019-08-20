

$(function(){
	var no = 0;

	//设置系统页面标题
	$("span#mainpagetille").html("小区管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: '/home/getall',
		datatype: "json",
		colModel: [
			{ label: '居民序号', name: 'homeNo', width: 75 },
			{ label: '供热编码', name: 'heatingCode', width: 75 },
			{ label: '姓名',     name: 'homeName', width: 75 },
			{ label: '楼号',     name: 'buildingCode', width: 75 },
			{ label: '单元',     name: 'departmentCode', width: 75 },
			{ label: '楼层',     name: 'floorCode', width: 75 },
			{ label: '房屋编号', name: 'houseCode', width: 75 },
			{ label: '建筑面积', name: 'homeArea', width: 75 },
			{ label: '朝向',     name: 'direction', width: 75 },
			{ label: '电话',     name: 'tel', width: 75 },
			{ label: '手机',     name: 'mobile', width: 75 },
			{ label: '邮箱',     name: 'mail', width: 75 },
			{ label: 'QQ',       name: 'qq', width: 75 },
			{ label: '供热状态', name: 'heatingStatus', width: 75 },
			{ label: '实际供热面积', name: 'heatingArea', width: 75 },
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
		      id: "homeNo"},
		pager: "#EmployeeGridPager",
		onSelectRow :function(data){
			no = data ;
		}
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/home/add.html",function(){
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
			$("div#DepartmentDialogArea").load("fee/Home/modify.html",function(){
				$.getJSON("/home/getone/withrelation",{homeNo:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						
						$("input[name='homeNo']").val(no);
						$("input[name='homeNo']").attr("readonly","readonly");//设置主键为不可编辑状态
						$("input[name='houseTypeNo.typeNo']").val(data.model.houseTypeNo.typeNo);
						$("input[name='hoodNo.hoodNo']").val(data.model.hoodNo.hoodNo);
						$("input[name='heatingCode']").val(data.model.heatingCode);
						$("input[name='homeName']").val(data.model.homeName);
						$("input[name='buildingCode']").val(data.model.buildingCode);
						$("input[name='departmentCode']").val(data.model.departmentCode);
						$("input[name='floorCode']").val(data.model.floorCode);
						$("input[name='houseCode']").val(data.model.houseCode);
						$("input[name='homeArea']").val(data.model.homeArea);
						$("input[name='direction']").val(data.model.direction);
						$("input[name='tel']").val(data.model.tel);
						$("input[name='mobile']").val(data.model.mobile);
						$("input[name='mail']").val(data.model.mail);
						$("input[name='qq']").val(data.model.qq);
						$("input[name='heatingStatus']").val(data.model.heatingStatus);
						$("input[name='heatingArea']").val(data.model.heatingArea);
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
            	
                $.post("/home/delete",{homeNo:no},function(result){
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