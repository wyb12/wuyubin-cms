package com.wuyubin.dao;

import java.util.List;

import com.wuyubin.entity.Article;

public interface ArticleMapper {

	/**
	 * 获取最新文章
	 * @param i 获取的个数
	 * @return
	 */
	List<Article> newList(int i);

	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hostList();

}
