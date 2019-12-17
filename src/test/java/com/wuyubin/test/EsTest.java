package com.wuyubin.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuyubin.dao.ArticleMapper;
import com.wuyubin.dao.EsArticleMapper;
import com.wuyubin.entity.Article;

/**
 * @author 吴宇斌
 *
 * 2019年12月17日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class EsTest {
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private EsArticleMapper esArticleMapper;
	
	@Test
	public void getAll() {
		List<Article> list = articleMapper.findAll();
		esArticleMapper.saveAll(list);
	}
}
