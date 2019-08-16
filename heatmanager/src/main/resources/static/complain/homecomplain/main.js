/**
 * 住宅投诉管理前端主管理JS 模块：complain 业务对象:所有住宅投诉
 *  作者:方俊坤
 * 
 */

$(function(){
	// 设置系统页面标题
	$("span#mainpagetille").html("住宅投诉管理");
	// 设置日期的格式和选择
	
	// 显示住宅投诉列表
	$("table#homeComplainTypeGrid").jqGrid({
		url: '/homecomplain/list',
		datatype: "json",
		colModel: [
			{ label: '投诉序号', name: 'complainNo', width: 5 },
			{ label: '居民编号', name: 'home.homeNo', width: 5 },
			{ label: '投诉类型编号', name: 'complainType.typeNo', width: 5 },
			{ label: '投诉标题', name: 'complainTitle', width: 5 },
			{ label: '投诉内容', name: 'complainContent', width: 5 },
			{ label: '投诉要求', name: 'requestContent', width: 5 },
			{ label: '投诉日期', name: 'complainDate', width: 5 },
			{ label: '投诉人姓名', name: 'contactPerson', width: 5 },
			{ label: '电话', name: 'tel', width: 5 },
			{ label: '手机', name: 'mobile', width: 5 },
			{ label: 'Mail', name: 'mail', width: 5 },
			{ label: 'QQ', name: 'qq', width: 5 },
			{ label: '开始维修时间', name: 'serviceStartDate', width: 5 },
			{ label: '维修结束时间', name: 'serviceEndDate', width: 5 },
			{ label: '维修人', name: 'serviceContent', width: 5 },
			{ label: '回访时间', name: 'servicePerson', width: 5 },
			{ label: '客户意见', name: 'feedBackDate', width: 5 },
			{ label: '客户意见', name: 'homeComment', width: 5 },
			{ label: '保险出险时间', name: 'assuranceDate', width: 5 },
			{ label: '保险金额', name: 'assuranceFee', width: 5 },
			{ label: '保险理赔时间', name: 'assurancePayDate', width: 5 },
			{ label: '投诉状态', name: 'complainStatus', width: 5 },
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
		      id: "complainNo"},
		pager: "#homeComplainTypePager"
		
	});
	
	// 点击增加链接处理
	$("button#homeComplainAdd").off().on("click",function(event){
//		if($("div#homeComplainTypeDialogArea").text()!=="")
//			return;
		$("div#homeComplainTypeDialogArea").off().load("complain/homecomplain/add.html",function(){
			$.getJSON("home/getAllHome",function(data){
				var datalisthtml="";
				data.list.forEach(e=>datalisthtml +="<option value='"+e.homeNo+"'>"+e.homeName+"</option>"); 
				$("datalist#homeNoList").append(datalisthtml);
			});

			$.getJSON("complaintype/list",function(data){
				var datalisthtml="";
				data.list.forEach(e=>datalisthtml +="<option value='"+e.typeNo+"'>"+e.typeName+"</option>"); 
				$("datalist#typeNoList").append(datalisthtml);
			});
			$("div#homeComplainTypeDialogArea").dialog({
				title:"住宅投诉记录添加",
				width:600
			});
			$("form#addForm").ajaxForm(function(result){
				$("div#homeComplainTypeDialogArea").dialog("close");
				$("div#homeComplainTypeDialogArea").dialog("destroy");
				$("div#homeComplainTypeDialogArea").html("");
				if(result.status==="OK"){
					alert(result.message);
					$("table#homeComplainTypeGrid").trigger("reloadGrid");
				}
			})
			
			// 点击取消
			$("input[value='取消']").on("click",function(event){
				$("div#homeComplainTypeDialogArea").dialog("close");
				$("div#homeComplainTypeDialogArea").dialog("destroy");
				$("div#homeComplainTypeDialogArea").html("");
			});
		});
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