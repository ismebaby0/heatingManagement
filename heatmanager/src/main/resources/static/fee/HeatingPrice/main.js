/**
 * 用户前端主管理JS
 * 模块：login
 * 业务对象:所有用户
 * 作者:马佳国
 * 
 */

$(function(){
	var no = null;
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
		      id: "heatingYear"},
		pager: "#EmployeeGridPager" ,
		onSelectRow:function(data){
			no = data ;
		}
		
	});
	
	//点击增加链接处理
	$("button#add").off().on("click",function(event){
		$("div#DepartmentDialogArea").load("fee/HeatingPrice/add.html",function(){
			$("div#DepartmentDialogArea").dialog({
				title:"添加热水年份",
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
		if(no==null){
			BootstrapDialog.show({
	            title: '操作信息',
	            message:"请选择要修改数据"
	        });
		}
		else {
			$("div#DepartmentDialogArea").load("fee/HeatingPrice/modify.html",function(){
				$.getJSON("/heatingPrice/getByNo",{heatingYear:no},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status=="ok"){
						
						$("input[name='heatingYear']").val(no);
						$("input[name='heatingYear']").attr("readonly","readonly");//设置主键为不可编辑状态
						$("input[name='heatingYear']").val(data.model.heatingYear);
						$("input[name='homePrice']").val(data.model.homePrice);
						$("input[name='publicHousePrice']").val(data.model.publicHousePrice);
						$("input[name='heatingdays']").val(data.model.heatingdays);
						$("input[name='heatingMemo']").val(data.model.heatingMemo);
						$("input[name='priceFileName']").val(data.model.priceFileName);
						$("input[name='priceFileContentType']").val(data.model.priceFileContentType);
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"修改热水信息",
					width:600,
					close: function (event, ui) {
						$(this).find("form").remove();
						$(this).dialog('destroy');
					}
				});
				//拦截表单提交
				$("form#DepartmentModifyForm").ajaxForm(function(result){
					if(result.status=="ok"){
						$("input[name='heatingYear']").removeAttr("readonly");	//去除只读
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
		if(no==null){
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
            	
                $.post("/heatingPrice/delete",{heatingYear:no},function(result){
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
        	
        	
        	

        	
        	
        });