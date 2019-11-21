package com.wuyubin.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.wuyubin.entity.Article;

public class TestArticle extends TestBase{

	@Autowired
	ArticleService articleService;
	
	@Test
	public void testHotList() {
		
		PageInfo<Article> hotList = articleService.hotList(1);
		List<Article> list = hotList.getList();
		list.forEach(a->{
			System.out.println(" a is " + a);
		});
		
		
	}
}
