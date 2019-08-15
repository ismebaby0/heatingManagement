package com.neusoft.ht.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.ht.SystemSafety.model.UserInfo;
import com.neusoft.ht.login.Service.IUserBusiness;
import com.neusoft.ht.login.model.AdminUserValue;
import com.neusoft.ht.message.ResultMessage;
@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
	private IUserBusiness user=null;
	@RequestMapping("/list")
	List<AdminUserValue> getList() throws Exception{
		return user.getListByAll();
	}
	//取得分页列表
	@RequestMapping("list/page")
	public ResultMessage<AdminUserValue> getListWithPage(@RequestParam(required = false,defaultValue ="") String id,@RequestParam(required = false,defaultValue ="") String name,@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
		ResultMessage<AdminUserValue> result=new ResultMessage<AdminUserValue>("OK","取得部门列表分页模式成功");
		result.setCount(user.getTotalCount());
		result.setPageCount(user.getPageCount(rows));
		result.setList(user.getListAllWithPages(id,name,rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
		
	}
	@RequestMapping("/add")
	public ResultMessage<AdminUserValue> add(AdminUserValue iuser, MultipartFile userPhoto) throws Exception {
		if(userPhoto!=null && (!userPhoto.isEmpty())) {
			iuser.getIuser().setPhotoFileName(userPhoto.getOriginalFilename());
			iuser.getIuser().setPhotoContentType(userPhoto.getContentType());
			iuser.getIuser().setPhoto(userPhoto.getBytes());
			user.create(iuser);
		}
		return new ResultMessage<AdminUserValue>("OK","增加员工成功");
	}
}
