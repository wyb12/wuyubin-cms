package com.wuyubin.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wuyubin.entity.Article;

/**
 * @author 吴宇斌
 *
 * 2019年12月17日
 */
public interface EsArticleMapper extends ElasticsearchRepository<Article, Integer>{
	public List<Article> findByTitle(String key);
}
