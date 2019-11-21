package com.wuyubin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wuyubin.entity.Article;
import com.wuyubin.entity.Category;
import com.wuyubin.entity.Channel;
import com.wuyubin.service.ArticleService;
import com.wuyubin.service.CategoryService;
import com.wuyubin.service.ChannelService;

@Controller
public class IndexController {

	/**
	 * 注入频道
	 */
	@Autowired
	ChannelService channelService;
	
	
	@Autowired
	CategoryService categoryService;
	
	
	@Autowired
	ArticleService articleService;

	
	/**
	 * 
	 * @param request
	 * @param chnId  频道id
	 * @param page  文章页码
	 * @return
	 */
	@RequestMapping( "channel")
	public String channel(HttpServletRequest request, 
			@RequestParam(defaultValue = "1") int chnId,
			@RequestParam(defaultValue = "0") int categoryId,
			@RequestParam(defaultValue = "1") int page) {
		
		
		// 回传参数数值
		request.setAttribute("chnId", chnId);
		request.setAttribute("categoryId", categoryId);
		
		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		// 获取这个频道下的所有的分类
		List<Category> categories =  categoryService.listByChannelId(chnId);
		request.setAttribute("categories", categories);
		
		PageInfo<Article> articles=  articleService.listByCat(chnId,categoryId,page);
		request.setAttribute("articles", articles);
		
		
		
		return "channelindex";
	
	}
		
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = { "index", "/" })
	public String index(HttpServletRequest request, @RequestParam(defaultValue = "1") int page) {

		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		PageInfo<Article> hotList = articleService.hotList(page);
		
		List<Article> newArticles = articleService.getNewArticles(5);
		
		request.setAttribute("hotList", hotList);
		request.setAttribute("newArticles", newArticles);
		
		
		
		
		//
		
		return "index";
	}

}
