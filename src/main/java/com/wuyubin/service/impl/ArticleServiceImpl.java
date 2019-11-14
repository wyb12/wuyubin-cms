package com.wuyubin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuyubin.common.ConstantClass;
import com.wuyubin.dao.ArticleMapper;
import com.wuyubin.entity.Article;
import com.wuyubin.service.ArticleService;

/**
 * 
 * @author zhuzg
 *
 */
@Service
public class ArticleServiceImpl  implements ArticleService{
	
	@Autowired
	ArticleMapper articleMapper;
	

	@Override
	public List<Article> getNewArticles(int i) {
		// TODO Auto-generated method stub
		return articleMapper.newList(i);
	}

	@Override
	public PageInfo<Article> hotList(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		return new PageInfo<Article>(articleMapper.hostList());
		
	}

}
