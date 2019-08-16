package com.neusoft.ht.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.ht.SystemSafety.model.UserInfo;
import com.neusoft.ht.SystemSafety.service.IUserInfoService;
import com.neusoft.ht.login.Service.IUserBusiness;
import com.neusoft.ht.login.model.AdminUserValue;
import com.neusoft.ht.message.ResultMessage;
@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
	private IUserBusiness user=null;
   @Autowired
    private IUserInfoService user1=null;
	@RequestMapping("/list")
	List<AdminUserValue> getList() throws Exception{
		return user.getListByAll();
	}
	//取得分页列表
	@RequestMapping("list/page")
	public ResultMessage<AdminUserValue> getListWithPage(@RequestParam(required = false,defaultValue ="") String id,@RequestParam(required = false,defaultValue ="") String name,@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page)throws Exception{
		ResultMessage<AdminUserValue> result=new ResultMessage<AdminUserValue>("OK","取得用户列表分页模式成功");
		result.setCount(user.getTotalCount());
		result.setPageCount(user.getPageCount(rows));
		result.setList(user.getListAllWithPages(id,name,rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
		
	}
	@RequestMapping("/add")
	public ResultMessage<AdminUserValue> add(AdminUserValue adminUser,MultipartFile userPhoto) throws Exception {
		
		if(userPhoto!=null && (!userPhoto.isEmpty())) {
			adminUser.getIuser().setPhotoFileName(userPhoto.getOriginalFilename());
			adminUser.getIuser().setPhotoContentType(userPhoto.getContentType());
			adminUser.getIuser().setPhoto(userPhoto.getBytes());
			user.create(adminUser);
			
		}
		return new ResultMessage<AdminUserValue>("OK","增加用户成功");
	}
	
	
	
	  @RequestMapping("/image") 
	  public ResponseEntity<byte[]> getImage() throws Exception{ 
      UserInfo um=user1.getListWithId("799");
      System.out.println(um);
      byte[] bytes=um.getPhoto();
	  System.out.println("开始下载"); 
	  String contentType=um.getPhotoContentType();
	  MultiValueMap<String, String> mult=new LinkedMultiValueMap<String, String>();
	  mult.add("Content-Type", contentType);
	  ResponseEntity<byte[]> resultEntity=new ResponseEntity<byte[]>(bytes,mult,HttpStatus.ACCEPTED);
	  return resultEntity;
	  }
	  
	  @RequestMapping("/delete")
	  public ResultMessage<AdminUserValue> delete(String id) throws Exception{
		  user.delete(id);
		  user1.delete(id);
		  return new ResultMessage<AdminUserValue>("OK","删除用户成功");
	  }
	 
	 
	
}
