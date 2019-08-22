/**
 * 用户前端主管理JS 模块：login 业务对象:所有用户
 * 作者:方俊坤
 */

$(function(){
	var complainTypeNo=0;
	// 设置系统页面标题
	$("span#mainpagetille").html("投诉管理");
	// 设置日期的格式和选择
	
	// 显示员工列表
	$("table#ComplainTypeGrid").jqGrid({
		url: '/complaintype/list/page',
		datatype: "json",
		colModel: [
			{ label: '类型编号', name: 'typeNo', width: 50 },
			{ label: '类型名称', name: 'typeName', width: 50 },
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
		pager: "#ComplainTypePager",
		onSelectRow:function(no){
			complainTypeNo=no;
		}
		
	});
	
	// 点击增加链接处理
	$("button#add").off().on("click",function(event){
//		if($("div#ComplainTypeDialogArea").text()!=="")
//			return;
		$("div#ComplainTypeDialogArea").off().load("complain/ComplainType/add.html",function(){
			$("div#ComplainTypeDialogArea").dialog({
				title:"类型名称",
				width:600,
				close: function (event, ui) {
					$(this).find("form").remove();
					$(this).dialog('destroy');
				}
			});
			$("form#addForm").ajaxForm(function(result){
				if(result.status==="OK"){
					alert(result.message);
					$("table#ComplainTypeGrid").trigger("reloadGrid");
				}
			})
			
			// 点击取消
			$("input[value='取消']").on("click",function(event){
				$("div#ComplainTypeDialogArea" ).dialog( "close" ).html("");
			});
		});
	});
	

	//===========================删除投诉类型================================================
	$("#complainTypeDel").off().on("click",function(event){
						if(complainTypeNo===0||complainTypeNo.trim().length===0){
							BootstrapDialog.show({
					            title: '投诉类型信息',
					            message:"请选择要查看的投诉类型",
					            buttons: [{
					                label: '确定',
					                action: function(dialog) {
					                    dialog.close();
					                }
					            }]
					        });
						}
						else{
						BootstrapDialog.confirm('确认删除此投诉类型么?', function(result){
				            if(result) {
				            	
				                $.post("/complaintype/delete",{no:complainTypeNo},function(result){
				                	if(result.status==="OK"){
				                		complainTypeNo="";
				    					$("table#ComplainTypeGrid").trigger("reloadGrid");
									}
									BootstrapDialog.show({
							            title: '投诉类型信息',
							            message:result.message
							        });
				              
				            
					        });
					            }
				
							});
						}
	});

	//----complainTypeUpd 更新
	$("#complainTypeMod").off().on("click",function(event){
		if(complainTypeNo===0||complainTypeNo.trim().length===0){
			BootstrapDialog.show({
	            title: '操作信息',
	            message:"请选择要修改数据"
	        });
		}
		else {
			$("div#ComplainTypeDialogArea").load("complain/complaintype/mod.html",function(){
				$.getJSON("/complaintype/get",{no:complainTypeNo},function(data){	//{}中是请求参数，data是后端返回的结果
					//alert(data.status);
					//alert(data.model.typeName);
					if(data.status==="OK"){
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
						$("input[name='complainTypeNo']").attr("readonly","readonly");//设置主键为不可编辑状态
					}
				});
				
				$("div#ComplainTypeDialogArea" ).dialog({
					title:"公建投诉修改",
					width:600,
					close: function (event, ui) {
						$(this).find("form").remove();
						$(this).dialog('destroy');
					}
				});
				//拦截表单提交
				$("form#modForm").ajaxForm(function(result){
					if(result.status==="OK"){
						complainTypeNo="";
						$("input[name='complainTypeNo']").removeAttr("readonly");	//去除只读
						$("table#ComplainTypeGrid").trigger("reloadGrid");
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '操作结果信息',
			            message:result.message
			        });
					$("div#ComplainTypeDialogArea" ).dialog( "close" ).html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$("div#ComplainTypeDialogArea" ).dialog( "close" ).html("");
				});
			});
			
		}
		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 更新jQGrid的列表显示
// function reloadEmployeeList()
// {
// $("table#EmployeeGrid").jqGrid('setGridParam',{postData:{departmentNo:departmentNo,roleNo:roleNo,sex:sex,startJoinDate:startJoinDate,endJoinDate:endJoinDate}}).trigger("reloadGrid");
//		
// }
//	
// //点击检索事件处理
// $("a#EmployeeSearchButton").on("click",function(){
// departmentNo=$("select#DepartmentSelection").val();
// roleNo=$("select#RoleSelection").val();
// sex=$("input[name='empsex']:checked").val();
//		
// startJoinDate=$("input#startJoinDate").val();
// endJoinDate=$("input#endJoinDate").val();
// if(startJoinDate==""){
// startJoinDate=null;
// }
// if(endJoinDate==""){
// endJoinDate=null;
// }
// reloadEmployeeList();
// });
	
	
});
