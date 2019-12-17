package com.wuyubin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wuyubin.common.ConstantClass;
import com.wuyubin.common.HLUtils;
import com.wuyubin.entity.Article;
import com.wuyubin.entity.Category;
import com.wuyubin.entity.Channel;
import com.wuyubin.entity.Link;
import com.wuyubin.service.ArticleService;
import com.wuyubin.service.CategoryService;
import com.wuyubin.service.ChannelService;
import com.wuyubin.service.LinkService;

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
	
	@Autowired
	LinkService linkService;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * 完成用es搜索的功能
	 */

	@GetMapping("index")
	public String search(Model model, String key, @RequestParam(defaultValue = "1") int page) {
		// 注入es的仓库
		if (page == 0) {
			page = 1;
		}
		
		// 根据标题来搜索
		// List<Article> list = articleResp.findByTitle(key);
		AggregatedPage<?> selectObjects = HLUtils.selectObjects(elasticsearchTemplate, Article.class, page,
				ConstantClass.PAGE_SIZE, new String[] { "title" }, "id", key);
		
		List<Article> list = (List<Article>) selectObjects.getContent();
		
		PageInfo<Article> pageInfo = new PageInfo<>(list);
		pageInfo.setPageNum(page);// 当前页
		pageInfo.setPageSize(ConstantClass.PAGE_SIZE);// 每页显示多少条
		pageInfo.setTotal(selectObjects.getTotalElements());// 总条数
		
		int totalRecord = (int) selectObjects.getTotalElements();
		int pages = totalRecord % ConstantClass.PAGE_SIZE == 0 ? totalRecord / ConstantClass.PAGE_SIZE
				: totalRecord / ConstantClass.PAGE_SIZE + 1;
		pageInfo.setPages(pages);

		if (page == pages) {
			page = pages;
		}
		pageInfo.setPrePage(page - 1);
		pageInfo.setNextPage(page + 1);
		model.addAttribute("hotList", pageInfo);

		model.addAttribute("key", key);
		
		return "index";
	}
	
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
	public String index(HttpServletRequest request,HttpServletResponse reponse, @RequestParam(defaultValue = "1") int page) {

		
		
		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		PageInfo<Article> hotList = articleService.hotList(page);
		
		List<Article> newArticles = articleService.getNewArticles(5);
		
		// 获取最新图片文章
		List<Article> imgArticles = articleService.getImgArticles(10);
		
		// 友情链接
	   PageInfo<Link> info=  linkService.list(1);
	   List<Link> linkList =  info.getList();
	   
	   
		
		
		
		request.setAttribute("hotList", hotList);
		request.setAttribute("newArticles", newArticles);
		
		request.setAttribute("imgArticles", imgArticles);
		
		request.setAttribute("linkList", linkList);
		
		
		
		
		
		
		//
		
		return "index";
	}

}
