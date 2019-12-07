package com.wuyubin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wuyubin.StringUtils;
import com.wuyubin.common.ConstantClass;
import com.wuyubin.common.MsgResult;
import com.wuyubin.entity.Collect;
import com.wuyubin.entity.User;
import com.wuyubin.service.CollectService;
import com.wuyubin.service.impl.CollectServiceImpl;

/**
 *  收藏
 * @author 吴宇斌
 *
 */
@Controller
@RequestMapping("collect")
public class CollectController {
	
	@Autowired
	CollectService collectService;
	
	/**
	 * 
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, 
			@RequestParam(defaultValue="1") int page) {
		
		User loginUser=(User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		
		PageInfo info = collectService.list(loginUser.getId(), page);
		request.setAttribute("info", info);
		return "user/collect/list";
		
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("add")
	public String add(HttpServletRequest request) {
		request.setAttribute("collect", new Collect());
		return "user/collect/add";	 
	}
	@RequestMapping("toAdd.do")
	public String toAdd(Model m){
		
		m.addAttribute("collect", new Collect());
		
		return "user/collect/add";
	}
	
	
	@GetMapping("update")
	public String update(HttpServletRequest request,int id) {
		request.setAttribute("collect", collectService.get(id));
		return "user/collect/update";	 
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	public MsgResult delete(HttpServletRequest request,int id) {
		int result = collectService.delete(id);
		if(result<1)
			return new MsgResult(2,"删除失败",null);
		
		return new MsgResult(1,"删除失败",null);
		
	}
	
	/**
	 * 
	 * @param request
	 * @param collect
	 * @param result
	 * @return
	 */
	@PostMapping("update")
	public String update(HttpServletRequest request,
			@Valid  @ModelAttribute("collect") Collect collect,
			BindingResult result
			) {
		
		if(!StringUtils.isHttpUrl(collect.getUrl())) {
			result.rejectValue("url", "不是合法的url", "不是合法的url");
		}
		
		// 有错误 还在原来的页面
		if(result.hasErrors()) {
			//request.setAttribute("collect", collect);
			return "user/collect/update";	
		}
		
		collectService.update(collect);
		
		// 没有错误跳转到列表页面
		return "redirect:list";
	}
	
	
	/**
	 * 
	 * @param request
	 * @param collect
	 * @param result
	 * @return
	 */
	@PostMapping("add")
	public String add(HttpServletRequest request,
			@Valid  @ModelAttribute("collect") Collect collect,
			BindingResult result
			) {
		
		if(!StringUtils.isHttpUrl(collect.getUrl())) {
			result.rejectValue("url", "不是合法的url", "不是合法的url");
		}
		
		// 有错误 还在原来的页面
		if(result.hasErrors()) {
			
			request.setAttribute("collect", collect);
			return "user/collect/add";	
		}
		
		User loginUser=(User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		collect.setUserId(loginUser.getId());
		collectService.add(collect);
		
		// 没有错误跳转到列表页面
		return "redirect:list";
	}
	@RequestMapping("add")
	public String addCollect(HttpServletRequest request,@Valid@ModelAttribute("collect")Collect collect,BindingResult result){
		
		if (!StringUtils.isHttpUrl(collect.getUrl())) {
			result.rejectValue("url", "", "不是合法的url");
		}
		
		if (result.hasErrors()) {
			return "user/collect/add";
		}
		
		User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		collect.setUserId(loginUser.getId());
		collectService.addCollect(collect);
		
		return "user/collect/list";
	}
	@RequestMapping("deleted.do")
	public boolean deleted(Integer id){
		try {
			collectService.deleted(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
