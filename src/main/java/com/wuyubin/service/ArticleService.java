package com.wuyubin.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wuyubin.entity.Article;

public interface ArticleService {

	/**
	 * 获取最新文章
	 * @param i  获取的个数
	 * @return
	 */
	List<Article> getNewArticles(int i);

	/**
	 * 获取热门文章
	 * @param page
	 * @return
	 */
	PageInfo<Article> hotList(int page);
	

}
